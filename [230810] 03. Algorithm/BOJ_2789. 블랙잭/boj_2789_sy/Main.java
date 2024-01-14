package boj_2789_sy;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] cards = new int[N];
		for(int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}
		
		// 3장의 카드의 숫자 합을 구하기 위한 sum을 0으로 초기화
		int sum = 0;
		// 최대값을 구하기 위해 max를 0으로 초기화
		int max = 0;
		for(int i = 0; i < N-2; i++) {
			for(int j = i+1; j < N-1; j++) {
				for(int k = j+1; k < N; k++) {
					// 배열을 순차적으로 순회하면서 3개의 카드의 합을 구한다.
					sum = cards[i] + cards[j] + cards[k];
					// 합이 M보다 작거나 같으면서 max 보다 클 경우 max 교체
					if(sum <= M && sum > max) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
	}
}
