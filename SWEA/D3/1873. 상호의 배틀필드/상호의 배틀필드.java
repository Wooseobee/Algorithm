import java.io.*;

public class Solution {

	private static int direction, h, w;
	private static int[] tank;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 테스트 케이스를 한 번에 출력하기 위해 StringBuilder 사용

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] in = br.readLine().split(" ");

			h = Integer.parseInt(in[0]);
			w = Integer.parseInt(in[1]);

			map = new char[h][w];
			tank = new int[2];

			for (int i = 0; i < h; i++) {
				in = br.readLine().split("");
				for (int j = 0; j < w; j++) {
					map[i][j] = in[j].charAt(0);
					switch (map[i][j]) {
					case '^':
						direction = 0;
						tank[0] = i;
						tank[1] = j;
						break;
					case 'v':
						direction = 1;
						tank[0] = i;
						tank[1] = j;
						break;
					case '<':
						direction = 2;
						tank[0] = i;
						tank[1] = j;
						break;
					case '>':
						direction = 3;
						tank[0] = i;
						tank[1] = j;
						break;
					default:
						break;
					}
				}
			}

			int n = Integer.parseInt(br.readLine());
			in = br.readLine().split("");

			move(n, in);

			sb.append("#").append(test_case).append(" ");
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}

	private static void move(int n, String[] in) {
		for (int i = 0; i < n; i++) {
			char order = in[i].charAt(0);
			int nI, nJ;
			switch (order) {
			case 'U':
				direction = 0;
				nI = tank[0] + dx[direction];
				nJ = tank[1] + dy[direction];
				map[tank[0]][tank[1]] = '^';
				if (canMove(nI, nJ) && map[nI][nJ] == '.') {
					map[nI][nJ] = '^';
					map[tank[0]][tank[1]] = '.';
					tank[0] = nI;
					tank[1] = nJ;
				}
				break;
			case 'D':
				direction = 1;
				nI = tank[0] + dx[direction];
				nJ = tank[1] + dy[direction];
				map[tank[0]][tank[1]] = 'v';
				if (canMove(nI, nJ) && map[nI][nJ] == '.') {
					map[nI][nJ] = 'v';
					map[tank[0]][tank[1]] = '.';
					tank[0] = nI;
					tank[1] = nJ;
				}
				break;
			case 'L':
				direction = 2;
				nI = tank[0] + dx[direction];
				nJ = tank[1] + dy[direction];
				map[tank[0]][tank[1]] = '<';
				if (canMove(nI, nJ) && map[nI][nJ] == '.') {
					map[nI][nJ] = '<';
					map[tank[0]][tank[1]] = '.';
					tank[0] = nI;
					tank[1] = nJ;
				}
				break;
			case 'R':
				direction = 3;
				nI = tank[0] + dx[direction];
				nJ = tank[1] + dy[direction];
				map[tank[0]][tank[1]] = '>';
				if (canMove(nI, nJ) && map[nI][nJ] == '.') {
					map[nI][nJ] = '>';
					map[tank[0]][tank[1]] = '.';
					tank[0] = nI;
					tank[1] = nJ;
				}
				break;
			case 'S':
				shoot();
				break;
			default:
				break;
			}
		}
	}

	private static void shoot() {
		int nI = tank[0] + dx[direction];
		int nJ = tank[1] + dy[direction];
		while(canMove(nI, nJ)) {
			if(map[nI][nJ] == '#') {
				break;
			}
			if(map[nI][nJ] == '*') {
				map[nI][nJ] = '.';
				break;
			}
			nI += dx[direction];
			nJ += dy[direction];
		}
	}

	private static boolean canMove(int nI, int nJ) {
		return nI >= 0 && nJ >= 0 && nI < h && nJ < w;
	}

}