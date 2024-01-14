package boj_2999_비밀이메일.sy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	//행의 개수 R, 열의 개수 C
	public static int R, C;
	public static char[][] message;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		//R과 C의 경우의 수를 담을 List 생성
		List<Integer> rc = new ArrayList<>();
		
		//입력받은 str 길이의 약수 List에 추가
		for(int i = 1; i <= str.length(); i++) {
			if(str.length()%i == 0) {
				rc.add(i);
			}
		}
			
		//약수의 개수가 짝수일 경우,
		if(rc.size()%2 == 0) {
			//약수들 중 가운데 숫자 두개 중 큰 수를 C, 작은 수를 R에 저장
			R = rc.get(rc.size()/2-1);
			C = rc.get(rc.size()/2);
		//약수의 개수가 홀수일 경우
		}else if(rc.size()%2 == 1) {
			//약수들 중 가운데 숫자를 R과 C에 동일하게 저장
			R = rc.get(rc.size()/2);
			C = rc.get(rc.size()/2);
		}
		
		//R, C크기의 char배열 message 생성
		message = new char[R][C];
				
		//세로로 입력받은 str을 char로 쪼개서 입력
		for(int c = 0,idx = 0; c < C; c++) {
			for(int r = 0; r < R; r++) {
				message[r][c] = str.charAt(idx++);
			}	
		}
		
		//가로로 탐색하여 출력
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				System.out.print(message[r][c]);
			}
		}

	}//main
}//class
