package boj_1260_dfs와bfs.ryu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static String[] line;
	static boolean[] dfsVisited;
	static boolean[] bfsVisited;
	static Map<Integer, PriorityQueue<Integer>> dfsMap = new HashMap<>();
	static Map<Integer, PriorityQueue<Integer>> bfsMap = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		line = bf.readLine().split(" ");
		
		int N, M, V;
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		V = Integer.parseInt(line[2]);
		
		dfsVisited = new boolean[N+1];
		bfsVisited = new boolean[N+1];
		
		for (int m=0; m<M; m++) {
			int v1, v2;
			line = bf.readLine().split(" ");
			v1 = Integer.parseInt(line[0]);
			v2 = Integer.parseInt(line[1]);
			
			if (!dfsMap.containsKey(v1)) {
				dfsMap.put(v1, new PriorityQueue<>());
				bfsMap.put(v1, new PriorityQueue<>());
			}
			if (!dfsMap.containsKey(v2)) {
				dfsMap.put(v2, new PriorityQueue<>());
				bfsMap.put(v2, new PriorityQueue<>());
			}
			
			dfsMap.get(v1).offer(v2);
			dfsMap.get(v2).offer(v1);
			bfsMap.get(v1).offer(v2);
			bfsMap.get(v2).offer(v1);
		}
		
		
		// dfs
		dfs(V);
		// 개행
		System.out.println();
		// bfs
		bfs(V);
	}
	
	static void dfs(int v) {
		System.out.print(v+" ");
		dfsVisited[v] = true;
		
		while (dfsMap.containsKey(v) && !dfsMap.get(v).isEmpty()) {
			int nextChild = dfsMap.get(v).poll();
			if (dfsVisited[nextChild]) continue;
			dfs(nextChild);
		}
	}
	
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			if (!bfsVisited[curr]) {
				System.out.print(curr+" ");
				bfsVisited[curr] = true;
			}
			
			while (bfsMap.containsKey(curr) && !bfsMap.get(curr).isEmpty()) {
				int nextChild = bfsMap.get(curr).poll();
				if (bfsVisited[nextChild]) continue;
				q.add(nextChild);
			}
		}
	}
	
}
