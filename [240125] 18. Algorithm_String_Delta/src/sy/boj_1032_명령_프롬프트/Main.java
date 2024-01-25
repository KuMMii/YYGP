package sy.boj_1032_명령_프롬프트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        // 파일 이름의 개수
        int N = Integer.parseInt(br.readLine());

        String[] files = new String[N];
        for(int i = 0; i < N; i++) {
            files[i] = br.readLine();
        }
//        for(int i = 0; i< N ;i++) {
//            System.out.println(files[i]);
//        }

        int len = files[0].length();

        String[] answer = new String[len];

        out: for(int l = 0; l < len; l++) {
            for(int i = 1; i < N; i++) {
                if(!files[i-1].substring(l, l+1).equals(files[i].substring(l, l+1))) {
                    answer[l] = "?";
                    continue out;
                } else
                    continue;
            }
            answer[l] = files[0].substring(l, l+1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            sb.append(answer[i]);
        }
        System.out.println(sb);
    }
}
