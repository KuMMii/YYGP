package silver.boj_10845_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //명령의 개수(push, pop, size, empty, front, back)
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int index = 0;
        int num = 0;

        for(int i = 0; i < N; i++) {
            // 명령
            st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            // push
            if(method.equals("push")) {
                int M = Integer.parseInt(st.nextToken());
                arr[index++] = M;
            // pop
            } else if(method.equals("pop")) {
                if(num < index) {
                    sb.append(arr[num]).append("\n");
                    arr[num++] = 0;
                } else
                    sb.append(-1).append("\n");
            // size
            } else if(method.equals("size")){
                if(num < index) {
                    sb.append(index - num).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            // empty
            } else if(method.equals("empty")) {
                if(num == index)
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            // front
            } else if(method.equals("front")) {
                if(num != index) {
                sb.append(arr[num]).append("\n");
                } else
                    sb.append(-1).append("\n");
            // back
            } else {
                if(num != index) {
                    sb.append(arr[index-1]).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }// for
        System.out.println(sb);

    }
}
