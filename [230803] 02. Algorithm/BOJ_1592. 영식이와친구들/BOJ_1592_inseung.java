package 백준;

import java.util.Scanner;

public class BOJ_1592_inseung {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사람 인원
		int M = sc.nextInt(); // 공 받은 횟수 (종료 기준)
		int L = sc.nextInt(); // 시계 + L
		int[] a = new int[N+1]; // 인덱스 = i번째 사람, 배열값 = 공 받은 횟수
		// 1번 자리 공 받음
		a[1] = 1;
		int i = 1;
		int num = 0; // 공 던진 횟수 = 출력값
		
		// i번째 사람이 M번 받을때까지 반복
		while(a[i] != M) {
			if (a[i] % 2 == 1) {
				i += L;
				if (i > N) { // i가 N보다 크지않게
					i -= N;
				}
				a[i] += 1;
				num++;
			} else {
				i -= L;
				if (i < 1) { // i가 1보다 작지않게
					i += N;
				}
				a[i] += 1;
				num++;
			}
		}
		System.out.println(num);
	}
}
