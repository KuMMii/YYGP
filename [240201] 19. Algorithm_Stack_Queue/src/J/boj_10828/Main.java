package J.boj_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] stack = new int[10000];
    static int size=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            switch (method) {
                case "push" -> {
                    int X = Integer.parseInt(st.nextToken());
                    push(X);
                    break;
                }
                case "pop" -> {
                    pop();
                    break;
                }
                case "size" -> {
                    size();
                    break;
                }
                case "empty" -> {
                    empty();
                    break;
                }
                case "top" -> {
                    top();
                    break;
                }
            }
        }
    }

    public static void push(int X) {
        stack[size++]=X;
    }

    public static void pop() {
        if (size <= 0) {
            System.out.println(-1);
        } else {
            System.out.println(stack[size-1]);
            stack[size--]=0;
        }
    }

    public static void size() {
        if(size<=0) System.out.println(0);
        else System.out.println(size);
    }

    public static void empty() {
        if(size<=0) System.out.println(1);
        else System.out.println(0);
    }

    public static void top() {
        if (size <= 0) {
            System.out.println(-1);
        } else {
            System.out.println(stack[size-1]);
        }
    }

}
