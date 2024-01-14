package boj_18870_좌표압축;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 오름차순 정렬 -> map에 (sorted[], value) 넣음 -- 이미 넣은 key와 중복되는 값은 안넣어서 value값이 중복값 포함안하도록 
		// -> StringBuilder에 문자열 만들어서 프린트 (걍 반복문 돌리면 시간초과)
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] axis = new int[N]; // 처음 입력받은 값들
		int[] sorted = new int[N];
//		int[] count = new int[N]; // sorted[]값보다 작은 값들의 수
		for (int i = 0; i < N; i++) {
			axis[i] = sc.nextInt();
			sorted[i] = axis[i];
		}
		
		Arrays.sort(sorted); // axis[]를 오름차순 정렬
		
		// *** count[] 값 넣는건 map에 넣어줄때 한번에 함 (중복 값들은 map에 안넣는 식으로)
		
//		// count[] 에 -> sorted[] 값보다 작은 값들의 개수 넣음  
//		for (int i = 1; i < N; i++) {
//			if (sorted[i] != sorted[i-1]) {
//				count[i] = count[i-1] + 1;
//			} else {
//				count[i] = count[i-1];
//			}
//		}

		Map<Integer, Integer> map = new HashMap<>();
		// map에 (sorted[], 작은값 개수) 값 넣음
		int sum = 0;
		for (int a : sorted) {
			if (!map.containsKey(a)) { // 중복값은 map에 안넣어서 sum값 안올라가게
				map.put(a, sum);
				sum++;
			}
		}
		
		// axis[i]의 값을, map의 key값 중에 찾아서, value값을 순서대로 뽑음
		// 시간초과 떠서 - StringBuilder 이용 (검색함)
		StringBuilder sb = new StringBuilder();
		for (int a : axis) {
			sb.append(map.get(a)).append(" ");
		}
		System.out.println(sb);
		sc.close();
	}
}

