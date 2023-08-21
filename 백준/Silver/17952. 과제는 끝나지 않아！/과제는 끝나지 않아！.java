import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력을 받기 위한 BufferedReader

		int n = Integer.parseInt(br.readLine());	// 몇 분인지 입력 받기
		int total = 0;	// 업무 평가 점수

		Stack<int[]> stack = new Stack<>();	// 이전 업무를 기억하기 위한 자료구조로 스택 사용
		for (int i = 0; i < n; i++) {	// n분 동안 업무 진행
			String[] work = br.readLine().split(" ");	// 업무 정보 입력 받기
			int job = Integer.parseInt(work[0]);
			if (job == 1) {	// 업무가 주어진 경우
				int point = Integer.parseInt(work[1]);
				int time = Integer.parseInt(work[2]);
				if (time - 1 == 0) {	// 업무를 1분 안에 처리 가능하다면
					total += point;	// 업무평가 점수에 추가
				} else {	// 처리 불가능하므로
					stack.push(new int[] { point, time - 1 });	// 스택에 점수와 남은시간 저장
				}
			} else {	// 업무가 주어지지 않은 경우
				if (!stack.isEmpty()) {	// 이전에 하던 업무가 존재한다면
					int[] now = stack.pop();	// 해당 업무 진행
					int p = now[0];
					int t = now[1];

					if (t - 1 == 0) {	// 업무를 1분 안에 처리 가능하다면
						total += p;	// 업무평가 점수에 추가
					} else {	// 처리 불가능
						stack.push(new int[] { p, t - 1 });	// 다시 스택에 점수와 남은시간 저장
					}
				}
			}
		}

		System.out.println(total);	// 업무 평가 점수 출력
		br.close();
	}

}