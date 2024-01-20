package J.애너그램만들기_1919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder first = new StringBuilder(br.readLine());
        StringBuilder second = new StringBuilder(br.readLine());
        char[] chars = first.toString().toCharArray();

        for (int i = chars.length; i >= 0; i--) {
            String s = String.valueOf(chars[i]);
            if (second.indexOf(s) > -1) {
                first.delete(i, i + 1);
                second.delete(second.indexOf(s), second.indexOf(s) + 1);
            }
        }

        System.out.println(first.length() + second.length());
    }
}
