package boj_1149.inseung;

import java.util.Scanner;
//이문제 보고 dp 떠올릴수 있을까?!
//dp 떠올리기만 하면 쉽구나
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int N = sc.nextInt(); // N개의 집
			// dp[i][0] = i번째 집을 빨강으로 칠할때의 최소비용
			// (0번째 집부터 시작)
			int[][] dp = new int[N][3];
			// 0번째 집은 값 넣어둠
			dp[0][0] = sc.nextInt();
			dp[0][1] = sc.nextInt();
			dp[0][2] = sc.nextInt();
			
			for (int i = 1; i<N; i++) {
				int red = sc.nextInt();
				int green = sc.nextInt();
				int blue = sc.nextInt();
				// dp[i][0] = 이전 집을 초록, 파랑으로 칠할때의 최소비용 2개 중 최소값 + 현재 집 red로 칠할때의 비용
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + red;
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + green;
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + blue;
			}
			
			// 마지막 집을 빨강, 초록, 파랑으로 칠할때의 최소비용 3개 중 최소값 프린트
			System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
	}
}
