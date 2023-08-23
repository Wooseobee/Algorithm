import java.io.*;

public class Main {

	private static int n, max = 0;	// 이닝 수, 최대 점수
	private static int[][] info;	// 각 이닝의 선수들의 결과
	private static int[] order = new int[10];	// 타순 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());	// 총 이닝 수 입력 받기
		info = new int[n][10];	// 이닝 정보 배열 초기화
		
		// 각 이닝의 선수들의 결과 입력받기
		for (int i = 0; i < n; i++) {
			String[] in = br.readLine().split(" ");
			for (int j = 1; j <= 9; j++) {
				info[i][j] = Integer.parseInt(in[j - 1]);
			}
		}
		makeOrder(1, new boolean[10]);	// 타순 정하기
		System.out.println(max);	// 정답 출력
		br.close();
	}

	// 순서가 있는 뽑기(4번 타자 제외)
	// depth == 타순
	private static void makeOrder(int depth, boolean[] visited) {
		if (depth == 10) {	// 9명의 선수들의 순서를 모두 정했다면
			int score = playGame();	// 게임하러 가기
			max = Math.max(max, score);	// 최대값 갱신
			return;
		}
		for (int i = 2; i <= 9; i++) {	// 2번~9번 선수만 순서 정하기
			if (!visited[i]) {	// 순서가 아직 정해지지 않은 선수라면
				visited[i] = true;	// 해당 선수가 순서 정해졌다고 표시

				order[depth] = i;	// 해당 선수를 depth 타선에 넣기 
				if (depth == 3) {	// 3번 타순까지 정했다면
					order[4] = 1;	// 4번 타순은 1번 선수로 정해져 있으므로
					makeOrder(depth + 2, visited);	// 5번 타순 정하러 가기
				} else {
					makeOrder(depth + 1, visited);	//	3번 타순을 정하는 경우가 아니라면 다음 타순 정하기 
				}
				visited[i] = false;	// 해당 선수의 순서 복구
			}
		}
	}

	// 정한 순서로 게임하기
	private static int playGame() {
		int score = 0;	// 획득한 점수
		int idx = 1;	// 1번 타자부터

		for (int i = 0; i < n; i++) {
			int outCnt = 0;	// 아웃카운트
			// 1,2,3 루
			int one = 0;
			int two = 0;
			int three = 0;
			while (outCnt < 3) {	// 아웃 카운트가 3개 미만일 동안 이닝 진행
				if (idx == 0) idx = 1;	// 0번째 타자는 없으므로 1번째 타자로 정정
				int result = info[i][order[idx]];	// result = 각 선수가 i이닝에서 얻는 결과
				idx = (idx + 1) % 10;	// 다음 타자
				switch (result) {
				case 0:	// 아웃
					outCnt++;	// 아웃카운트 증가
					break;
				case 1:	// 1루타
					score += three;	// 3루 => 홈 (점수 +)
					three = two;	// 2루 => 1루
					two = one;		// 1루 => 2루
					one = 1;		// 타자 => 1루
					break;
				case 2:	// 2루타
					score += three + two;	// 3루, 2루 => 홈 (점수 +)
					three = one;			// 1루 => 3루
					two = 1;				// 타자 => 1루
					one = 0;				// 1루 주자 비우기
					break;
				case 3:	// 3루타
					score += three + two + one;	// 3루, 2루, 1루 => 홈 (점수 +)
					three = 1;					// 타자 => 1루
					two = 0;					// 2루 주자 비우기
					one = 0;					// 1루 주자 비우기
					break;
				case 4:	// 4루타
					score += three + two + one + 1;	// 모든 주자 => 홈 (점수 +)
					// 모든 주자 비우기
					three = 0;
					two = 0;
					one = 0;
					break;
				default:
					break;
				}
			}
		}

		return score;	// 총 점수 반환
	}

}