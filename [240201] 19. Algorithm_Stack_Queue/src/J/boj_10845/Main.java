package J.boj_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] queue = new int[10000];
    static int front=0;
    static int back=-1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            switch (method) {
                case "push" : {
                    int X = Integer.parseInt(st.nextToken());
                    push(X);
                    break;
                }
                case "pop" : {
                    pop();
                    break;
                }
                case "size" : {
                    size();
                    break;
                }
                case "empty" : {
                    empty();
                    break;
                }
                case "front" : {
                    front();
                    break;
                }
                case "back" : {
                    back();
                    break;
                }
            }
        }
    }

    public static void push(int X) {
        queue[++back] = X;
    }
    public static void pop() {
        if (back < front) {
            System.out.println(-1);
        } else {
            System.out.println(queue[front++]);
        }
    }
    public static void size() {
        if (back < front) {
            System.out.println(0);
        } else {
            System.out.println(back-front+1);
        }
    }
    public static void empty() {
        if (back < front) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    public static void front() {
        if (back < front) {
            System.out.println(-1);
        } else {
            System.out.println(queue[front]);
        }
    }
    public static void back() {
        if (back < front) {
            System.out.println(-1);
        } else {
            System.out.println(queue[back]);
        }
    }
}
