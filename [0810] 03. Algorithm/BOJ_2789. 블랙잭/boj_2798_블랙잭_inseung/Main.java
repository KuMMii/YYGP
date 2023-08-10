package boj_2798_블랙잭_inseung;

import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] cards = new int[N]; //카드 숫자 배열
		for(int i = 0; i<N; i++) {
			cards[i] = sc.nextInt();
		}
//		Arrays.sort(cards);
		
		
//		System.out.println(Arrays.toString(cards));
		
		int sum = 0;
		for (int i = 0; i<N; i++) {
			for (int j = i + 1; j<N; j++) {
				for (int k = j + 1; k<N; k++) {
					int tmp = cards[i] + cards[j] + cards[k];
					if (tmp <= M && sum < tmp) {
						sum = tmp;						
					}
				}
			}
		}
		System.out.println(sum);
	}
}