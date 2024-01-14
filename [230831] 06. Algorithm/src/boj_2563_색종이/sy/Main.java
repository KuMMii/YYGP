package boj_2563_색종이.sy;

import java.util.Scanner;

public class Main {
	//100*100 크기의 배열 생성 -> 모두 0으로 초기화되어 있음
	public static int[][] paper = new int[100][100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 1; i <= N; i++) {
			int C = sc.nextInt();
			int R = sc.nextInt();
			
			//색종이 범위만큼 이동하며 1로 변경
			for(int r = R; r <= R+9; r++) {
				for(int c = C; c <= C+9; c++) {
					paper[r][c] = 1;
				}
			}
		}
		
		//paper 배열 전체를 순회하면서 모두 더하면 색종이가 붙어있는 면적을 구할 수 있음
		int area = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				area += paper[i][j];
			}
		}
		
		System.out.println(area);

	}//main
}//class
