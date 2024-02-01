package silver.boj_2075_N번째_큰_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

//        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // N*N의 표
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            } //for j
        } //for i

//        int n = pq.size() - N;
//        for(int i = 0; i < n; i++) {
//            pq.poll();
//        }
        for(int i = 0; i < N-1; i++) {
            pq.poll();
        }
        System.out.println(pq.peek());

    }
}
