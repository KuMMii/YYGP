package boj_2941_크로아티아알파벳.inseung;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int answer = str.length(); // 일단 문자열 길이를 답으로 받음

		// 크로아티아 알파벳 배열
		String[] alphabet = { "dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z=" };

		for (int i = 0; i < 8; i++) {
			while (str.contains(alphabet[i])) { // 크로아티아 알파벳이 있는 동안 반복
				answer--; // 2글자가 한글자인거니까, answer - 1 해준다
				if (i == 0) answer--; // "dz="만 3글자가 한글자인거니까, answer - 1 한번더 해준다
				
				// -1 했으니까 알파벳 부분만 도려낸다 (같은 알파벳 2개 이상일수도 있으니까)
				str = str.replaceFirst(alphabet[i], "0"); // replaceFirst() : 첫번째 문자열만 대체해줌
			}
		}			
			
		System.out.println(answer);
	}
}

// "" 빈문자열로 대체하니까 "ddz=z=" -> "dz=" -> "" 가 되버리네.

// 이렇게 쓰면 크로아티아 알파벳 여러개 있어도 다 한번에 대체시켜버리는구나
// str = str.replace(alphabet[i], ""); // 아 'str ='을 안써줘서 무한반복한거구나. 걍 자르기만 하고 대입을 안해줫네,,