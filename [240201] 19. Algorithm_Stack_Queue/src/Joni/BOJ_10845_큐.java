package BOJ_10845_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];

            switch (command) {
                case "push":
                    int X = Integer.parseInt(input[1]);
                    q.offer(X);
                    break;
                case "pop":
                    if (!q.isEmpty()) {
                        System.out.println(q.poll());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    System.out.println(q.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(q.isEmpty() ? -1 : q.peek());
                    break;
                case "back":
                    System.out.println(q.isEmpty() ? -1 : q.peekLast());
                    break;
            }
        }

        br.close();
    }
}
