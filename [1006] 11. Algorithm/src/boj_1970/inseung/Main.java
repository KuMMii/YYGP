package boj_1970.inseung;

import java.util.Scanner;

public class Main다시 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int k = 1; k <= T; k++) {
			int N = sc.nextInt(); // 거스름돈
			// 행: 50000원 ~ 10원 거스름돈 개수
			// 열: 거스름돈 크기만큼의 배열 만듬
			int[][] ch = new int[8][N+1]; 
			for (int i = 10; i<=N; i++) {
				// 50000원은 1개,2개,3개,, 계속 숫자 올라감
				if (i>= 50000) ch[0][i] = ch[0][i-50000] + 1;
				// 10의 배수인 거스름돈들: 0개~4개 가능
				if (i>= 10000) ch[1][i] = (ch[1][i-10000] + 1) % 5;
				// 50의 배수인 거스름돈들: 0개, 1개 가능
				if (i>= 5000) ch[2][i] = (ch[2][i-5000] + 1) % 2;
				if (i>= 1000) ch[3][i] = (ch[3][i-1000] + 1) % 5;
				if (i>= 500) ch[4][i] = (ch[4][i-500] + 1) % 2;
				if (i>= 100) ch[5][i] = (ch[5][i-100] + 1) % 5;
				if (i>= 50) ch[6][i] = (ch[6][i-50] + 1) % 2;
				if (i>= 10) ch[7][i] = (ch[7][i-10] + 1) % 5;
			}
			
			// 출력 형식대로 프린트
			System.out.printf("#%d%n", k);
			for (int i = 0; i<8; i++) {
				System.out.print(ch[i][N] + " ");
			}
			System.out.println();
		}
	}
}
