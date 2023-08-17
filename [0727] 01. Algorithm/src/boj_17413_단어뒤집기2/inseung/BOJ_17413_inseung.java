package boj_17413_단어뒤집기2.inseung;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class BOJ_17413 {
	public static void main(String[] args) {
		//StringTokenizer로 < 기준으로 나누고 -> >기준으로 자르고 
		// -> <>는 그대로 다시 나오고, 단어는 각각 글자 뒤집고
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
	
		StringTokenizer st = new StringTokenizer(S, "<");
	
		int cnt = st.countTokens();
//		System.out.println(cnt);
	
		String[] s1 = new String[cnt];
		String[] s2 = new String[cnt]; // <> <> 사이의 문자열
		String[] s2_re = new String[cnt];
	
		for(int i = 0; i<cnt; i++) {
			if (cnt > 1) {	
				s1[i] = "<" + st.nextToken(); 	// s1: < 기준으로 자른 문자열, <붙여줌
			} else {
				s1[i] = st.nextToken(); // <아예 없는 경우는 <안붙임
			}
			
			s2[i] = s1[i].substring((s1[i].indexOf(">"))+1);  // s2: >이후부터의 문자열 뽑음
			StringTokenizer st2 = new StringTokenizer(s2[i]);
			int cnt2 = st2.countTokens(); // countTokens -> 모든 갯수가 아니라, nextToken 호출 남은 횟수임. 그래서 따로 할당해줘야함. 이거 때매 계속 개수가 적게 나옴.
			String[] s2_space = new String[cnt2]; // <> <> 사이에서, 스페이스바 기준으로 split한 배열		
//			System.out.println(cnt2);
			for(int j = 0; j<cnt2; j++) {
				s2_space[j] = st2.nextToken();
			}
			
			s2_re[i] = ""; // 계속 맨앞에 null이 붙어서 빈문자열로 만들어줌
			for(int k = 0; k<cnt2; k++) {
				for(int j = s2_space[k].length() - 1; j>=0; j-- ) {    // s2_re: >이후부터의 문자열 reverse시킴
					s2_re[i] += s2_space[k].charAt(j);
				}
				if (k != cnt2 - 1) { // 마지막 덩어리 아니면 띄어쓰기 뒤에 합쳐줌 
					s2_re[i] += " ";
				}
			}
			
		}
//		System.out.println(Arrays.toString(s1));
//		System.out.println(Arrays.toString(s2));
//		System.out.println(Arrays.toString(s2_re));
		
		for(int i = 0; i<cnt; i++) {
			System.out.print(s1[i].substring(0, (s1[i].indexOf(">"))+1)); // <> 안에 있는거 프린트
			System.out.print(s2_re[i]); // <> <> 사이에 있는 것들 프린트
		}
	}
}


//		String s = "abc";
//		char c = 'a';
//		String ss = null;
//		System.out.println(s + c);
//		
//	}