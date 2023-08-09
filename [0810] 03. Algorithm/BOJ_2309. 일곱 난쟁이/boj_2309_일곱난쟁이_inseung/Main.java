package boj_2309_일곱난쟁이_inseung;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dwarf = new int[9]; // 아홉 난쟁이
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
			sum += dwarf[i]; // 아홉 난쟁이 키 합
		}

		// 버블 정렬 (오름차순)
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				if (dwarf[j] > dwarf[j + 1]) {
					int tmp = dwarf[j];
					dwarf[j] = dwarf[j + 1];
					dwarf[j + 1] = tmp;
				}
			}
		}

		int fake_a = -1;
		int fake_b = -1;
		// 2중 for문 - 난쟁이 2명 선택할수 있는 모든 경우의 수
		Loop1: for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				// fake 난쟁이 키 합 = 아홉 난쟁이 키 합 - 100
				if (dwarf[i] + dwarf[j] == sum - 100) {
					fake_a = i;
					fake_b = j;
					break Loop1; // 두명 찾으면 반복문 break
				}
			}
		}

		// fake 난쟁이 2명 빼고 오름차순 정렬
		for (int i = 0; i < 9; i++) {
			if (i != fake_a && i != fake_b) {
				System.out.println(dwarf[i]);
			}
		}
	}
}
