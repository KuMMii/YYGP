package boj_20056.inseung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//SWEA 미생물 모의고사 기현이 풀이 생각하며 품
public class Main {

	static class Ball {
		int r;
		int c;
		int m; // 질량
		int s; // 몇칸 이동
		int d; // 방향
		int n; // 이동 횟수

		public Ball() {
		}

		public Ball(int m, int s, int d) {
			super();
			this.m = m;
			this.s = s;
			this.d = d;
		}

		public Ball(int r, int c, int m, int s, int d, int n) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
			this.n = n;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 격자 크기
		int M = sc.nextInt(); // 파이어볼 개수
		int K = sc.nextInt(); // K번 이동한다
		List<Ball>[][] map = new ArrayList[N][N];
		List<Ball> list = new ArrayList<>();
		int answer = 0; // 질량의 합

//		Arrays.fill(map, new ArrayList<Ball>()); //1차원 배열만 가능

		// NullPointerException 방지 위해 빈 리스트 넣어둠
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<Ball>();
			}
		}

		// map 위치에 Ball 객체 저장
		for (int m = 0; m < M; m++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			Ball ball = new Ball(r, c, sc.nextInt(), sc.nextInt(), sc.nextInt(), 1);
			map[r][c].add(ball);
		}

		// K번 이동 = 1. 배열 다 훑으며 이동 + 2. 한칸에 여러개면 4개로 쪼갬
		for (int mov = 1; mov <= K; mov++) {
			// 1. 배열 다 훑으며 이동
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temp = map[i][j].size();
					// 리스트에 ball 한개라도 있고,
					if (temp > 0) {
						for (int a = temp - 1; a >= 0; a--) { //Point! remove하면 순서 엉켜서 끝에서부터 해줌!!
							Ball ball = map[i][j].get(a);
							// 이번 이동횟수 도는 차례라면 (이미 이동한 ball 아니라면) -> 움직여줌
							if (ball.n == mov) {
								Ball newBall = move(ball);
								map[newBall.r][newBall.c].add(newBall);
								map[i][j].remove(a); // 원래 위치 리스트에선 빼줌
							}
						}
					}
				}
			} // 1번 끝

			// 2. 한칸에 여러개면 4개로 쪼갬
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temp = map[i][j].size();
					// 한칸에 2개 이상이면
					if (temp > 1) {
						int nm = 0;
						int ns = 0;
						int nd = 0; // 방향을 2로 나눈값을 다 더해줄 변수
						int nn = 0;
						Ball newBall = new Ball();
						
						// 모든 ball에 대해서
						for (int a = 0; a < temp; a++) {
							Ball ball = map[i][j].get(a);
							nd += ball.d % 2; // 방향 2로 나눈값 다 더해줌
							nm += ball.m; // 질량 다 더해줌
							ns += ball.s; // 속력 다 더해줌
							nn = ball.n;
						}
						//새롭게 4개로 쪼갤거니까 리스트 clear해줌
						map[i][j].clear();
						nm /= 5;
						ns /= temp;

						if (nm == 0) {
							// 질량이 0이면 암것도 안함 (소멸됨)
						} else if (nd == temp || nd == 0) { // 모든 ball 방향이 다 홀수거나 다 짝수인 경우
							map[i][j].add(new Ball(i, j, nm, ns, 0, nn));
							map[i][j].add(new Ball(i, j, nm, ns, 2, nn));
							map[i][j].add(new Ball(i, j, nm, ns, 4, nn));
							map[i][j].add(new Ball(i, j, nm, ns, 6, nn));
						} else {
							map[i][j].add(new Ball(i, j, nm, ns, 1, nn));
							map[i][j].add(new Ball(i, j, nm, ns, 3, nn));
							map[i][j].add(new Ball(i, j, nm, ns, 5, nn));
							map[i][j].add(new Ball(i, j, nm, ns, 7, nn));
						}
					}
				}
			} // 2번 끝
		} // K번 이동 끝
		
		// 질량 합 구하기 - 배열 다 돌면서, list의 size가 1보다 크거나 같으면, 질량 다 더해줌
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int temp = map[i][j].size();
				if (temp >= 1) {
					for (int a = 0; a < temp; a++) {
						answer += map[i][j].get(a).m;
					}
				}
			}
		}

		System.out.println(answer);
	}

	static int N;

	// ball 움직이기
	static Ball move(Ball ball) {
		int r = ball.r;
		int c = ball.c;
		int m = ball.m;
		int s = ball.s;
		int d = ball.d;
		int n = ball.n;
		int nr = -1;
		int nc = -1;

		// 0행이랑 N-1행이랑 연결돼있어서 이거 해주는거임
		switch (d) {
		case 0:
			nr = (r - s) % N;
			nc = c;
			break;
		case 1:
			nr = (r - s) % N;
			nc = (c + s) % N;
			break;
		case 2:
			nr = r;
			nc = (c + s) % N;
			break;
		case 3:
			nr = (r + s) % N;
			nc = (c + s) % N;
			break;
		case 4:
			nr = (r + s) % N;
			nc = c;
			break;
		case 5:
			nr = (r + s) % N;
			nc = (c - s) % N;
			break;
		case 6:
			nr = r;
			nc = (c - s) % N;
			break;
		case 7:
			nr = (r - s) % N;
			nc = (c - s) % N;
			break;
		}
		
		//음수는 나눠도 그대로라서 N 더해줌
		if (nr < 0) nr += N;
		if (nc < 0) nc += N;
		
		// 새로운 행렬 위치 넣어줌, 이동횟수 +1 해줌
		return new Ball(nr, nc, m, s, d, n + 1);
	} // move 메서드 끝

}
