package BOJ_1032_명령프롬프트;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력 갯수 : N
        int N = sc.nextInt();
        // 단어를 담을 배열
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
        } // 입력 끝

        // 정답 배열
        List<String> answer = new ArrayList<>();
        // count: 각 문자의 i번째 글자가 똑같은지 갯수 카운트
        int count = 0;
        // 배열 3개면 3개의 i번째가 동일한지 검사
        for (int i = 0; i < words[0].length(); i++) {
            // origin = 기준점(첫번째 입력값)
            char origin = words[0].charAt(i);
            for (int j = 1; j < N; j++) {
                // 두번째 이후 입력값과 동일한지? 체크
                char c = words[j].charAt(i);
                // 만약 다른게 하나라도 있으면 답안 리스트에 ? 집어넣고 카운트 초기화 + 다음으로 초기화
                if (origin != c) {
                    answer.add("?");
                    count = 0;
                    break;
                    // 같으면 숫자 +1
                } else {
                    count++;
                }
                // 만약 검사했을 때 갯수가 동일하다면 카운트 초기화해주고 답안 리스트에 글자 추가
                if (count == N-1) {
                    answer.add(String.valueOf(origin));
                    count = 0;
                }
            }
        }

        // 출력 결과, 아래 else는 기준점만 입력값으로 받았을 때 비교할 값이 없는 경우 그대로 출력
        if (answer.size() > 0) {
            for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i));
            }

        } else {
            for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]);

            }
        }

    } // main
} // class
