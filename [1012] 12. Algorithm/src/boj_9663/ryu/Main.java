package boj_9663.ryu;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[][] hasNoFuture;
	static int ans;

	private static void dfs(int r, int c) {
		// 기저파트
		if (r==N) {
			ans++;
			return;
		}
		if (hasNoFuture[r][c]) {
			return;
		}
		
		
		// 재귀파트
		// vertical
		for (int i=r+1; i<N; i++) {
			hasNoFuture[i][c] = true;
		}
		
		// right-down
		int nc, nr;
		nc = c+1;
		nr = r+1;
		while (nc < N && nr < N) {
			hasNoFuture[nr][nc] = true;
			nc++;
			nr++;
		}
		
		// left-down
		nr = r+1;
		nc = c-1;
		while (nc >= 0 && nr < N) {
			hasNoFuture[nr][nc] = true;
			nr++;
			nc--;
		}
		
		for (int j=0; j<N; j++) {
			dfs(r+1, j);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N][N];
		ans = 0;
		
		for (int c=0; c<N; c++) {
			hasNoFuture = new boolean[N][N];
			dfs(0, c);
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}
