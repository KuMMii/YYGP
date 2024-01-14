package boj_4485.ryu;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static int[][] cost;
	static int[] dcs = new int[] {1, 0, -1, 0};
	static int[] drs = new int[] {0, 1, 0, -1};
	static class Node implements Comparable<Node> {
		int r, c, w;

		public Node(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	private static void dijkstra() {
		cost[0][0] = arr[0][0];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, arr[0][0]));
		
//		boolean[][] visited = new boolean[N][N];
		while (!pq.isEmpty()) {
			Node n = pq.remove();
			// 뽑았을 때 끝이면 반복을 멈춰도 되지 않나? 될 것 같다.
			if (n.r==N-1 && n.c==N-1) {
                cost[N-1][N-1] = n.w;
                break;
            }
			
			// visited 배열의 효과가 있을까? 딱히 없을 것 같다.
//			if (visited[n.r][n.c]) continue;
//			visited[n.r][n.c] = true;
			
			for (int i=0; i<4; i++) {
				int nc = n.c+dcs[i];
				int nr = n.r+drs[i];
				if (nc<0 || nc>=N || nr<0 || nr>=N) continue;
				int nw = n.w + arr[nr][nc];
				if (nw < cost[nr][nc]) {
					cost[nr][nc] = nw;
					pq.add(new Node(nr, nc, nw));						
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc=1;
		while (true) {
			N = sc.nextInt();
			if (N==0) break;
			
			arr = new int[N][N];
			cost= new int[N][N];
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					arr[r][c] = sc.nextInt();
					cost[r][c] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra();
			System.out.println("Problem "+tc+": "+cost[N-1][N-1]);
			tc++;
		}
		
		sc.close();
	}


	

}
