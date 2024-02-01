package silver.boj_10828_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        // 명령의 개수
        int N = Integer.parseInt(st.nextToken());

        // 스택을 구현하기 위한 빈 배열
        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            // 명령(push, pop, size, empty, top)
            st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            // push
            if(method.equals("push")) {
                int M = Integer.parseInt(st.nextToken());
                arr.add(M);
            // pop
            } else if(method.equals("pop")) {
                if(arr.size() != 0)
                    sb.append(arr.remove(arr.size()-1)).append("\n");
                else
                    sb.append(-1).append("\n");
            // size
            } else if(method.equals("size")) {
                sb.append(arr.size()).append("\n");
            // empty
            } else if(method.equals("empty")) {
                if(arr.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            // top
            } else {
                if(arr.size() != 0)
                    sb.append(arr.get(arr.size()-1)).append("\n");
                else
                    sb.append(-1).append("\n");
            }

        }
        System.out.println(sb);
    }
}
