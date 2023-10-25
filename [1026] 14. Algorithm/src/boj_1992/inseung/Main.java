package boj_1992.inseung;

import java.util.PriorityQueue;
import java.util.Scanner;
// 크루스칼
public class Main {
	
	static class Edge implements Comparable<Edge> {
		int a;
		int b;
		int c;
		public Edge(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
		public int compareTo(Edge edge) {
			return this.c - edge.c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 컴퓨터의 수
		int M = sc.nextInt(); // 선의 수
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i<M; i++) {
			pq.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		p = new int[N+1];
		for (int i = 0; i<N+1; i++) {
			makeset(i);
		}
		
		int answer = 0; //최소 비용
		int pick = 0; //뽑은 간선의 수
		
		for (int i = 0; i< M; i++) {
			Edge edge = pq.poll();
			int px = findset(edge.a);
			int py = findset(edge.b);
			
			if (px != py) {
				union(px, py);
				answer += edge.c;
				pick++;
			}
			
			if (pick == N -1) break;
			
		}
		System.out.println(answer);
		
	}
	
	static int[] p;

	static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}
	
	static int findset(int x) {
		if (p[x] != x) {
			p[x] = findset(p[x]); 
		}
		return p[x];
	}
	
	static void makeset(int i) {
		p[i] = i;
	}
}
