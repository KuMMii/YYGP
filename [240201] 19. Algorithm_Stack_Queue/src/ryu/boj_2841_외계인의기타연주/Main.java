package ryu.boj_2841_외계인의기타연주;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = line[0];
        int P = line[1];

        Stack<Integer>[] stacks = new Stack[7];
        for (int i=1; i<7; i++) {
            stacks[i] = new Stack<>();
        }

        int ans = 0;
        for (int n=0; n<N; n++) {
            line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int idx = line[0];
            int fret = line[1];

            Stack<Integer> stack = stacks[idx];

            if (stack.isEmpty() || fret > stack.peek()) {
                stack.push(fret);
                ans++;
            } else if (fret < stack.peek()) {
                stack.pop();
                ans++;
                while (!stack.isEmpty() && fret < stack.peek()) {
                    stack.pop();
                    ans++;
                }
                if (stack.isEmpty() || stack.peek() != fret) {
                    ans++;
                    stack.push(fret);
                }
            } else {
                continue;
            }
        }

        System.out.println(ans);
    }
}
