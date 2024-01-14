package boj_7576;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class coor{
		int r;
		int c;
		
		public coor(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	static int N,M,cnt,goal; //R, C, 1의 개수, 전체 토마토 개수
	static int[][] arr;
	static int[][] BFScnt; //BFS할때 날짜 넣는 배열
	static int[] mR= {-1,1,0,0}; //상하좌우
	static int[] mC= {0,0,-1,1};
	static Queue<coor> q;
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		M=sc.nextInt();
		N=sc.nextInt();
		arr=new int[N][M];
		BFScnt=new int[N][M];
		cnt=0;
		goal=N*M;
		
		q=new LinkedList<>();
		
		//1인 값의 좌표 미리 저장해서 BFS 첫 값으로 넣을 거임
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j]=sc.nextInt();
				//1이면 큐에 추가
				if(arr[i][j]==1) q.add(new coor(i,j));
				//-1이면 goal 줄이기
				else if(arr[i][j]==-1) goal--;
			}
		}
		
		//input fin
		
		BFS();
		
	}//main

	public static void BFS() {
		
		while(!q.isEmpty()) {
			coor t=q.poll();
			int r=t.r;
			int c=t.c;
			//하나씩 뽑을 때 값을 1 더함
			cnt++;
			
			//1의 개수가 목표와 같아지면 출력 후 끝내기
			if(cnt==goal) {
				System.out.println(BFScnt[r][c]);
				return;
			}
			
			//상하좌우 돌리기
			for(int i=0; i<4; i++) {
				//범위 내의 좌표가 값도 0인 경우
				if(0<=r+mR[i]&&r+mR[i]<N && 0<=c+mC[i]&&c+mC[i]<M && arr[r+mR[i]][c+mC[i]]==0) {
					//arr의 값도 1로 바꿈
					arr[r+mR[i]][c+mC[i]]=1;
					//cnt배열에 이전 좌표의 값에 1더한 값을 넣음
					BFScnt[r+mR[i]][c+mC[i]]=BFScnt[r][c]+1;
					//그리고 큐에 좌표 담기
					q.add(new coor(r+mR[i],c+mC[i]));
				}
			}
		}//while
		
		//위에서 return 없이 내려온 것이니 -1 출력
		System.out.println(-1);
	}//BFS
	
}//class
