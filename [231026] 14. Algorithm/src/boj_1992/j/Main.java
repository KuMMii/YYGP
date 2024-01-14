package boj_1992.j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class computer implements Comparable<computer>{
		int s;
		int e;
		int w;
		public computer() {
		}
		public computer(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(computer o) {
			return this.w-o.w;
		}
	}//computer

	static int N,M,sum;
	static List<computer>[] graph;
	static boolean[] visited;
	static int[] arr; //무한대 담을 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		
		graph=new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			graph[i]=new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			
			graph[s].add(new computer(s,e,w));
			graph[e].add(new computer(e,s,w));
		}
		
		visited=new boolean[N+1];
		
		sum=0;
		Prim(1);
		
		System.out.println(sum);
	}//main

	public static void Prim(int idx) {
		PriorityQueue<computer> q=new PriorityQueue<>();
		visited[idx]=true;
		q.addAll(graph[idx]);
		while(!q.isEmpty()) {
			computer t=q.poll();
			if (!visited[t.e]) {
				sum+=t.w;
				q.addAll(graph[t.e]);
				visited[t.e]=true;
			}
			
		}
		
	}//Prim
}//class
