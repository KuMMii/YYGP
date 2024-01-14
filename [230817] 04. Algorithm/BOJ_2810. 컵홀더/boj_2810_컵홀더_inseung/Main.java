package boj_2810_컵홀더_inseung;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String seats = sc.next();
		
		// 자리 중에 LL 개수 셈
		double sum = 0; 
		for (int i = 0; i<seats.length(); i++) {
			if (seats.charAt(i) == 'L') {
				sum += 1/2.0; // sum을 int로 잡고 && 1/2(=0)을 더하려니 -> 계속 sum이 0이 됐음,, 
			}
		}
		
		int answer = 0;
		
		// LL = 0 : 답 = N
		// LL = n : 답 = N - (n-1)
		if (sum == 0) {
			answer = N;
		}
		else answer = N - (int)(sum - 1); // sum이 double이라서 int로 형변환 해줘야함.
		
		System.out.println(answer);
		sc.close();
	}
}
