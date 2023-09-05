package BOJ_2567;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[][] blank=new int[100][100];
		//상하좌우
		int[] dr= {-1,1,0,0}; 
		int[] dc= {0,0,-1,1};
		
		Scanner sc= new Scanner(System.in);
		int T=sc.nextInt();
		
		//좌표받고 사각형 1 더하기
		for(int i=0; i<T; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			for(int r=x; r<=x+9; r++) {
				for(int c=y; c<=y+9; c++) {
					blank[r][c]++;
				}
			}
		}//for

		int cnt=0;
		//1인 애들 탐색
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
				if(blank[r][c]!=0) {//0 이상이면
					for(int i=0; i<4; i++) { //상하좌우 돌릴준비
						if(r+dr[i]>=0 && r+dr[i]<100 && c+dc[i]>=0 && c+dc[i]<100) { //범위내인 애들만 확인
							if(blank[r+dr[i]][c+dc[i]]==0 ) {
								cnt++;
							}
						}else if(r==0 || r==99 || c==0 || c==99) {
							cnt++;
							
						}
					}//for 상하좌우
				}//if
			}//for c
		}//for r
		
		System.out.println(cnt);
		
		
	}//main
}//class
