package boj_9372;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] plane;
	static int T,N,M,ans;
	static boolean[] visited;
	static Queue<Integer>q;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			N=sc.nextInt();
			M=sc.nextInt();
			ans=0;
			plane=new int[N+1][N+1];
			visited=new boolean[N+1];
			
			
			for(int i=0; i<M; i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				plane[a][b]=1;
				plane[b][a]=1;
				
			}
			//그래프 완성!
			visited[1]=true;
			BFS(1);
			
			System.out.println(ans-1);
		}//tc
		
		
	}//main

	private static void BFS(int r) {
		q=new LinkedList<>();
		q.add(r);
		visited[1]=true;
		
		while(!q.isEmpty()) {
			ans++;
			int t=q.poll();
			visited[t]=true;
			
			for(int i=1; i<=N; i++) {
				if(plane[t][i]==1 && !visited[i] ) {
					visited[i]=true;
					q.add(i);
				}
			}
			
		}//while
		
	}//bfs
}//class
