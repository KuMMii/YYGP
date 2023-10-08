package boj_9663;

import java.util.Scanner;

public class Main {
	static int N,cnt;
	//오아, 왼아
	static int[] dr= {1,1};
	static int[] dc= {1,-1};
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
			N=sc.nextInt();
			boolean[][] visited=new boolean[N][N];
			cnt=0;
			
			perm(0, visited);
			
			System.out.println(cnt);
	}//main

	public static void perm(int idx, boolean[][] visited) {
		
		if(idx==N) {
			cnt++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			//false 일 경우
			if(!visited[idx][i]) {
				boolean[][] tmpArr=new boolean[N][N];
				for(int r=0; r<N; r++) {
					for(int j=0; j<N; j++) {
						tmpArr[r][j]=visited[r][j];
					}
					
				}
				perm(idx+1, visitedCHK(tmpArr,idx,i));
			}
		}
		
		
		
	}//perm

	//visited 해주는 메서드
	public static boolean[][] visitedCHK(boolean[][] tmpArr, int r, int c) {
		
		//위 아래 양 전부 true로 바꿔주기
		for(int i=0; i<N; i++) {
			tmpArr[i][c]=true;
			tmpArr[r][i]=true;
		}
		
		//대각선 전부 true로 바꿔주기
		for(int i=0; i<2; i++) {
			int tmp=1;
			while(0<=r+tmp*dr[i]&&r+tmp*dr[i]<N && 0<=c+tmp*dc[i]&&c+tmp*dc[i]<N) {
				tmpArr[r+tmp*dr[i]][c+tmp*dc[i]]=true;
				tmp++;
			}
		}
		
		
		return tmpArr;
	}
}//class
