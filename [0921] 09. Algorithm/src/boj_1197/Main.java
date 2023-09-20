package boj_1197;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		//간선의 정보를 담을 배열
		int[][] edges = new int[E][3];
		for(int i = 0; i < E; i++) {
			//시작점
			edges[i][0] = sc.nextInt();
			//끝점
			edges[i][1] = sc.nextInt();
			//가중치
			edges[i][2] = sc.nextInt();
		}
		
		//간선 배열 가중치 기준 오름차순 정렬
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		p = new int[V+1];
		
		//makeset
		for(int i = 0; i < V+1; i++) {
			p[i] = i;
		}
		
		int ans = 0;
		int pick = 0;
		for(int i = 0; i < E; i++) {
			int a = findset(edges[i][0]);
			int b = findset(edges[i][1]);
			
			if(a != b) {
				union(a, b);
				ans += edges[i][2];
				pick++;
			}
			
			if(pick == V-1) break;
		}
		System.out.println(ans);
		
	}//main
	
	static void union(int a, int b) {
		p[b] = a;
	}
	
	static int findset(int a) {
		if(a != p[a])
			p[a] = findset(p[a]);
		return p[a];
	}
	
}//class
