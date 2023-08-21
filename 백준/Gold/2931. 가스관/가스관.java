import java.io.*;
import java.util.*;

public class Main {

	// 상, 좌, 우, 하
	private static int[] dx = { -1, 0, 0, 1 };
	private static int[] dy = { 0, -1, 1, 0 };
	private static int n, m; // 도면의 크기 n,m
	private static char[][] map; // 도면
	private static int[] ans; // 정답의 위치를 담을 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader
		StringBuilder sb = new StringBuilder(); // 테스트 케이스 한번에 출력하기 위한 StringBuilder
		String[] in = br.readLine().split(" ");

		// 도면의 크기 입력받기
		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);

		map = new char[n][m]; // 도면 초기화
		int[] erasedCoord1 = new int[3]; // 집에서부터 출발해 길이 끊긴 마지막 위치를 저장할 배열
		int[] erasedCoord2 = new int[3]; // 유치원에서부터 출발해 길이 끊긴 마지막 위치를 저장할 배열
		ans = new int[2]; // 정답의 위치 배열 초기화
		int[] M = new int[2]; // 집 위치 초기화
		int[] Z = new int[2]; // 유치원 위치 초기화

		// 도면 정보 입력 받기
		for (int j = 0; j < n; j++) {
			in = br.readLine().split("");
			for (int j2 = 0; j2 < m; j2++) {
				map[j][j2] = in[j2].charAt(0);
				if (map[j][j2] == 'M') { // 집 위치 저장
					M[0] = j;
					M[1] = j2;
				}
				if (map[j][j2] == 'Z') { // 유치원 위치 저장
					Z[0] = j;
					Z[1] = j2;
				}
			}
		}

		searchEraseArea(erasedCoord1, M); // 집부터 길이 끊긴 마지막 위치 탐색
		searchEraseArea(erasedCoord2, Z); // 유치원부터 길이 끊긴 마지막 위치 탐색

		int i1 = erasedCoord1[0];
		int j1 = erasedCoord1[1];
		int d = erasedCoord1[2];
		int i2 = erasedCoord2[0];
		int j2 = erasedCoord2[1];
		char ansBlock; // 지워진 블록의 종류

		if (d == 0) { // 정답 위치 저장
			ans[0] = i1 - 1;
			ans[1] = j1;
		} else if (d == 1) {
			ans[0] = i1;
			ans[1] = j1 - 1;
		} else if (d == 2) {
			ans[0] = i1;
			ans[1] = j1 + 1;
		} else {
			ans[0] = i1 + 1;
			ans[1] = j1;
		}
		if (Math.abs(i1 - i2) == 2 || Math.abs(j1 - j2) == 2) { // 위, 아래 / 왼쪽, 오른쪽
			if (i1 == i2) { // 왼쪽, 오른쪽
				ansBlock = '-';
			} else { // 위, 아래
				ansBlock = '|';
			}
		} else { // 꺾이는 블록
			if (i1 - i2 == j1 - j2) { // 2, 4 사분면
				if (ans[0] < Math.max(i1, i2)) {
					ansBlock = '4';
				} else {
					ansBlock = '2';
				}
			} else { // 1, 3 사분면
				if (ans[0] < Math.max(i1, i2)) {
					ansBlock = '1';
				} else {
					ansBlock = '3';
				}
			}
		}

		if (check4Way(ans[0], ans[1])) { // 사거리인지 확인
			ansBlock = '+';
		}

		sb.append(ans[0] + 1).append(" ").append(ans[1] + 1).append(" ").append(ansBlock).append("\n"); // 정답 저장
		System.out.println(sb); // 정답 한번에 출력
		br.close();
	}

	private static boolean check4Way(int i, int j) {
		boolean flag = true;
		for (int k = 0; k < 4; k++) { // 4개의 방향 모두 탐색
			int nI = i + dx[k];
			int nJ = j + dy[k];

			if (nI >= 0 && nJ >= 0 && nI < n && nJ < m) { // 4 방향 중 하나라도 길이 없다면 사거리가 아님
				if (map[nI][nJ] == '.') {
					return false;
				} else {
					if (k == 0) {
						if (!(map[nI][nJ] == '|' || map[nI][nJ] == '+' || map[nI][nJ] == '1' || map[nI][nJ] == '4')) {
							return false;
						}
					} else if (k == 1) {
						if (!(map[nI][nJ] == '-' || map[nI][nJ] == '+' || map[nI][nJ] == '1' || map[nI][nJ] == '2')) {
							return false;
						}
					} else if (k == 2) {
						if (!(map[nI][nJ] == '-' || map[nI][nJ] == '+' || map[nI][nJ] == '3' || map[nI][nJ] == '4')) {
							return false;
						}
					} else {
						if (!(map[nI][nJ] == '|' || map[nI][nJ] == '+' || map[nI][nJ] == '2' || map[nI][nJ] == '3')) {
							return false;
						}
					}
				}
			} else {
				flag = false;
			}
		}
		return flag; // 4개의 방향에 모두 길이 있음
	}

	// 마지막으로 끊긴 길의 위치를 찾기 위한 메소드
	private static void searchEraseArea(int[] erasedCoord, int[] start) {
		// 시작 지점 초기화
		int sI = start[0];
		int sJ = start[1];
		erasedCoord[0] = sI;
		erasedCoord[1] = sJ;

		Queue<int[]> q = new ArrayDeque<>(); // bfs 탐색
		boolean[][] visited = new boolean[n][m]; // 중복방문을 하지 않기 위한 배열 선언

		visited[sI][sJ] = true; // 시작지점 방문 체크

		for (int i = 0; i < 4; i++) {
			int nI = sI + dx[i];
			int nJ = sJ + dy[i];

			if (nI >= 0 && nJ >= 0 && nI < n && nJ < m && map[nI][nJ] != '.' && map[nI][nJ] != 'M'
					&& map[nI][nJ] != 'Z') {
				if (map[nI][nJ] == '+') {
					q.add(new int[] { nI, nJ, i });
				} else if (map[nI][nJ] == '1') {
					if (i == 1) {
						q.add(new int[] { nI, nJ, 3 }); // 다음 방문 예정
					} else {
						q.add(new int[] { nI, nJ, 2 }); // 다음 방문 예정
					}
				} else if (map[nI][nJ] == '2') {
					if (i == 1) {
						q.add(new int[] { nI, nJ, 0 }); // 다음 방문 예정
					} else {
						q.add(new int[] { nI, nJ, 2 }); // 다음 방문 예정
					}
				} else if (map[nI][nJ] == '3') {
					if (i == 2) {
						q.add(new int[] { nI, nJ, 0 }); // 다음 방문 예정
					} else {
						q.add(new int[] { nI, nJ, 1 }); // 다음 방문 예정
					}
				} else if (map[nI][nJ] == '4') {
					if (i == 2) {
						q.add(new int[] { nI, nJ, 3 }); // 다음 방문 예정
					} else {
						q.add(new int[] { nI, nJ, 1 }); // 다음 방문 예정
					}
				} else {
					q.add(new int[] { nI, nJ, i }); // 다음 방문 예정
				}
				visited[nI][nJ] = true;
				break;
			}
		}

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int i = now[0];
			int j = now[1];
			int d = now[2];
			boolean found = false; // 갈 수 있는 길이 없다면 빠르게 메소드를 종료하기 위해 찾았는지 확인을 위한 flag

			int nI = i + dx[d];
			int nJ = j + dy[d];

			if (nI >= 0 && nJ >= 0 && nI < n && nJ < m && map[nI][nJ] != '.' && map[nI][nJ] != 'M'
					&& map[nI][nJ] != 'Z') { // 길이 있다면
				if (!visited[nI][nJ]) {
					found = true; // 아직 길이 끊기지 않았음
					// 큐에 넣을 때 방향 설정해서 넣기
					if (map[nI][nJ] == '+') {
						q.add(new int[] { nI, nJ, d });
						continue;
					} else if (map[nI][nJ] == '1') {
						if (d == 1) {
							q.add(new int[] { nI, nJ, 3 }); // 다음 방문 예정
						} else {
							q.add(new int[] { nI, nJ, 2 }); // 다음 방문 예정
						}
					} else if (map[nI][nJ] == '2') {
						if (d == 1) {
							q.add(new int[] { nI, nJ, 0 }); // 다음 방문 예정
						} else {
							q.add(new int[] { nI, nJ, 2 }); // 다음 방문 예정
						}
					} else if (map[nI][nJ] == '3') {
						if (d == 2) {
							q.add(new int[] { nI, nJ, 0 }); // 다음 방문 예정
						} else {
							q.add(new int[] { nI, nJ, 1 }); // 다음 방문 예정
						}
					} else if (map[nI][nJ] == '4') {
						if (d == 2) {
							q.add(new int[] { nI, nJ, 3 }); // 다음 방문 예정
						} else {
							q.add(new int[] { nI, nJ, 1 }); // 다음 방문 예정
						}
					} else {
						q.add(new int[] { nI, nJ, d }); // 다음 방문 예정
					}
					visited[nI][nJ] = true; // 방문 체크
				}
			}

			if (!found) {
				// 끊긴 위치 저장
				erasedCoord[0] = i;
				erasedCoord[1] = j;
				erasedCoord[2] = d;
				break;
			}
		}
	}
}