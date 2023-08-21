import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력을 받기 위한 BufferedReader

		int t = Integer.parseInt(br.readLine());	// 굽기 시간 t 입력 받기

		int a = 0, b = 0, c = 0;	// a, b, c 버튼 0으로 초기화

		while (t >= 10) {	// 10초 이상인 경우 반복문 실행
			if (t >= 300) {	// 300초 이상일 때
				int div = t / 300;
				a += div;	// a 버튼 횟수 + 1
				t -= div * 300;	// 남은 시간 감소
			}

			if (t / 60 >= 0) {	// 60초 이상일 때
				int div = t / 60;
				b += div;	// b 버튼 횟수 + 1
				t -= div * 60;	// 남은 시간 감소
			}

			if (t / 10 > 0) {	// 10초 이상일 때
				int div = t / 10;
				c += div;	// c 버튼 횟수 + 1
				t -= div * 10;	// 남은 시간 감소
			}
		}
		if (t != 0) {	// 3개의 버튼으로 t초를 맞출 수 없음
			System.out.println(-1);
		} else {	// 3개의 버튼으로 t초를 맞출 수 있음
			System.out.println(a + " " + b + " " + c);
		}
		br.close();
	}

}