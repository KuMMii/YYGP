package boj_1244_스위치켜고끄기.inseung;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 스위치 개수
		swt = new int[n + 1];

		// swt[] : 스위치 켬/끔 상태를 배열에 저장 (swt[0]은 안쓸거임)
		for (int i = 1; i < n + 1; i++) {
			swt[i] = sc.nextInt();
		}

		int N = sc.nextInt(); // 사람 수

		// 사람 수만큼 반복해서 스위치 상태 바꾼다
		for (int i = 1; i <= N; i++) {

			// 1. 남학생인 경우
			if (sc.nextInt() == 1) {
				int num = sc.nextInt(); // 스위치 번호
				// num의 배수인 스위치가 num보다 작거나 같을떄까지 반복
				for (int j = 1; num * j < n + 1; j++) {
					onOff(num * j); // num의 배수들인 스위치 켬/끔
				}

			// 2. 여학생인 경우
			} else {
				int num = sc.nextInt(); // 스위치 번호
				onOff(num); // 일단 num 스위치 켬/끔
				// 좌우 대칭 번호로 한칸 건너가서, num+-j가 둘다 swt[] 인덱스값 넘지 않는 동안 반복
				for (int j = 1; num + j < n + 1 && num - j > 0; j++) {
					// 좌우 대칭 스위치가 켬/끔 상태 다르면 for문 탈출
					if (swt[num + j] != swt[num - j]) {
						break;
					// 좌우 대칭 스위치가 켬/끔 상태 같으면 - 둘다 스위치 켬/끔
					} else {
						onOff(num + j);
						onOff(num - j);
					}
				} // 여학생 - 탈출하는 for문 끝
			}

		} // 스위치 상태 바꾸는 for문 끝

		// 스위치 1번 ~ n번까지 순서대로 print
		for (int i = 1; i < n + 1; i++) {
            if (i % 20 == 0) {
            	System.out.println(swt[i]);
            } else {
            	System.out.print(swt[i] + " ");
            }
		}
		
		sc.close(); // Scanner 종료
	} // main 메서드 끝

	
	// 스위치 켬끔 상태 넣을 배열(1: 켜져있음, 0: 꺼져있음)
	static int[] swt;

	// 스위치 켬/끔 메서드
	static void onOff(int i) {
		if (swt[i] == 0) {
			swt[i] = 1;
		} else {
			swt[i] = 0;
		}
	}
}
