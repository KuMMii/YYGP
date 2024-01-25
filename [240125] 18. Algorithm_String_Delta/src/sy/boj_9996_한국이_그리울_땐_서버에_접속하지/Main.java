package sy.boj_9996_한국이_그리울_땐_서버에_접속하지;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 파일의 개수
        int N = sc.nextInt();

        // 주어진 패턴
        String str = sc.next();
        // PatternSyntaxException: Dangling meta character '*' near index 0
        String[] pattern = str.split("\\*");
//        System.out.println(Arrays.toString(pattern));


        out: for(int i = 0; i < N; i++) {
            String word = sc.next();
            // 이 조건이 없으면 pattern보다 짧은 길이인데 패턴의 앞뒤 부분이 같으면 반례가 생김
            // ex. str = a*a, word = a -> 이 경우에도 "DA"가 출력됨!!
            if(word.length() < str.length()-1) {
                System.out.println("NE");
                continue out;
            } else if(!word.substring(0, pattern[0].length()).equals(pattern[0])) {
                System.out.println("NE");
                continue out;
            } else if(!word.substring(word.length()-pattern[1].length()).equals(pattern[1])) {
                System.out.println("NE");
                continue out;
            } else
                System.out.println("DA");
        }

    }
}
