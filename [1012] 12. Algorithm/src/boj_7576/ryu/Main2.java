package boj_7576.ryu;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
	static int[][] arr;
	static int[][] visited;
	static int R;
	static int C;
	static int[] dr = new int[] {0, 1, 0, -1};
	static int[] dc = new int[] {1, 0, -1, 0};
	
	static class Pos {
		int r, c, day;

		public Pos(int r, int c, int day) {
			super();
			this.r = r;
			this.c = c;
			this.day = day;
		}
	}

	private static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		visited = new int[R][C];
		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				// visited == -1 : 익지 않은 토마토
				visited[r][c] = -1;
				
				if (arr[r][c] == 1) q.offer(new Pos(r, c, 0));
				// 토마토가 없는 공간은 그냥 토마토가 0번째 날에 익은 것으로 간주
				else if (arr[r][c] == -1) visited[r][c] = 0;
			}
		}
		
		while (!q.isEmpty()) {
			Pos p = q.remove();
			if (visited[p.r][p.c] > 0) continue;
			visited[p.r][p.c] = p.day;
			
			for (int d=0; d<4; d++) {
				int nr, nc;
				nr = p.r + dr[d];
				nc = p.c + dc[d];
				if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
				
				if (arr[nr][nc] == 0) {
					q.add(new Pos(nr, nc, p.day+1));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		C = readInt();
		R = readInt();
		arr = new int[R][C];
	
		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				arr[r][c] = readInt();
			}
		}
		
		bfs();
		
		int ans = 0;
		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				if (visited[r][c] == -1) {
					System.out.println(-1);
					sc.close();
					return;
				} else if (visited[r][c] > ans) {
					ans = visited[r][c];
				}
			}
		}
		System.out.println(ans);
		
		sc.close();
	}
    
	//
    static int readInt() throws IOException {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input<=32)
                return isNegative ? n * -1 : n;
            else if(input=='-')
                isNegative = true;
            else
                n = (n<<3) + (n<<1) + (input&15);
        }
    }
}
