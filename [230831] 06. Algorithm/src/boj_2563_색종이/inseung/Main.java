package boj_2563_색종이.inseung;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] paper = new int[100][100]; // 100 * 100 흰색 도화지
		
		for (int n = 1; n<=N; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			// 10*10 범위에 해당하는 부분은 배열값을 +1 해준다
			for (int i = x; i < x+10 && i < 100; i++) {
				for (int j = y; j < y+10 && j < 100; j++) {
					paper[i][j]++;
				}
			}
		}
		
		int answer = 0;
		
		// 안 칠한 부분은 배열값이 0이므로, 배열값이 0이 아닌 부분들을 answer에 더해준다
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j] != 0) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
}
