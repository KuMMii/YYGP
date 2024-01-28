//package BOJ_1919_애너그램만들기;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        char[] wordOne = sc.next().toCharArray();
//        char[] wordTwo = sc.next().toCharArray();
//
//        String tmp = "abcdefghijklmnopqrstuvwxyz";
//        // alpha = 알파벳 문자열을 담은 것이고 wordCount = 입력받은 단어가 해당 알파벳이 몇개인지 카운트하는 배열
//        char[] alpha = tmp.toCharArray();
//        int[] wordCountOne = new int[26];
//        int[] wordCountTwo = new int[26];
//
//        // 첫번째
//        for (int i = 0; i < wordOne.length; i++) {
//            for (int j = 0; j < 26; j++) {
//                if (wordOne[i] == alpha[j]) {
//                    wordCountOne[j]++;
//                }
//            }
//        }
//
//        // 두번째
//        for (int i = 0; i < wordTwo.length; i++) {
//            for (int j = 0; j < 26; j++) {
//                if (wordTwo[i] == alpha[j]) {
//                    wordCountTwo[j]++;
//                }
//            }
//        }
//        int answer = 0;
//        for (int i = 0; i < 26; i++) {
//            wordCountOne[i] -= wordCountTwo[i];
//            answer += Math.abs(wordCountOne[i]);
//        }
//        System.out.println(answer);
//    }
//}