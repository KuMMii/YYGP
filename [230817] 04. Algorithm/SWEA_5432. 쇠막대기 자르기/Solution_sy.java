package SWEA_5432_쇠막대기_자르기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static int barCnt;
	public static int cut;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_5432_쇠막대기_자르기/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			//막대기의 개수를 카운트할 수 있는 barCnt 변수 설정 및 0으로 초기화
			barCnt = 0;
			//잘린 막대기의 개수를 카운트할 수 있는 cut 변수 설정 및 0으로 초기화
			cut = 0;
			
			//주어진 괄호 문자열 스캔
			String str = sc.next();
			//문자열 길이의 char배열 생성
			char[] bracket = new char[str.length()];
			//배열을 순회하며 String을 char로 쪼개기
			for(int i = 0; i < str.length(); i++) {
				bracket[i] = str.charAt(i);
			}
			
			for(int i = 0; i < str.length(); i++) {
				// "()"가 연속으로 발견되면 레이저 포인트가 나오기 전 막대기의 개수(barCnt)만큼 잘린 막대기의 개수(cut) 증가
				if(i+1 < str.length() && bracket[i] == '(' && bracket[i+1] == ')') {
					cut += barCnt;
				// "("가 있지만 ")"가 연속해서 발견되지 않으면 새로운 막대기가 등장 -> barCnt 증가
				} else if(i+1 < str.length() && bracket[i] == '(' && bracket[i+1] != ')') {
					barCnt++;
				// 앞에 "("가 아니지만 ")"가 나오면 막대기의 끝부분 -> 잘린 막대기 개수(cut) 증가, 앞으로 레이저에 잘릴 수 있는 막대기 개수(barCnt) 감소
				} else if(i-1 >=0 && bracket[i-1] != '(' && bracket[i] == ')') {
					barCnt--;
					cut++;
				}
			}//i
			
			System.out.printf("#%d %d\n", testCase, cut);
			
		}//testCase
	}//main
}//class Solution
