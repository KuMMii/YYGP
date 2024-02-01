package ryu.boj_2075_n번째큰수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {
    static int N;
    static int MINUS_INFINITY = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Stack<Integer>[] stacks = new Stack[N];
        for (int c=0; c<N; c++) {
            stacks[c] = new Stack<>();
        }


        for (int r=0; r<N; r++) {
            int[] row = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int c=0; c<N; c++) {
                stacks[c].push(row[c]);
            }
        }

        int ans=0;
        for (int i=0; i<N; i++) {
            int max = MINUS_INFINITY;
            int idx = 0;
            for (int c=0; c<N; c++) {
                if (stacks[c].peek() > max) {
                    max = stacks[c].peek();
                    idx = c;
                }
            }

//            스택이 비는 경우 없음
            ans = stacks[idx].pop();
        }
        System.out.println(ans);
    }
}
