package boj_4485.inseung;

import java.util.PriorityQueue;
import java.util.Scanner;

// 다잌스트라 
// pq에 넣는 node : 새롭게 poll한 node에서 갈수있는 node 다 넣음
// pq에서 뽑는 node : 후보 node들 중 시작점에서의 최소거리인 node를 뽑음 
// (이걸 반복하면, 시작점에서부터 모든 node들까지의 최소거리를 각각 다 구할수 있음) 
public class Main {
	static class Node implements Comparable<Node> {
		int r;
		int c;
		int d;

		public Node(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}

		public int compareTo(Node n) {
			return this.d - n.d;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = 1;
		while (true) {
			N = sc.nextInt();
			if (N == 0)
				break;
			cage = new int[N][N];
			visited = new boolean[N][N];
			pq = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cage[i][j] = sc.nextInt();
				}
			}

			// [0,0]에서 시작
			visited[0][0] = true;
			int i = 0;
			int j = 0;
			int d = cage[0][0];

			// [N-1,N-1] 도착할때까지 반복
			while (!(i == N - 1 && j == N - 1)) {
				// 뽑았던 node에서부터 갈수있는 node들의 정보를 pq에 넣음
				for (int w = 0; w < 4; w++) {
					int nr = i + delta[0][w];
					int nc = j + delta[1][w];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
						// d: 시작점에서부터 그 node까지의 거리 합계
						pq.add(new Node(nr, nc, d + cage[nr][nc]));
					}
				}
				// pq에서 node까지의 거리(d)가 최소인 node 뽑음
				Node node = pq.poll();
				// 그 node의 정보를 변수에 저장
				i = node.r;
				j = node.c;
				d = node.d;
				// 그 node까지의 길 이어짐
				visited[i][j] = true;
			}

			System.out.println("Problem " + k++ + ": " + d);

		}

	}

	static int N;
	static int[][] cage;
	static boolean[][] visited;
	static int[][] delta = { { -1, 0, 1, 0 }, { 0, 1, 0, -1 } }; // 상우하좌
	static PriorityQueue<Node> pq;

}
