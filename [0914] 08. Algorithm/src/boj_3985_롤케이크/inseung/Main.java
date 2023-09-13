package boj_3985_롤케이크.inseung;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
// 시간 1초가 여유로운 시간이구나
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); // 롤 케이크 길이
		int N = sc.nextInt(); // 방청객 수
		
		Set<Integer> set = new HashSet<>(); // 숫자 넣을 set
		// set의 전,후 크기
		int beforeSize = 0;
		int afterSize = 0;
		// 가장 많은 조각 수, 받을 것으로 기대되는 방청객 번호
		int exMax = 0;
		int exMaxIdx = 0;
		// 실제로 가장 많은 조각 수, 받을 것으로 기대되는 방청객 번호
		int max = 0;
		int maxIdx = 0;
		
		// 방청객 수 만큼 반복
		for (int i = 1; i<=N; i++) {
			int num = 0; // i번쨰 방청객의 기대되는 조각 수 셈
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = x ; j<=y; j++) {
				set.add(j);
				num++;
			}
			// 기대되는 조각 수 최대값, 그 방청객 번호 구함
			if (num > exMax) {
				exMax = num;
				exMaxIdx = i;
			}
			// 실제 받는 조각 수 최대값, 그 방청객 번호 구함
			// set에 실제로 들어간 숫자 개수 = 실제 받는 조각 수
			afterSize = set.size();
			if (afterSize - beforeSize > max) {
				max = afterSize - beforeSize;
				maxIdx = i;
			}
			beforeSize = afterSize; // 그다음 방청객의 전 size = 지금 방청객의 후 size
			
		}
		
		System.out.println(exMaxIdx);
		System.out.println(maxIdx);
		
	}

}
