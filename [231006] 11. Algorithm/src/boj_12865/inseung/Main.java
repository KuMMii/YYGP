package boj_12865.inseung;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int N = sc.nextInt(); // N개의 물건
			int K = sc.nextInt(); // 최대무게 K
			// 물건들 배열 th[][] - 0열: 무게 W, 1열: 가치 V
			int[][] th = new int[N][2]; 
			for (int i = 0; i<N; i++) {
				th[i][0] = sc.nextInt();
				th[i][1] = sc.nextInt();
			}
			
			// 정렬 안해도 됨
//			Arrays.sort(th, new Comparator<int[]>() {
//				public int compare(int[] o1, int[] o2) {
//					return o1[0] - o2[0];
//				}
//			});
			
			
			// 행: 물건들 조합 하나씩 늘어남
			// 열: 무게 1씩 증가해서, 최대무게까지 감
			int[][] dp = new int[N+1][K+1];
			for (int i = 1; i<N+1; i++) {
				int addWeight = th[i-1][0];
				for (int j = 0; j<K+1; j++) {
					if (j >= addWeight) {
						// 추가물건 너 없는게 더 좋아! or (원래 물건 뺄수도 있지만) 추가 물건 너 있는게 더 좋아!
						// (원래의 최적무게)의 가치 or (원래의 최적무게 - 추가 무게)의 가치 + (추가된 무게)의 가치
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-addWeight] + th[i-1][1]);
					} else {
						// 추가된 무게보다 적은 경우는, 원래의 값들을 아래로 내려씀
						dp[i][j] = dp[i-1][j]; 
					}
				}
			}
			
			System.out.println(dp[N][K]);
	}
}
