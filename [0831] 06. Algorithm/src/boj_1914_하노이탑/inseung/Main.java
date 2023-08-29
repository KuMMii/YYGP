package boj_1914_하노이탑.inseung;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int N = sc.nextInt();
		
		// N이 21 이상일 때도 재귀함수 다 돌게 했더니 메모리 초과 -> 검색해봄 -> K = 2의 N제곱 - 1 이라는 공식이 있었음
		// 계속 틀렸습니다 뜸 -> int타입 최대값: 2의 31제곱 -1 / Long타입 최대값: 2의 63제곱 -1
		// 문자열 형태로 이루어져있어 숫자의 범위가 무한 -> 어떤 숫자든 담을수 있음
		BigInteger bigK = new BigInteger("2").pow(N).subtract(BigInteger.ONE);
		
		if (N <= 20) {
			move(N, 1, 3);
			System.out.println(K);
			System.out.println(sb);
		} else {
			System.out.println(bigK);
		}
		sc.close();
	}
	
	static int K = 0; 
	static StringBuilder sb; 
	
	// n: 최종 옮기는 원판 개수, a: 1원판 출발, b: 1원판 도착
	// n개의 원판을, a -> b로 옮기는 메서드
	static void move(int n, int a, int b) {
		
		// n = 1 이면, 원판을 a->b로 옮김
		if (n == 1) {
			sb.append(a + " " + b).append("\n");
			K++;
		// move(3, 1, 3)이면
		} else {
			move(n - 1, a, 6 - a - b); // n-1개의 원판을 1 -> 2로 옮긴다 (a,b 말고 나머지 하나)
			sb.append(a + " " + b).append("\n"); K++;// n번 원판을 1 -> 3으로 옮긴다
			move(n - 1, 6 - a - b, b); // n-1개의 원판을 2 -> 3으로 옮긴다
		}
	}
}


/* move(3, 1, 3) 예시
 * 1. move(2, 1, 2)
 * 		move(1, 1, 3) : 1번판을 1->3 옮김
 * 		append (1, 2) : 2번판을 1->2 옮김
 * 		move(1, 3, 2) : 1번판을 3->2 옮김 (1번째칸 - 3번판 / 2번째칸 - 1,2번판)
 * 2. append (1, 3)	  : 3번판을 1->3 옮김
 * 3. move(2, 2, 3)
 * 		move(1, 2, 1) : 1번판을 2->1 옮김
 * 		append (2, 3) : 2번판을 2->3 옮김
 * 		move(1, 1, 3) : 1번판을 1->3 옮김
 * 
 * 
 * 
 */
	

//	static void move2(int n, int a, int b) {
//		
//		// n = 1 이면, 원판을 a->b로 옮김
//		if (n == 1) {
//			K++;
//		// move(3, 1, 3)이면
//		} else {
//			move(n - 1, a, 6 - a - b); // n-1개의 원판을 1 -> 2로 옮긴다 (a,b 말고 나머지 하나)
//			K++;// n번 원판을 1 -> 3으로 옮긴다
//			move(n - 1, 6 - a - b, b); // n-1개의 원판을 2 -> 3으로 옮긴다
//		}
//	}
//}




