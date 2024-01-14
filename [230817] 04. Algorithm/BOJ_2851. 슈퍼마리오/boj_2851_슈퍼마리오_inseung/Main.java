package boj_2851_슈퍼마리오_inseung;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mushroom = new int[10];
		for (int i = 0; i<10; i++) {
			mushroom[i] = sc.nextInt();
		}

		int sum = 0;
		int answer = 0;
		for (int i = 0; i<10; i++) {
			sum += mushroom[i];
			answer = sum; // 이거 안써서 계속 틀림 (검색해봄) -- 평생 sum이 100 안넘으면 answer값이 0이 됨 ㅠㅠ
			if (sum > 100) { // sum이 처음으로 100보다 커질때
				// sum값이랑 직전 sum값 중에, 100이랑 차이가 작은 값을, answer에 대입 (차이 같으면 지금 sum값을 대임)
				answer = sum - 100 <= 100 - (sum - mushroom[i]) ? sum : sum - mushroom[i]; 
				break;
			}
		}
		System.out.println(answer);
		sc.close();
	}
}
