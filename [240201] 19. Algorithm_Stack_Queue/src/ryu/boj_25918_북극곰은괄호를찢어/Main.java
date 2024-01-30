package ryu.boj_25918_북극곰은괄호를찢어;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

//질문게시판 참고.. 어렵당.
public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/ryu/boj_25918_북극곰은괄호를찢어/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        char[] target = br.readLine().trim().toCharArray();
        Stack<Character> stack = new Stack<>();
        int ans = 0;

        for (int i=0; i<N; i++) {
            if (stack.isEmpty()) {
                stack.push(target[i]);
            } else {
                if (stack.peek() == target[i]) {
                    stack.push(target[i]);
                } else {
                    stack.pop();
                }
            }

            if (stack.size() > ans) {
                ans = stack.size();
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(-1);
            return;
        }

        System.out.println(ans);
    }
}
