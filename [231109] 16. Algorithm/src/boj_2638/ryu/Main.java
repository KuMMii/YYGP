package boj_2638.ryu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int R, C;
	static int[][] arr;
	static int[] dr = new int[] {0,0,1,-1};
	static int[] dc = new int[] {1,-1,0,0};
	static int cheeze = 0;
	static int OUTSIDE = -1;
	static int INSIDE = 0;
	static int CHEEZE = 1;
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		arr = new int[R][C];
		
		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				int data = sc.nextInt();
				arr[r][c] = data;
				if (data==CHEEZE) cheeze++;
			}
		}
		
		System.out.println(bfs());
		
		sc.close();
	}

	private static int bfs() {
		int iteration = 0;
		outer:
		while (cheeze>0) {
			//0.반복회수 갱신
			iteration++;
			//1.바깥공기 갱신
			findOutside();
			//2.치즈 주변의 바깥공기 갱신
			for (int r=1; r<R-1; r++) {
				for (int c=1; c<C-1; c++) {
					if (arr[r][c]==CHEEZE) {
						for (int i=0; i<4; i++) {
							int nr, nc;
							nr = r+dr[i];
							nc = c+dc[i];
							if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
							
							if (arr[nr][nc]==OUTSIDE) arr[r][c]++;
						}
					}
				}
			}
			//3.사라질 치즈들 제거
			for (int r=1; r<R-1; r++) {
				for (int c=1; c<C-1; c++) {
					if (arr[r][c]>=3) {
						arr[r][c] = 0;
						cheeze--;
						if (cheeze==0) break outer;
					}
				}
			}
			//4.배열 초기화(치즈는 1로, 바깥 공기는 0으로, 안 공기는 그대로 0)
			for (int r=0; r<R; r++) {
				for (int c=0; c<C; c++) {
					if (arr[r][c]==OUTSIDE) arr[r][c] = 0;
					if (arr[r][c]>=1) arr[r][c] = CHEEZE;
				}
			}
		}
		
		return iteration;
	}
	
	private static void findOutside() {
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		q.offer(new Pos(0, 0));
		
		//내부공간 파악
		while (!q.isEmpty()) {
			Pos p = q.poll();
			int r, c;
			r = p.r;
			c = p.c;
			if (visited[r][c]) continue;
			visited[r][c] = true;
			arr[r][c] = OUTSIDE;
			
			for (int i=0; i<4; i++) {
				int nr, nc;
				nr = r+dr[i];
				nc = c+dc[i];
				if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
				if (arr[nr][nc]==CHEEZE || visited[nr][nc]) continue;
				
				q.offer(new Pos(nr, nc));
			}
		}
	}
}
