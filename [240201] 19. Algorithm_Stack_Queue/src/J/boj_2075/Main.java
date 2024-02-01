package J.boj_2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num;
                if (st.hasMoreTokens()) {
                    num = Integer.parseInt(st.nextToken());
                    if (pq.size() < N) {
                        pq.add(num);
                    } else {
                        if (pq.peek()<num) {
                            pq.add(num);
                            pq.poll();
                        }
                    }
                }
            }
        }
        System.out.println(pq.peek());
    }
}
