package boj_9663.inseung;

import java.util.Scanner;

// 재귀, 완전탐색
// 메모리 초과
public class Main {
	static int N; // N칸
	static int answer; // 총 경우의 수

	// r행에서 퀸의 위치를 정해주는 메서드 (place[i] = i행의 퀸의 위치)
	static void search(int r, int[] place) {
		// 마지막 행까지 퀸 위치 정해졌으면: answer + 1 하고, return해서 재귀 끝낸다
		if (r == N) {
			answer++;
			return;
		}

		boolean[] visited = new boolean[N];
		// 위의 행들에 이미 정해진 퀸의 위치를 고려해서 - 세로로 퀸이 올수있는 열, 대각선으로 퀸이 올수있는 열은 visited[]를 true로 바꿔줌
		for (int i = r - 1; i >= 0; i--) { 
			int temp = place[i]; // 이전 i행의 퀸의 위치(열) 
			// 세로로 퀸이 올수 있는 열이면 true로 바꿔줌
			visited[temp] = true;
			// 대각선 왼쪽으로 퀸이 올수 있는 열이면 true로 바꿔줌
			if (temp - (r - i) >= 0 && temp - (r - i) < N) {
				visited[temp - (r - i)] = true;
			}
			// 대각선 오른쪽으로 퀸이 올수 있는 열이면 true로 바꿔줌
			if (temp + (r - i) >= 0 && temp + (r - i) < N) {
				visited[temp + (r - i)] = true;
			}
		}

		// visited[i]가 false인 곳은 퀸이 올수 있는 경우임 -> 그 경우 다 재귀
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				place[r] = i; // 이번 행 퀸 위치 정해주고
				search(r + 1, place); // 다음행 퀸 위치 정해주러 감
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 칸 수
		answer = 0;

		// 0행에 퀸 위치 정해주고, 1행 퀸 위치 정해주러 감
		for (int i = 0; i < N; i++) {
			int[] place = new int[N];
			place[0] = i;
			search(1, place);
		}
		
		System.out.println(answer);
	}
}
