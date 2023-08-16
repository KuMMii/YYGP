import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 좌석 수
		int N = sc.nextInt();
		
		// 좌석 수만큼 1차원 배열 seat 생성
		char[] seat = new char[N];
		String str = sc.next();

		for(int i = 0; i < N; i++) {
			seat[i] = str.charAt(i);
		}
		
		// 컵홀더 변수 설정 및 1로 초기화 ( 첫번째 의자에는 양쪽에 홀더가 있음을 고려 )
		int holder = 1;
		// 커플석 L의 개수를 세기 위한 변수 설정 및 0으로 초기화
		int couple = 0;
		for(int i = 0; i < N; i++) {
			//해당 위치가 일반좌석S이면 holder 증가
			if(seat[i] == 'S') {
				holder++;
			//해당 위치가 커플석L이면 couple 증가
			} else if (seat[i] == 'L') {
				couple++;
				//couple석이 2개가 되었을 때 holder 증가
				if(couple%2 == 0) {
					holder++;
				}
			} //if문
		} //i for문
		
		// 홀더가 사람 수 보다 많으면 사람수(좌석수N)를 출력
		if(holder <= N) {
			System.out.println(holder);			
		} else {
			System.out.println(N);
		}
		
	}//main
}