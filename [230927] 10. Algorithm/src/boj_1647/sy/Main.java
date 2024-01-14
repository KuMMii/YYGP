package boj_1647.sy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Edge implements Comparable<Edge> {
		int ed, w;
		public Edge(int ed, int w) {
			this.ed = ed;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//N개의 집
		int N = sc.nextInt();
		//M개의 길
		int M = sc.nextInt();
		
		List<Edge>[] adjList = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			
			adjList[st].add(new Edge(ed, w));
			adjList[ed].add(new Edge(st, w));
		}
		
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		visited[1] = true;
		pq.addAll(adjList[1]);
		
		int pick = 0;
		List<Edge> list = new ArrayList<>();
		
		while(pick != N-1) {
			Edge e = pq.poll();
			if(!visited[e.ed]) {
				list.add(e);
				pq.addAll(adjList[e.ed]);
				visited[e.ed]= true;
				pick++;
			}
		}
		
		int max = 0;
		int maxIdx = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).w > max) {
				max = list.get(i).w;
				maxIdx = i;
			}
		}
		
		list.remove(maxIdx);
		
		int ans = 0;
		for(int i = 0; i < list.size(); i++) {
			ans += list.get(i).w;
		}
		
		System.out.println(ans);
		
	}//main
}//Solution
