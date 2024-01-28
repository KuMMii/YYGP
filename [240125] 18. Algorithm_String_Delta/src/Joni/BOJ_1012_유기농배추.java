//package 델타탐색.BOJ_1012_유기농배추;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Main {
//    // 상 하 좌 우
//    static int M,N,K;
//    static int[] dr = {-1, 1, 0, 0};
//    static int[] dc = {0, 0, -1, 1};
//    static boolean[][] visited;
//    static int[][] map;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        // T: tc
//        int T = sc.nextInt();
//        // M : 가로 길이, N : 세로 길이, K: 배추 심어진 위치 갯수
//        for (int t = 1; t <= T; t++) {
//            M = sc.nextInt();
//            N = sc.nextInt();
//            K = sc.nextInt();
//            int[][] cabbage = new int[K][2];
//            // cabbage: 배추흰지렁이 위치
//            for (int i = 0; i < K; i++) {
//                cabbage[i][0] = sc.nextInt();
//                cabbage[i][1] = sc.nextInt();
//            } // 입력 끝
//
//            // map: 배추밭
//            map = new int[M][N];
//            for (int i = 0; i < K; i++) {
//                map[cabbage[i][0]][cabbage[i][1]] = 1;
//            }
//
//            visited = new boolean[M][N];
//            // count : BFS 방문횟수 = 배추흰지렁이 수
//            int count = 0;
//            for (int i = 0; i < M; i++) {
//                for (int j = 0; j < N; j++) {
//                    if (!visited[i][j] && map[i][j] == 1) {
//                        visited[i][j] = true;
//                        BFS(i,j);
//                        count++;
//                    }
//                }
//            }
//
//
////            for (int i = 0; i < M; i++) {
////                for (int j = 0; j < N; j++) {
////                    System.out.print(map[i][j] + " ");
////                }
////                System.out.println();
////            }
//            System.out.println(count);
//        } // tc
//    } // main
//
//    public static void BFS(int r, int c) {
//
//        Queue<int[]> q = new LinkedList<>();
//        q.offer(new int[] {r,c});
//        visited[r][c] = true;
//
//        while(!q.isEmpty()) {
//            int[] pos = q.poll();
//
//            for (int d = 0; d < 4; d++) {
//                int nr = pos[0] + dr[d];
//                int nc = pos[1] + dc[d];
//                if(nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == 1) {
//                    visited[nr][nc] = true;
//                    q.offer(new int[] {nr, nc});
//                }
//            }
//        }
//    }
//} // class
