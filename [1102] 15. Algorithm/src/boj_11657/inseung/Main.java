package boj_11657.inseung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
// Arrays.fill(list, new ArrayList<>()); 
// --> 이렇게 하면 모든 배열 안의 리스트가  다 같은 ArrayList를 참조하게 돼서,
// 한 리스트에 1 넣으면, 모든 배열 안의 리스트가 죄다 1 가지게 됨. 나 진짜 이것때매 미치고 팔짝뛰는줄 알았음.

// DFS 생각했던거 하다가 벨만포드 논리 찾아서 함 (기현이 tip)
// 메모리 초과!
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		edge = new int[N + 1][N + 1];
		list = new ArrayList[N + 1]; // 배열 안에 리스트
		answer = new int[N + 1];
		// 1~N 인덱스에 빈 리스트 다 대입해줌
		for (int i = 1; i<N+1; i++) {
			list[i] = new ArrayList<>(); 
		}
		// 일단 가중치합이 무한대라고 가정하고, 최소 가중치합을 대입해줄거임
		Arrays.fill(answer, Integer.MAX_VALUE);
		// list, edge에 값 대입
		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			list[a].add(b); // list[a]의 리스트 = a에서 갈수있는 정점 리스트
			edge[a][b] = w;
		}
		
		// 1번 정점에서부터 temp정점으로 갔다. find() 호출해서 다음 정점 가라.
		for (int i = 0; i < list[1].size(); i++) {
			int temp = list[1].get(i);
			answer[temp] = edge[1][temp];
			find(1, temp, edge[1][temp]);

		}

		// 무한루프 발견했으면 -> -1만 달랑 출력
		if (answer[0] == -1) {
			System.out.println(-1);
		} else {
			for (int i = 2; i <= N; i++) {
				// 아예 정점으로 안가서 그대로 무한대 남아있으면 -> -1 출력
				if (answer[i] == Integer.MAX_VALUE) {
					System.out.println(-1);
				} else {
					// 나머지 경우는 최소 가중치 합 출력
					System.out.println(answer[i]);
				}
			}
		}

	}

	static int N; // 정점 개수
	static int M; // 가중치 개수
	static int[][] edge; // 방향 있는 가중치 넣은 2차원배열
	static List<Integer>[] list; // list[a]의 리스트 = a에서 갈수있는 정점 리스트
	static int[] answer;

	// start에서 end로 갔음. 이제 이 메서드에서, end에서 시작해. / 가중치 총합 sum
	static void find(int start, int end, int sum) {
		if (end == 1) {
			// 무한루프 되는 경우
			if (sum < 0) {
				answer[0] = -1; // 무한루프 발견했다고 표시
			}
			// 1로 돌아왔으면 무조건 STOP
			return;
		}
		for (int a = 0; a < list[end].size(); a++) {
			int nextEnd = list[end].get(a);
			// 다음 정점까지의 가중치 합이, 이미 넣어둔 answer배열보다 작으면
			if (sum + edge[end][nextEnd] < answer[nextEnd]) {
				// 값 넣어줌
				answer[nextEnd] = sum + edge[end][nextEnd];
			}
			// 다음 정점을 향해 탐색한다
			find(end, nextEnd, sum + edge[end][nextEnd]);
		}
	}

}
