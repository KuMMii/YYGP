package boj_1149;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[][] dp=new int[N+1][3];
		
		//GRB input
		for(int i=1; i<=N; i++) {
			dp[i][0]=sc.nextInt();
			dp[i][1]=sc.nextInt();
			dp[i][2]=sc.nextInt();
		}
		
		//input fin
		
		for(int i=2; i<=N; i++) {
			
			//R
			dp[i][0]+=Math.min(dp[i-1][1], dp[i-1][2]);
			
			//G
			dp[i][1]+=Math.min(dp[i-1][0], dp[i-1][2]);
			
			//B
			dp[i][2]+=Math.min(dp[i-1][1], dp[i-1][0]);
			
		}
		
		int min=Math.min(dp[N][0], dp[N][1]);
		min=Math.min(min, dp[N][2]);
		
		System.out.println(min);
		
	}//main
}//class
