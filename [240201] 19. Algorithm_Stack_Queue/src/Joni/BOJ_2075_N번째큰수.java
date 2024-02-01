package BOJ_2075_N번째큰수;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                pq.add(map[i][j]);
            }
        } // 입력 끝

        int num = 0;
        for (int i = 0; i < N; i++) {
            num = pq.poll();
        }

        System.out.println(num);

    }
}
