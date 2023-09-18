package boj_11399.sy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//사람의 수 N
		int N = sc.nextInt();
		
		//돈을 인출하는데 걸리는 시간 Pi를 저장하기 위한 배열 생성
		int[] p = new int[N];
		for(int i = 0; i < N; i++) {
			p[i] = sc.nextInt();
		}
		
		//마지막 사람은 누가 되던 p1 ~ pN까지의 합
		//총 시간의 합이 작아지기 위해서는 앞에 사람이 적게 기다려야함 -> 오름차순 정렬
		Arrays.sort(p);
		
		//1번째 사람의 인출 시간만큼 기다리는 사람은 n명
		//2번째 사람의 인출 시간만큼 기다리는 사람은 n-1명
		//... 
		int sum = 0;
		int n = N;
		for(int i = 0; i < N; i++) {
			sum += p[i] * n--; 
		}
		
		System.out.println(sum);
		
	}//main
}//class
