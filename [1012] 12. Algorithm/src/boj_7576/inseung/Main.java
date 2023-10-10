package boj_7576.inseung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// BFS
public class Main {
	static class Tomato {
		int r;
		int c;
		int day; // 익은 날짜

		public Tomato(int r, int c, int day) {
			super();
			this.r = r;
			this.c = c;
			this.day = day;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // 가로 칸 수
		int N = sc.nextInt(); // 세로 칸 수
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		int[][] delta = { { -1, 0, 1, 0 }, { 0, 1, 0, -1 } }; // 상우하좌
		Queue<Tomato> q = new LinkedList<>();
		int sum = 0; // 익어야되는 토마토 총 개수 (0,1 입력된거) (빈거(-1) 빼고)

		// map 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				// 시작부터 익어있는거 (1) : q에 넣음
				if (map[i][j] == 1) {
					q.offer(new Tomato(i, j, 0));
					visited[i][j] = true;
				}
				// 토마토 총 개수 셈
				if (map[i][j] != -1) {
					sum++;
				}
			}
		} // map 입력 끝

		int sum2 = 0; // 익은 토마토 총 개수 (sum이랑 똑같아야 다 익을수 있음)
		int day = 0; // 마지막에 q에서 poll될 day

		// q 빌때까지 반복
		while (!q.isEmpty()) {
			// q에서 하나 뽑아서
			Tomato tomato = q.poll();
			sum2++;
			int r = tomato.r;
			int c = tomato.c;
			day = tomato.day;
			// 주변 토마토들 다 익게 함
			for (int w = 0; w < 4; w++) {
				int nr = r + delta[0][w];
				int nc = c + delta[1][w];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] != -1) {
					q.add(new Tomato(nr, nc, day + 1)); // day + 1 (하루 지나서 익음)
					visited[nr][nc] = true;
				}
			}
		} // while문 끝
		
		// 익어야 할 토마토 총 개수 != 익은 토마토 총 개수 --> -1 프린트
		if (sum2 != sum) {
			System.out.println(-1);
		} else {
			System.out.println(day);
		}
	}
}
