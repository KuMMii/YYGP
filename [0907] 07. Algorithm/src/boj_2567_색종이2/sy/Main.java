package boj_2567_색종이2.sy;

import java.util.Scanner;

public class Main {
	//상, 하, 좌, 우
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] paper = new int[100][100];
		
		//색종이 개수
		int N = sc.nextInt();
		
		
		int maxR = 0;
		int maxC = 0;
		for(int i = 1; i <= N; i++) {
			//색종이를 붙인 위치
			int R = sc.nextInt();
			int C = sc.nextInt();
			
			maxR = Math.max(maxR, R);
			maxC = Math.max(maxC, C);
			for(int r = R; r < R+10; r++) {
				for(int c = C; c < C+10; c++) {
					paper[r][c] = 1;
				}
			}//r		
		}//i
		
		//둘레를 구하기 위한 변수
		int cir = 0;
		for(int r = 0; r < maxR+10; r++) {
			for(int c = 0; c < maxC+10; c++) {
				//현재 위치가 질해진 부분이면, 상하좌우에 칠해지지 않은 부분이 있거나 경계에 있으면 둘레 1 증가
				for(int dir = 0; dir < 4; dir++) {
					if(paper[r][c] == 1 
							&& ((r+dr[dir] >= 0 && r+dr[dir] < 100 && c+dc[dir] >= 0 && c+dc[dir] < 100 && paper[r+dr[dir]][c+dc[dir]] == 0) 
							|| r+dr[dir] == -1 || r+dr[dir] == 100 || c+dc[dir] == -1 || c+dc[dir] == 100)) {
						cir++;
					}
				}//dir
			}//c
		}//r
		
		System.out.println(cir);
		
	}//main

}//class
