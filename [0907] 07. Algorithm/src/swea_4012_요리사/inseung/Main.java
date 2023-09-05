package swea_4012_요리사.inseung;

import java.util.Scanner;

//조합 씀

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int k = 1; k<=T; k++) {
			N = sc.nextInt(); // 재료 개수
			R = N / 2; // 요리 하나에 들어갈 재료 개수
			foodA = new int[R];
			foodB = new int[R];
			synergy = new int[N][N]; // 재료끼리의 시너지값
			
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					synergy[i][j] = sc.nextInt();
					sum += synergy[i][j];
				}
			}
			
			diff = 20000 * 8 * 8; // diff값 초기화 (최대한 크게크게 만듬) (N의 최대값 16)
			
			com(0,0);
			
			
			System.out.printf("#%d %d%n", k, diff);
		}
		
		
		
	}
	
	static int N;
	static int R;
	static int[] foodA;
	static int[] foodB;
	static int[][] synergy;
	static int sum; // 전체 synergy 합계
	static int diff;
	
	// i = synergy[] 훑는 인덱스값
	// j = foodA[]에 넣을 인덱스값
	static void com(int i, int j) {
		
//		System.out.println("i" + i + "j" + j);
		
		if (j == R) {
			// a: 재료 인덱스 순서대로 훑는 숫자 
			// foodB[] 배열에 인덱스값들 넣어줌
			for (int a = 0, idxA = 0, idxB = 0; a<N; a++) {
				
				if (a != foodA[idxA]) {
					foodB[idxB] = a;
					idxB++;
				} else {
					if (idxA != N/2 -1)
						idxA++;
				}
			}
			
//			System.out.println(Arrays.toString(foodA));
//			System.out.println(Arrays.toString(foodB));
			
			//foodA, foodB의 시너지값 각각 구해줌
			int tempA = 0;
			int tempB = 0;
			for (int a = 0; a<N/2; a++) {
				for (int b = a + 1; b<N/2; b++) {
					tempA += synergy[foodA[a]][foodA[b]];
					tempA += synergy[foodA[b]][foodA[a]];
					tempB += synergy[foodB[a]][foodB[b]];
					tempB += synergy[foodB[b]][foodB[a]];
				}
			}
//			System.out.println("emptA" + tempA);
//			System.out.println("emptB" + tempB);
			
			// 원래있던 diff값보다 작으면 diff에 넣어줌
			if (Math.abs(tempA - tempB) < diff) {
				diff = Math.abs(tempA - tempB);
//				System.out.println("diff" + diff);
			}
			return;
		}
		
		if (i == N) return; // 이거 안쓰면 계속 무한의 늪에 빠지는듯
		
		foodA[j] = i;
		com(i+1, j+1);
		
		com(i+1, j);
	}
}
