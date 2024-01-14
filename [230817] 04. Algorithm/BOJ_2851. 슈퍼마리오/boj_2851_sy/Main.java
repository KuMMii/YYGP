
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		// 버섯의 점수 10개를 입력받기 위한 1차원 배열 mushroom 생성
		int[] mushroom = new int[10]; 
		for(int i = 0; i < 10; i++) {
			mushroom[i] = sc.nextInt();
		}
		
		// 먹은 버섯의 점수를 누적합으로 구하기 위해 score변수 설정 및 0으로 초기화
		int score = 0;
		// 100을 넘었을 때 score를 저장하기 위한 변수 up 설정 및 0으로 초기화
		int up = 0;
		// 한 개들 덜 먹었을 때의 score를 저장하기 위한 변수 down 설정 및 0으로 초기화
		int down = 0;
		for(int i = 0; i < 10; i++) {
			score += mushroom[i];
			// score가 100보다 커지면
			if(score > 100) {
				// 해당 점수를 up에 저장
				up = score;
				// 지금 먹은 버섯 점수를 빼서 down에 저장
				down = score - mushroom[i];
				break; // 반복문 종료
			} else { // 10개를 다 먹어도 100을 넘지 않을 경우 up에 score를 저장 <- 반례
				up = score;
			}
		}
		
		// 점수에서 100을 빼거나 100에서 점수를 뺀 값이 더 작은 것을 출력
		// 점수에서 100을 빼거나 100에서 점수를 뺀 값이 동일하면 up을 출력
		if( (up-100) <= (100-down) ) {
			System.out.println(up);
		} else
			System.out.println(down);
	}
}
