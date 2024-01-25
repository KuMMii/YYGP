package J.명령프롬프트_1032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int N;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[] ans = br.readLine().toCharArray();

        if (N > 1) {
            for (int i = 1; i < N; i++) {
                char[] compare = br.readLine().toCharArray();
                for (int j = 0; j < ans.length; j++) {
                    if (ans[j] != compare[j]) ans[j] = '?';
                }
            }


        }

        System.out.println(ans);

    }
}
