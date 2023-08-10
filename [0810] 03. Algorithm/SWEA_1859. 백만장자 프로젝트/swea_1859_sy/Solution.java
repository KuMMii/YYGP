package swea_1859_sy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int testCase = 1;
		for(testCase = 1; testCase <= T; testCase++) {
			
			int N = sc.nextInt();
			
			int[] price = new int[N];
			
			for(int i = 0; i < N; i++) {
				price[i] = sc.nextInt();
			}
			
			// price 배열을 N-2 ~ 0까지 뒤에서부터 순회하기 위한 k 초기화
			int k = 1;
			// 팔았을 때의 이익 0으로 초기화
			long profit = 0;
			// 최대값을 배열의 마지막 요소로 초기화
			int max = price[N-1];
			for(k = 1; k <= N-1; k++) {
				// N-1-k 값이 최대값보다 크면 그 값으로 최대값을 초기화
				if(price[N-1-k] >= max) {
					max = price[N-1-k];
				// 작으면 팔았을 때 이익을 남길 수 있으므로 최대값에서 해당 인덱스의 가격을 빼서 이익에 더함
				} else {
					profit += max - price[N-1-k];
				}
			}
			
			// 주의할 점!!
			// 8번~10번의 testCase가 100만개라 profit을 모두 더하면 int의 최대 크기인 2,147,483,647을 넘는다
			// long이 정수를 저장하는데 int보다 더 넓은 범위이기 때문에 int가 보유하라 수 없는 더 큰 정수를 보유하기 위해 long 타입 사용!!
			System.out.printf("#%d %d\n", testCase, profit);
		}
	}
}
