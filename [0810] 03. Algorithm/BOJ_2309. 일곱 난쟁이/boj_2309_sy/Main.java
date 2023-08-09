package boj_2309_sy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		// 9명의 키를 배열에 추가
		int[] dwarfs = new int[9];
		// 9명의 키를 모두 더함
		for(int i = 0; i < 9; i++) {
			dwarfs[i] = sc.nextInt();
			sum += dwarfs[i];
		}
		Arrays.sort(dwarfs);
//		System.out.println(Arrays.toString(dwarfs));
		
		// 9명의 키에서 일곱 난쟁이의 키의 합인 100을 빼서 일곱난쟁이가 아닌 2명의 키의 합을 구함
		int strangers = sum - 100;
		
		// 배열의 2개씩 합을 구해 strangers와 같은 요소를 구해서 0으로 초기화
		out: for(int i = 0; i < 9; i++) {
			for(int j = i+1; j < 9; j++) {
				if(dwarfs[i] + dwarfs[j] == strangers) {
					dwarfs[i] = 0;
					dwarfs[j] = 0;
					// 해당 값이 나왔을 경우 예시에 없는 다른 testCase에서는 strangers가 동일한 값이 또 있을 수 있으므로
					// for문 밖으로 완전히 나갈 것!!
					break out;
				}
			}
		}
		
//		// 버블 정렬로 오름차순 정렬
//		int temp;
//		for(int j = 0; j < 8; j++) {
//			for(int i = 1; i < 9-j; i++) {
//				if(dwarfs[i-1] > dwarfs[i]) {
//					temp = dwarfs[i-1];
//					dwarfs[i-1] = dwarfs[i];
//					dwarfs[i] = temp;
//				}
//			}
//		}
		
		// 0으로 초기화 시킨 두명을 제외하고 idx 2번부터 출력
		for(int i = 0; i < 9; i++) {
			if(dwarfs[i] != 0) {
				System.out.println(dwarfs[i]);
			}
		}
		
	}
}
