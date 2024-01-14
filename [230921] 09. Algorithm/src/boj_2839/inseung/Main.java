package boj_2839.inseung;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N킬로그램
		int answer = 0;
		while (N % 5 != 0) { // 5로 나눈 나머지가 0이 아니면 계속 반복
			N -= 3;
			answer++;
			// 계속 3 빼주다가 남은게 4, 2, 1 이면 글러먹은것 -> answer = -1
			if (N == 4 || N == 2 || N == 1) {
				answer = -1;
				break;
			}
		}
		answer += N / 5; // 5로 나눈 몫 더해줌
		System.out.print(answer);
	}
}
