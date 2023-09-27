package boj_5014.inseung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 한참 경우의 수 나눠서 풀다가 DFS 라는걸 깨달음. -> 검색해보니 BFS 라는걸 깨달음.
// 왜 BFS지? 깊게 들어갈수록 더 느릴텐데. 물론 여러 경우일수록 빠를테지만 
// --> DFS로 하면 (7, 7, -3)이랑 (7, -3, 7)이랑 중복됨. (visited[] 썼으면 달랐으려나)
// --> 그리고 G층이 무지막지하게 크면, 한가지 경우 깊게 들어갔다가 다시 나오는게 비효율적임.
// --> BFS로 하면 visited[]로 이미 갔던 곳도 걸러지고, 최소횟수부터 훑을수 있음 

// BFS
// q에 현재층 기준으로 +U층, -D층 넣음 
// (이미 가본 층수라면 visited[] = true에서 걸러져서, U, D가 0인 경우도 자동 걸러짐)
// -> G층 도달하면 프린트하고 끝
// -> q가 빌때까지 반복. G층 도달 못하고 q가 비게 됐다는건 엘베로 못간단 소리.
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt(); // 총 층수
		S = sc.nextInt(); // 현재 위치
		G = sc.nextInt(); // 목표 층수
		U = sc.nextInt(); // UP 버튼
		D = sc.nextInt(); // DOWN 버튼

		q = new LinkedList<>();

		visited = new boolean[F + 1];

		if (S == G) {
			System.out.println(0);
		} else {
			visited[S] = true;
			BFS(S, 0);
		}

	} // main 메서드 끝

	// BFS 시행하는 메서드
	// x: 현재 층수, sum: 버튼 누른 횟수
	static void BFS(int x, int sum) {
		// 첫 시작: 맨 처음 시작 층수, 0 넣음
		offerTwo(x, sum);

		// 갈수있는 경우가 없으면 -> q가 비게 되고 -> use the stairs 프린트하게 됨
		while (!q.isEmpty()) {
			// 하나 뽑음
			int[] floor = q.poll();
			// 목표 층수 도달하면, 버튼 누른 횟수 프린트
			if (floor[0] == G) {
				System.out.println(floor[1]);
				return;
			}
			// q에서 뽑은거 기준으로 새롭게 +U층, -D층 감
			offerTwo(floor[0], floor[1]);

		}

		System.out.println("use the stairs");
	}

	// q에 x+U, x-D 넣는 메서드
	static void offerTwo(int x, int sum) {
		// 범위 안벗어나고 & 아직 안간 층수면
		if (x + U <= F && x + U >= 1 && !visited[x + U]) {
			// 새롭게 가는 층수, 버튼 누른 횟수 + 1 넣음
			q.offer(new int[] { x + U, sum + 1 });
			visited[x + U] = true;
		}
		if (x - D <= F && x - D >= 1 && !visited[x - D]) {
			q.offer(new int[] { x - D, sum + 1 });
			visited[x - D] = true;
		}
	}

	static int F, S, G, U, D;
	static Queue<int[]> q;
	static boolean[] visited; // 이미 가본 층수 = true
}