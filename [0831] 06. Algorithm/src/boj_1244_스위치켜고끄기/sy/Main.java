package boj_1244_스위치켜고끄기.sy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] switches = new int[N+1];
		
		//1: on, 2: off
		for(int i = 1; i <= N; i++) {
			switches[i] = sc.nextInt();
		}
		
		int st = sc.nextInt();
		for(int i = 1; i <= st; i++) {
			//남학생: 1, 여학생: 2
			int gender = sc.nextInt();
			int num = sc.nextInt();
			//1. 남학생이면
			if(gender == 1) {
				for(int j = 1; j <= N; j++) {
					//j가 num으로 나눴을 때 0이면 num의 배수
					if(j % num == 0) {
						//스위치 변경
						switches[j] = (switches[j] + 1) % 2;
					}
				}
			}
			//2. 여학생이면
			else if(gender == 2) {
				//받은 번호의 스위치 변경
				switches[num] = (switches[num] + 1) % 2;
				//받은 번호 주변을 1개씩 확인
				for(int k = 1; num-k >= 1 && num+k <= N; k++) {
					//같으면 스위치 변경
					if(switches[num-k] == switches[num+k]) {
						switches[num-k] = (switches[num-k] + 1) % 2;
						switches[num+k] = (switches[num+k] + 1) % 2;
					//대칭이지 않거나, 양쪽 끝에 도달해 비교할 대칭 스위치가 없으면 멈춤
					}else
						break;
				}
				
			}			
		}
		
		//스위치 20개씩 끊어서 정답 출력
		for(int j = 1; j <= N; j++) {
			System.out.print(switches[j] + " ");
			if(j % 20 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
		
	}//main

}//class
