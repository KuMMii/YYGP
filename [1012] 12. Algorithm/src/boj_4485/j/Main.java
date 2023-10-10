package boj_4485;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class v implements Comparable<v>{
		int R;
		int C;
		int W;
		public v(int r, int c, int w) {
			R = r;
			C = c;
			W = w;
		}
		@Override
		public int compareTo(v o) {
			return this.W-o.W;
		}
		
	}//v
	
	static int N;
	//상하좌우
	static int[] dr= {-1,1,0,0}; static int[] dc= {0,0,-1,1};
	static int[][] arr, dist;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int cnt=1;
		while(true) {
			N=sc.nextInt();
			if(N==0) break;
			
			arr=new int[N][N];
			dist=new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j]=sc.nextInt();
					dist[i][j]=Integer.MAX_VALUE;
				}
			}
			//input fin
			
			dijkstra(0,0);
			
			
			System.out.printf("Problem %d: %d\n",cnt++,dist[N-1][N-1]);
		}//while
		
		
		
	}//main

	public static void dijkstra(int R, int C) {
		PriorityQueue<v> pq=new PriorityQueue<>();
		
		//dist start값은 arr[0][0]값
		dist[R][C]=arr[R][C];
		
		//pq에 넣기
		pq.add(new v(R,C,dist[R][C]));
		
		while(!pq.isEmpty()) {
			v V=pq.poll();
			//좌표값 꺼냄
			int r=V.R;
			int c=V.C;
			
			//상하좌우 찾기
			for(int i=0; i<4; i++) {
				//범위 내에 있고
				if (0 <= r + dr[i] && r + dr[i] < N && 0 <= c + dc[i] && c + dc[i] < N
				//현재 vertex의 가중치+새 vertex의 가중치의 합이 원래 저장된 가중치보다 작은 경우
				&& dist[r+dr[i]][c+dc[i]]>arr[r+dr[i]][c+dc[i]]+V.W ) {
					//더 작은 값으로 바꿔줌
					dist[r+dr[i]][c+dc[i]]=arr[r+dr[i]][c+dc[i]]+V.W;
					//그리고 그 vertex pq에 넣기
					pq.add(new v(r+dr[i],c+dc[i],dist[r+dr[i]][c+dc[i]]));
					
				}
			}
		}
		
	}
}//class
