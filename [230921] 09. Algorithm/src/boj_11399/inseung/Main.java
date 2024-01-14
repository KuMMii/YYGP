package boj_11399.inseung;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] people = new int[N]; // people[i] = i 사람이 필요한 시간 
		for (int i = 0; i<N; i++) {
			people[i] = sc.nextInt();
		}
		// 오름차순 정렬
		Arrays.sort(people);
		
		// 제일 작은 수 * N + 그다음 작은 수 * (N-1) ,,, + 젤 큰 수 * 1 
		int num = N; // N부터 시작해서 1씩 빼줄거임
		int sum = 0; // 답
		for (int i = 0; i<N; i++) {
			sum += people[i] * num;
			num--;
		}
		System.out.println(sum);
	}

}
