package boj_12100.ryu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N][N];
		og = new int[N][N];
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				int d = sc.nextInt();
				arr[r][c] = d;
				og[r][c] = d;
			}
		}
		
		/*
		 * 0: 상
		 * 1: 하
		 * 2: 좌
		 * 3: 우
		 */
		permutation(0);
		System.out.println(ans);
		
		sc.close();
	}
	
	static int N;
	static int[][] arr;
	static int[][] og;
	static int ans=0;
	
	/**
	 * 1. 갈 수 있을만큼 가
	 * 2. 이동하려고 하는 쪽의 칸부터 합쳐
	 * 3. 다시 정렬해
	 * @param dir
	 */
	private static void command(int dir) {
		switch (dir) {
		case 0:
			//1.
			move(dir);
			//2.
			for (int c=0; c<N; c++) {
				for (int r=0; r<N-1; r++) {
					if (arr[r][c]==0) continue;
					if (arr[r][c] == arr[r+1][c]) {
						arr[r][c] *= 2;
						arr[r+1][c] = 0;
					}
				}
			}
			//3.
			move(dir);
			break;
		case 1:
			//1.
			move(dir);
			//2.
			for (int c=0; c<N; c++) {
				for (int r=N-1; r>=1; r--) {
					if (arr[r][c]==0) continue;
					if (arr[r][c] == arr[r-1][c]) {
						arr[r][c] *= 2;
						arr[r-1][c] = 0;
					}
				}
			}
			//3.
			move(dir);
			break;
		case 2:
			//1.
			move(dir);
			//2.
			for (int r=0; r<N; r++) {
				for (int c=0; c<N-1; c++) {
					if (arr[r][c]==0) continue;
					if (arr[r][c] == arr[r][c+1]) {
						arr[r][c] *= 2;
						arr[r][c+1] = 0;
					}
				}
			}
			//3.
			move(dir);
			break;
		case 3:
			//1.
			move(dir);
			//2.
			for (int r=0; r<N; r++) {
				for (int c=N-1; c>=1; c--) {
					if (arr[r][c]==0) continue;
					if (arr[r][c] == arr[r][c-1]) {
						arr[r][c] *= 2;
						arr[r][c-1] = 0;
					}
				}
			}
			//3.
			move(dir);
			break;
		default:
			break;
		}
	}
	
	
	private static void move(int dir) {
		switch (dir) {
		case 0:
			for (int c=0; c<N; c++) {
				Queue<Integer> q = new LinkedList<>();
				for (int r=0; r<N; r++) {
					if (arr[r][c]!=0) {
						q.offer(arr[r][c]);
						arr[r][c] = 0;
					}
				}
				int j=0;
				while (!q.isEmpty()) {
					arr[j][c] = q.poll();
					j++;
				}
			}
			break;
		case 1:
			for (int c=0; c<N; c++) {
				Queue<Integer> q = new LinkedList<>();
				for (int r=N-1; r>=0; r--) {
					if (arr[r][c]!=0) {
						q.offer(arr[r][c]);
						arr[r][c] = 0;
					}
				}
				int j=N-1;
				while (!q.isEmpty()) {
					arr[j][c] = q.poll();
					j--;
				}
			}
			break;
		case 2:
			for (int r=0; r<N; r++) {
				Queue<Integer> q = new LinkedList<>();
				for (int c=0; c<N; c++) {
					if (arr[r][c]!=0) {
						q.offer(arr[r][c]);
						arr[r][c] = 0;
					}
				}
				int j=0;
				while (!q.isEmpty()) {
					arr[r][j] = q.poll();
					j++;
				}
			}
			break;
		case 3:
			for (int r=0; r<N; r++) {
				Queue<Integer> q = new LinkedList<>();
				for (int c=N-1; c>=0; c--) {
					if (arr[r][c]!=0) {
						q.offer(arr[r][c]);
						arr[r][c] = 0;
					}
				}
				int j=N-1;
				while (!q.isEmpty()) {
					arr[r][j] = q.poll();
					j--;
				}
			}
			break;
		default:
			break;
		}
	}
	
	
	static int[] target = new int[] {0,1,2,3};
	static int[] perm = new int[5];
	private static void permutation(int cnt) {
		if (cnt == 5) {
			for (int dir : perm) {
				command(dir);
//				System.out.println(dir);
//				for (int r=0; r<N; r++) {
//					for (int c=0; c<N; c++) {
//						System.out.print(arr[r][c]+" ");
//					}
//					System.out.println();
//				}
			}
//			System.out.println();
			//ans 갱신
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if (arr[r][c]>ans) {
						ans = arr[r][c];
					}
				}
			}
			//arr 초기화
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					arr[r][c] = og[r][c];
				}
			}
			return;
		}
		// 대상 집합을 순회하며 숫자를 하나 선택한다.
		for (int i = 0; i < 4; i++) {
			// 숫자를 담는다.
			perm[cnt] = target[i];
			// 자신을 재귀 호출한다.
			permutation(cnt + 1);
		}
	}
	
}
