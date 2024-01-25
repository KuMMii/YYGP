package sy.boj_1919_애너그램_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        Arrays.sort(str1);
        char[] str2 = br.readLine().toCharArray();
        Arrays.sort(str2);

        out: for(int i = 0; i < str1.length; i++) {
            for(int j = 0; j < str2.length; j++) {
                if(str1[i] == str2[j]) {
                    str1[i] = ' ';
                    str2[j] = ' ';
                    continue out;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < str1.length; i++) {
            if(str1[i] != ' ') {
                cnt++;
            }
        }

        for(int i = 0; i < str2.length; i++) {
            if(str2[i] != ' ') {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
