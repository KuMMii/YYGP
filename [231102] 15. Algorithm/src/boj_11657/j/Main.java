package boj_11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class node {
		int s;
		int e;
		int t;

		public node(int s, int e, int t) {
			super();
			this.s = s;
			this.e = e;
			this.t = t;
		}

	}// node

	static int N, M; // city, bus
	static long[] time;
	static node[] edges;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		time = new long[N + 1]; // 1~N cities
		edges = new node[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			edges[i] = new node(s, e, t);
		} // for

		///////////// input fin///////////////////

		Arrays.fill(time, Integer.MAX_VALUE);
		///이거 잘못됐던듯? 생각해보면 1번이 언제나 먼저임
		time[1] = 0;

		if (!bellman()) {
			// if the graph is clean
			for (int i = 2; i <= N; i++) {
				if (time[i] == Integer.MAX_VALUE) {
					System.out.println(-1);
				} else
					System.out.println(time[i]);
			}
		} else {
			// if it has negative cycle
			System.out.println(-1);
		}

		br.close();

	}// main

	public static boolean bellman() {
		boolean yesNegCycle = false;
		// loop for count of node times(N)
		for (int i = 1; i <N; i++) {
			yesNegCycle = false;
			// loop all the edges
			for (int j = 0; j < M; j++) {
				node n = edges[j];

				if (time[n.s] != Integer.MAX_VALUE && time[n.e] > time[n.s] + n.t) {
					time[n.e] = time[n.s] + n.t;
					yesNegCycle = true;
				}

			}
			
			if(!yesNegCycle) break;

		}

		// check if it has a cycle
		for (int j = 0; j < M; j++) {
			node n = edges[j];

			if (time[n.s] != Integer.MAX_VALUE && time[n.e] > time[n.s] + n.t) {
				return true;
			}

		}

		return false;
	}
}// class
