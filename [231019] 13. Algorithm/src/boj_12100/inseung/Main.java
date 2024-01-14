package boj_12100.inseung;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// DFS
// mapBefore, mapAfter : 그때그때 전후 map에 숫자를 대입해줌
// (DFS로 한가지 경우 다 돌고 다음 경우 돌기때매 가능했음)
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map0 = new int[N][N];
		map1 = new int[N][N];
		map2 = new int[N][N];
		map3 = new int[N][N];
		map4 = new int[N][N];
		map5 = new int[N][N];
		mapBefore = new int[N][N];
		mapAfter = new int[N][N];
		max = 2;
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map0[i][j] = sc.nextInt();
			}
		}
		
		for (int n = 1; n<=5; n++) {
			move(n);
		}
		
		System.out.println(max);
	}

	static int N;
	static int[][] map0; // 처음 map
	static int[][] map1; // 1턴 map
	static int[][] map2;
	static int[][] map3;
	static int[][] map4;
	static int[][] map5; // 5턴 map
	static int[][] mapBefore; // 이동할떄 그전map
	static int[][] mapAfter; // 이동한 후의 map
	static int max; // 최대 숫자 = 정답
	static Queue<Integer> q;
	static int[] way = {0,1,2,3}; //상하좌우 방향
	
	static void move(int n) {
		// 5번 이동하면 return
		if (n == 6) {
			// map5 (5턴 끝낸 map)에서 최대값 찾음
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (max < map5[i][j]) {
						max = map5[i][j];
					}
				}
			}
			return;
		}
		
		// 상하좌우 * 5번 - 모든 경우의 수 다돔 
		// a: 0123 순서대로 재귀
		// n: move() 마치면 n번 이동한거임
		for (int a = 0; a<=3; a++) {
			whichWay(a, n); // a방향으로 n턴 마치고
			move(n+1); // n+1턴 하러감
		}
		
		
	}
	
	// 4방향 중 어느 방향으로 갈지 고르는 메서드
	static void whichWay(int i, int n) {
		switch (i)  {
		case 0: left(n, n+1); break;
		case 1: right(n, n+1); break;
		case 2: down(n, n+1); break;
		case 3: up(n, n+1); break;
	}
	}
	
	// before, after 대입할 map 고르는 메서드
	static int[][] whichMap(int i) {
		switch (i) {
		case 1: return map0; // 1턴: map0 -> map1로 감
		case 2: return map1;
		case 3: return map2;
		case 4: return map3;
		case 5: return map4;
		default: return map5;
		}
	}

	static void left(int numBefore, int numAfter) {
		mapBefore = whichMap(numBefore);
		mapAfter = whichMap(numAfter);
		// 한 열씩 훑음
		for (int i = 0; i < N; i++) {
			// 한 행에 대해, 0이 아닌 값은 다 q에 넣을거임
			for (int j = 0; j < N; j++) {
				if (mapBefore[i][j] != 0) {
					int target = mapBefore[i][j];
					// N-1이면 다음수 없으니까 그냥 q에 넣어줌
					if (j == N - 1) {
						q.offer(target);
						continue;
					}
					// 14%에서 틀림 - 연속 같은수 말고 사이에 0 있는 경우 생각 못함
					// -> 바로 밑에 while문, if문 추가함
					// 다음수가 0이면 j+1해줌
					while (j != N-1 ) {
						if (mapBefore[i][j+1] == 0) {
							j++;
						} else break;
					}
					
					if (j == N - 1) {
						q.offer(target);
						continue;
					}
					
					// 같은 수 나오면, 2배해서 q에 넣고, 다음값은 건너뜀
					if (target == mapBefore[i][j + 1]) {
						q.offer(target * 2);
						j++;
					// 다음수랑 같은수가 아니면, 그냥 q에 넣어줌
					} else	q.offer(target);
				}
			}
			
			int j = 0;
			while (!q.isEmpty()) {
				mapAfter[i][j++] = q.poll();
			}
			for (int jj = j; jj < N; jj++) {
				mapAfter[i][jj] = 0;
			}
		} // i 끝. 한 열 다 훑음
	}

	static void right(int numBefore, int numAfter) {
		mapBefore = whichMap(numBefore);
		mapAfter = whichMap(numAfter);
		for (int i = 0; i < N; i++) {
			// 한 행에 대해, 0이 아닌 값은 다 q에 넣을거임
			for (int j = N - 1; j >= 0; j--) {
				if (mapBefore[i][j] != 0) {
					int target = mapBefore[i][j];
					// 0이면 다음수 없으니까 그냥 q에 넣어줌
					if (j == 0) {
						q.offer(target);
						continue;
					}
					while (j != 0) {
						if (mapBefore[i][j-1] == 0) {
							j--;
						} else break;
					}
					
					if (j == 0) {
						q.offer(target);
						continue;
					}
					
					// 연속 같은 수 나오면, 2배해서 q에 넣고, 다음값은 건너뜀
					if (target == mapBefore[i][j - 1]) {
						q.offer(target * 2);
						j--;
					// 다음수랑 같은수가 아니면, 그냥 q에 넣어줌
					} else	q.offer(target);
				}
			}
			int j = N-1;
			while (!q.isEmpty()) {
				mapAfter[i][j--] = q.poll();
			}
			for (int jj = j; jj >= 0; jj--) {
				mapAfter[i][jj] = 0;
			}
		}
	}
	
	static void down(int numBefore, int numAfter) {
		mapBefore = whichMap(numBefore);
		mapAfter = whichMap(numAfter);
		for (int i = 0; i < N; i++) {
			// 한 행에 대해, 0이 아닌 값은 다 q에 넣을거임
			for (int j = N - 1; j >= 0; j--) {
				if (mapBefore[j][i] != 0) {
					int target = mapBefore[j][i];
					// 0이면 다음수 없으니까 그냥 q에 넣어줌
					if (j == 0) {
						q.offer(target);
						continue;
					}
					while (j != 0) {
						if (mapBefore[j-1][i] == 0) {
							j--;
						} else break;
					}
					
					if (j == 0) {
						q.offer(target);
						continue;
					}
					
					// 연속 같은 수 나오면, 2배해서 q에 넣고, 다음값은 건너뜀
					if (target == mapBefore[j - 1][i]) {
						q.offer(target * 2);
						j--;
						// 다음수랑 같은수가 아니면, 그냥 q에 넣어줌
					} else	q.offer(target);
				}
			}
			int j = N-1;
			while (!q.isEmpty()) {
				mapAfter[j--][i] = q.poll();
			}
			for (int jj = j; jj >= 0; jj--) {
				mapAfter[jj][i] = 0;
			}
		}
	}
	
	static void up(int numBefore, int numAfter) {
		mapBefore = whichMap(numBefore);
		mapAfter = whichMap(numAfter);
		for (int i = 0; i < N; i++) {
			// 한 행에 대해, 0이 아닌 값은 다 q에 넣을거임
			for (int j = 0; j < N; j++) {
				if (mapBefore[j][i] != 0) {
					int target = mapBefore[j][i];
					// N-1이면 다음수 없으니까 그냥 q에 넣어줌
					if (j == N - 1) {
						q.offer(target);
						continue;
					}
					while (j != N-1) {
						if (mapBefore[j+1][i] == 0) {
							j++;
						} else break;
					}
					
					if (j == N - 1) {
						q.offer(target);
						continue;
					}
					
					// 연속 같은 수 나오면, 2배해서 q에 넣고, 다음값은 건너뜀
					if (target == mapBefore[j+1][i]) {
						q.offer(target * 2);
						j++;
					// 다음수랑 같은수가 아니면, 그냥 q에 넣어줌
					} else	q.offer(target);
				}
			}
			int j = 0;
			while (!q.isEmpty()) {
				mapAfter[j++][i] = q.poll();
			}
			for (int jj = j; jj < N; jj++) {
				mapAfter[jj][i] = 0;
			}
		}
	}
	
	
}
