package boj_17471.inseung;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1. powerset() 재귀부분 : 부분집합 모든 경우의 수 구함 - visited[]에 true/false 두 부분집합으로 나뉨 
// -> 2. connected() : 두 부분집합이 각각 BFS로 다 연결돼있는 곳인지 확인
// -> 3. powerset() 기저부분 : 각각 연결돼있는 곳이면 인구 차이 계산
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		people = new int[N + 1];

		// 인구 수
		for (int i = 1; i < N + 1; i++) {
			people[i] = sc.nextInt();
		}

		// 인접행렬
		adjArr = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			int num = sc.nextInt();
			for (int j = 1; j <= num; j++) {
				int t = sc.nextInt();
				adjArr[i][t] = 1;
				adjArr[t][i] = 1;
			}
		}

		min = 987654321;
		visited = new boolean[N + 1];

		powerset(1, 0);
		
		if (min == 987654321) min = -1;
		
		System.out.println(min);

	}

	static int N; // 1~N구역
	static int M;
	static int[] people; // 인구
	static int[][] adjArr; // 인접행렬
//	static int[] p; // 최고조상
	static boolean[] visited; // 부분집합 2개로 나눔 - true/false
	static boolean[] BFSvisited; // BFS 탐색할때 이미 q에 넣은건지 판별
	static Queue<Integer> q;
	static int min; // 인구수 차이 최소값

	// x: (재귀 부분에서) visited[x]를 true로 만들지 봄
	// trueNum: visited[]에서 true인 것의 개수
	static void powerset(int x, int trueNum) {
//		System.out.println("--" + x + "." + trueNum);
		// 기저 부분 - 두 부분집합이 각각 서로 다같이 연결돼있으면 -> 인구 차이 계산
		if (x == N+1) {
			int diff = 0;
			if (connected(x, trueNum, true) && connected(x, trueNum, false)) {
//				System.out.println(Arrays.toString(visited));
				for (int i = 1; i < N + 1; i++) {
					if (visited[i]) {
						diff += people[i];
					} else {
						diff -= people[i];
					}
				}
				if (min > (int) Math.abs(diff)) {
					min = (int) Math.abs(diff);
//					System.out.println(min);
				}
			}
			return;
		}

		// 재귀 부분 - x부터 시작해서 부분집합을 true/false 2개로 나눔
		visited[x] = true;
		powerset(x + 1, trueNum + 1);
		visited[x] = false;
		powerset(x + 1, trueNum);
	}

	// visited[]가 true/false인거끼리 다 연결돼있으면 -> true 반환
	static boolean connected(int x, int trueNum, boolean b) {
//		System.out.println(Arrays.toString(visited));
		q = new LinkedList<>();
		BFSvisited = new boolean[N+1];
		int connectedNum = 0; // 같은 부분집합에서, 서로 연결돼있는 원소들의 개수

		// BFS로 서로 연결돼있는 원소들의 개수(connectedNum) 구함
		for (int i = 1; i < N + 1; i++) {
			if (visited[i] == b) {
				q.offer(i);
				BFSvisited[i] = true;
				break;
			}
		}
		while (!q.isEmpty()) {
			int n = q.poll();
			// q에서 뽑을 때마다, 서로 연결돼있는 원소들의 개수 + 1
			connectedNum++;
			for (int i = 1; i < N + 1; i++) {
				// 간선으로 이어져있고 & visited[]에서 같은 부분집합이고 & BFS로 아직 방문하지 않았으면 --> q에 집어넣음
				if (adjArr[n][i] == 1 && visited[i] == b && !BFSvisited[i]) {
					q.offer(i);
					BFSvisited[i] = true;
				}
			}
		}

		// 서로 연결돼있는 원소들의 개수(connectedNum) & visited로 만들어져있는 부분집합의 원소들의 개수(trueNum) - 같으면 true 반환
		if ((b && connectedNum == trueNum) || (!b && connectedNum == N - trueNum)) {
			return true;
		} else
			return false;
	}
}
