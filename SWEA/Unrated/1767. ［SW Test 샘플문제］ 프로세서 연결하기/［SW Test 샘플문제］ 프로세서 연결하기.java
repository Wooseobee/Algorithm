import java.io.*;
import java.util.*;

/*
 * 메모리 : 23,936 kb
 * 실행시간 : 209 ms
 */
public class Solution {

	// 배열크기, 최대 연결가능 core 개수, 최소길이의 전선, 탐색할 core의 크기, 현재 연결된 core 수, 현재 사용한 전선의 길이
	private static int n, maxCoreSize, minLen, totalCoreSize, cnt, line;
	private static List<int[]> coreList;	// 탐색할 core의 위치가 담긴 리스트
	private static int[][] map;	// 멕시노스
	// 상,좌,우,하,제자리
	private static int[] dx = { -1, 0, 0, 1, 0 };
	private static int[] dy = { 0, -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	// 한 번에 출력하기 위해 StringBuilder 사용

		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 수 입력 받기
		for (int t = 1; t <= T; t++) {	// 테스트 케이스 수 만큼 반복문 실행
			n = Integer.parseInt(br.readLine());	// 멕시노스 크기 입력 받기

			// 초기값 세팅
			map = new int[n][n];
			maxCoreSize = 0;
			minLen = Integer.MAX_VALUE;
			coreList = new ArrayList<>();
			
			//멕시노스 정보 입력 받기
			for (int i = 0; i < n; i++) {
				String[] in = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(in[j]);
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i != 0 && j != 0 && i != n - 1 && j != n - 1) {
						if (map[i][j] == 1) {
							coreList.add(new int[] { i, j });	// 탐색할 core 위치 기록하기
						}
					}
				}
			}

			totalCoreSize = coreList.size();
			setDirection(0);

			sb.append("#").append(t).append(" ").append(minLen).append("\n");
		}

		System.out.println(sb);	// 정답 출력
		br.close();
	}

	// 해당 방향으로 전선을 놓을 수 있는지 확인
	private static boolean checkDir(int idx, int dir) {
		int[] now = coreList.get(idx);
		int i = now[0];
		int j = now[1];
		int nI = i + dx[dir];
		int nJ = j + dy[dir];
		while (in(nI, nJ)) {
			if (map[nI][nJ] != 0) {
				return false;
			}
			nI += dx[dir];
			nJ += dy[dir];
		}
		return true;
	}

	private static void setDirection(int depth) {
		if (depth == totalCoreSize) {	// 모든 core에 전선을 놓았다면
			if (maxCoreSize < cnt) {	// 더 많은 core를 연결할 수 있다면 최소길이 갱신
				maxCoreSize = cnt;
				minLen = line;
			} else if (maxCoreSize == cnt) {	// 연결가능한 core의 수가 같다면
				minLen = Math.min(minLen, line);	// 최소길이 갱신
			}
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (i == 4 || checkDir(depth, i)) {	// 전선을 놓을 수 있다면
				if (i != 4) {
					setMap(depth, i);	// 멕시노스에 전선 놓기
				}

				setDirection(depth + 1);	// 다음 core 전선 놓으러 가기

				if (i != 4) {
					reSetMap(depth, i);	// 멕시노스에 놓은 전선 회수
				}
			}
		}
	}

	// 전선 놓기
	private static void setMap(int idx, int dir) {
		int[] now = coreList.get(idx);
		int i = now[0];
		int j = now[1];
		int nI = i + dx[dir];
		int nJ = j + dy[dir];
		int l = 0;	// 사용한 전선 길이
		while (in(nI, nJ)) {	// 전선을 놓을 수 있을 때까지
			if (map[nI][nJ] == 0) {	// 전선 놓기
				map[nI][nJ] = 2;	// 전선은 2로 표현
			} else {
				return;	// 전선을 놓을 수 없다면 리턴
			}
			l++;	// 사용한 전선 길이 + 1
			nI += dx[dir];
			nJ += dy[dir];
		}
		cnt++;	// 연결가능한 core 수 + 1
		line += l;	// 연결할 때까지 사용한 전선의 길이 더해주기
	}

	// 전선 복구
	private static void reSetMap(int idx, int dir) {
		int[] now = coreList.get(idx);
		int i = now[0];
		int j = now[1];
		int nI = i + dx[dir];
		int nJ = j + dy[dir];
		int l = 0;	// 사용했던 전선의 길이
		while (in(nI, nJ)) {	// 전선을 놓을 수 있을 때까지
			if (map[nI][nJ] != 0) {	// 전선이라면
				map[nI][nJ] = 0;	// 전선 회수
			} else {
				return;	// 전선이 아니라면 리턴
			}
			l++;	// 사용한 전선의 길이 + 1
			nI += dx[dir];
			nJ += dy[dir];
		}
		cnt--;	// 연결가능한 core 수 - 1
		line -= l;	// 사용한 전선 빼주기
	}

	// 멕시노스 범위 안인지 확인하는 메소드
	private static boolean in(int nI, int nJ) {
		return nI >= 0 && nJ >= 0 && nI < n && nJ < n;
	}
}