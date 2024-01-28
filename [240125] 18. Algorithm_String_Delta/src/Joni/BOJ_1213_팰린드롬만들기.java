//package BOJ_1213_팰린드롬만들기;
//
//import java.lang.reflect.Array;
//import java.util.*;
//
//public class Main2 {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        // word : 단어 입력받기, wordArray = 입력받은 단어의 char 배열
//        String word = sc.next();
//        char[] wordArray = word.toCharArray();
//        // tmp : 알파벳 문자열
//        String tmp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        // alpha = 알파벳 문자열을 담은 것이고 wordCount = 입력받은 단어가 해당 알파벳이 몇개인지 카운트하는 배열
//        char[] alpha = tmp.toCharArray();
//        int[] wordCount = new int[26];
//        // 알파벳 몇 개인지 카운트
//        // 1. 입력받은 알파벳의 동일한 갯수를 센다.
//        for (int i = 0; i < word.length(); i++) {
//            for (int j = 0; j < 26; j++) {
//                if (wordArray[i] == alpha[j]) {
//                    wordCount[j]++;
//                }
//            }
//        }
//
//        // 2. 만약, 홀수의 갯수가 2개 이상이라면 false (= 짝이 안맞는 경우)
//        boolean isFlag = true;
//        // 홀수 갯수를 세는 숫자
//        int oddNumber = 0;
//        String odd = "";
//        int oddIdx = -1;
//        for (int i = 0; i < 26; i++) {
//            if (wordCount[i] %2 == 1) {
//                oddNumber++;
//                odd = String.valueOf(alpha[i]);
//                oddIdx = i;
//                if (oddNumber > 1) {
//                    isFlag = false;
//                }
//            }
//        }
//        // 3. 짝이 맞을 경우에는 절반 갯수만 알파벳 순서로 정렬해주고 뒤로 복사해준다.
//        // (만약, 복사할 때 전체 길이가 홀수라면 배열과 복사배열 사이에 (기존 배열의 마지막) 홀수의 알파벳을 입력하도록한다.
//
//        ArrayList<String> list = new ArrayList<>();
//
//        // 홀수번째 빼주기
//        if (oddIdx != -1) {
//        wordCount[oddIdx]--;
//        }
//        for (int i = 0; i < 26; i++) {
//            if (wordCount[i] %2 == 0) {
//                wordCount[i] /= 2;
//            }
//        }
//        int idx = 0;
//        // wordCount에 남아있는 숫자를 전부 0으로 만들면서 list에 알파벳 추가해주기
//        String left ="";
//        for (int i = 0; i < 26; i++) {
//            while(wordCount[i] > 0) {
//                left +=  alpha[i];
//                wordCount[i]--;
//            }
//        }
//
//        // 절반 나눈거 뒤에 추가해줄 문자열
//        StringBuffer sb = new StringBuffer(left);
//        String reverse = sb.reverse().toString();
//
//        // odxIdx가 -1이 아니라면 (갯수가 홀수)
//        if (oddIdx != -1) {
//            left += odd;
//            left += reverse;
//        } else {
//            left += reverse;
//        }
//
//        // 결과 출력
//        if (isFlag) {
//            System.out.println(left);
//        } else {
//            System.out.println("I'm Sorry Hansoo");
//        }
//    } // main
//
//}
