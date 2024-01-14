package boj_2567_색종이2.inseung;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] paper = new int[101][101]; // 101 * 101 흰색 도화지 (최대 범위의 경계도 색종이 있는지 탐지하기 위해, 범위 1씩 늘림)

		for (int n = 1; n <= N; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			// 10*10 범위에 해당하는 부분은 배열값을 5로 바꿔준다
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					paper[i][j] = 5;
				}
			}
		}

		int answer = 0;

		// paper[i][j] 상하좌우에 색종이 덮힌 부분 있으면 -> 값을 +1 해준다
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (paper[i][j] != 5) { // 색종이 덮힌 부분은 냅둘것이다
					if (i - 1 >= 0 && paper[i - 1][j] == 5) {
						paper[i][j]++;
					}
					if (i + 1 < 101 && paper[i + 1][j] == 5) {
						paper[i][j]++;
					}
					if (j - 1 >= 0 && paper[i][j - 1] == 5) {
						paper[i][j]++;
					}
					if (j + 1 < 101 && paper[i][j + 1] == 5) {
						paper[i][j]++;
					}
				}
			}
		}

		// 안 칠한 부분은 배열값이 1~4인 값들을 answer에 더해준다
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (paper[i][j] >= 1 && paper[i][j] < 5) {
					answer += paper[i][j];
				}
			}
		}

		System.out.println(answer);
	}
}
