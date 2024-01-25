package sy.boj_1012_유기농_배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] field;
    static int N, M;
    // 상, 우, 하, 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 개수
//        int T = sc.nextInt();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            //배추밭의 가로길이
//            M = sc.nextInt();
            M = Integer.parseInt(st.nextToken());
            //배추밭의 세로길이
//            N = sc.nextInt();
            N =  Integer.parseInt(st.nextToken());
            field = new int[N][M];

            //배추가 심어져 있는 위치
//            int K = sc.nextInt();
            int K = Integer.parseInt(st.nextToken());

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
//                int X = sc.nextInt();
                int X = Integer.parseInt(st.nextToken());
//                int Y = sc.nextInt();
                int Y = Integer.parseInt(st.nextToken());
                field[Y][X] = 1;
            }// 입력 끝

//            for(int i = 0; i < N; i++) {
//                for(int j = 0; j < M; j++) {
//                    System.out.print(field[i][j]);
//                }
//                System.out.println();
//            }

            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(field[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }//tc
    }//main

    static void bfs(int r, int c) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(r, c));

        while(!q.isEmpty()) {
            Pos curr = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int nextR = curr.r + dr[dir];
                int nextC = curr.c + dc[dir];
                if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && field[nextR][nextC] == 1) {
                    q.add(new Pos(nextR, nextC));
                    field[nextR][nextC] = 2;
                }
            }
        }
    }

}//Main
