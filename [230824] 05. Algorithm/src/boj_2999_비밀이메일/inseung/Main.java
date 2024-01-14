package boj_2999_비밀이메일.inseung;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next(); // 상근이가 받은 메시지
		int N = str.length();
		int r = 0, c = 0; // 행, 열 크기

		// r <= c

		// 최대 100글자이므로, r이 10보다 클 수 없음
		for (int i = 10; i >= 1; i--) { // r 후보 : 10부터 1까지
			if (N % i == 0 && i <= N / i) { // N이 r 후보로 나눠 떨어지고, r보다 c가 크면
				if (r < i) { // 원래 있던 r값보다 new r값이 더 크면 (r값 최대한 커야 되니까)
					r = i;
					c = N / i;
				}
			}

		}
		
		// r*c 배열에 세로로 한글자씩 메시지 씀
		char[][] message = new char[r][c];
		int num = 0;
		for (int j = 0; j < c; j++) {
			for (int i = 0; i < r; i++) {
				message[i][j] = str.charAt(num++);
			}
		}
		
		// 가로로 메시지 출력
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(message[i][j]);
			}
		}
	}
}

