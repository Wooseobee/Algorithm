import java.io.*;
import java.util.*;

public class Main {

	private static int n, m, d, max = 0; // 격자판, 사거리, 최대 제거가능 수
	private static int[] archer = new int[3]; // 궁수 3명
	private static int[][] map; // 격자판

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 격자판 크기, 사거리 입력 받기
		String[] in = br.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);
		d = Integer.parseInt(in[2]);

		map = new int[n + 1][m]; // 격자판 초기화 및 세팅

		for (int i = 0; i < n; i++) {
			in = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(in[j]);
			}
		}

		setArcher(0, 0);
		System.out.println(max);	// 최대 제거 수 출력
		br.close();
	}

	// 궁수의 위치 조합 => 순서 상관없이 m개 중 3개 뽑기
	private static void setArcher(int depth, int idx) {
		if (depth == 3) {
			playGame();
			return;
		}
		for (int i = idx; i < m; i++) {
			archer[depth] = i;
			setArcher(depth + 1, i + 1);
		}
	}

	// 적들은 가만히, 궁수가 한칸씩 위로 이동
	private static void playGame() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		Set<String>[] killList = new HashSet[n + 1];	// 죽인 적의 좌표를 저장할 Set 라운드 수 만큼 배열 크기 지정
		int kill = 0;	// 죽인 적의 총합
		int[][] tmpMap = new int[n][m]; // 복사할 격자판
		for (int i = 0; i < n; i++) {
			tmpMap[i] = Arrays.copyOf(map[i], m);
		}
		
		for (int i = 0; i <= n; i++) {	// Set 초기화
			killList[i] = new HashSet<String>();
		}

		// 초기 궁수 위치 넣기
		for (int i = 0; i < 3; i++) {
			q.add(new int[] { n, archer[i], i, 1 });
		}

		while (!q.isEmpty()) {

			int[] now = q.poll();

			// 현재 궁수 위치
			int i = now[0];
			int j = now[1];
			int order = now[2]; // 궁수 순번
			int round = now[3]; // 몇번째 경기인지

			// 적을 죽일 수 있는 위치 초기 == 현재 궁수 위치 바로 위
			int nI = i - 1;
			int nJ = j;
			int dist = 1; // 거리 == 1

			// 궁수가 공격하는 우선순위 : 가장 가까운 적 -> 가장 왼쪽의 적
			PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> {
				if (o1[2] == o2[2]) {
					return o1[1] - o2[1];
				}
				return o1[2] - o2[2];
			});

			// 궁수가 죽일 수 있는 적의 위치는 격자판 안에 있으며, 거리<=사거리
			while (nI >= 0 && nJ < m && dist <= d) {
				int tmpDist = dist;

				// 좌우로 탐색
				for (int k = 0; tmpDist <= d; k++) {
					if (nJ - k >= 0 && tmpMap[nI][nJ - k] == 1) { // 왼쪽 탐색
						pq.add(new int[] { nI, nJ - k, tmpDist });	// 적을 죽일 수 있다면, pq에 추가
					}
					if (nJ + k < m && tmpMap[nI][nJ + k] == 1) { // 오른쪽 탐색
						pq.add(new int[] { nI, nJ + k, tmpDist });	// 적을 죽일 수 있다면, pq에 추가
					}
					tmpDist = Math.abs(i - nI) + Math.abs(j - nJ) + k + 1;	// 거리 증가시키기
				}

				// 한 칸 더 위의 적 탐색, 거리++
				nI--;
				dist++;
			}

			// 궁수가 0번째 줄에 도달하면 게임 종료
			if (i - 1 > 0) {
				q.add(new int[] { i - 1, j, order, round + 1 });
			}

			// 적의 위치 추출
			if (!pq.isEmpty()) {
				int[] killed = pq.poll();
				killList[round].add(killed[0] + " " + killed[1]);
			}

			// 한 라운드가 끝날 때마다 죽인 적의 위치 0으로 세팅
			if (order == 2) {
				for (String kL : killList[round]) {
					String[] coord = kL.split(" ");
					tmpMap[Integer.parseInt(coord[0])][Integer.parseInt(coord[1])] = 0;
					kill++;	// 죽인 적의 수 더하기
				}
			}
		}
		max = Math.max(max, kill);
	}
}