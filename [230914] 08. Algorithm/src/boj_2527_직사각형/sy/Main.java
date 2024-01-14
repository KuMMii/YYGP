package boj_2527_직사각형.sy;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1; i <= 4; i++) {
			//첫번째 직사각형
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			
			//두번째 직사각형
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();
			
			//d. 완전히 분리된 경우
			if(x2 > p1 || y2 > q1 || p2 < x1 || q2 < y1) {
				System.out.println("d");
			}
			//c. 겹치는 부분이 점인 경우
			else if((x1 == p2 && y1 == q2) || (x1 == p2 && q1 == y2)
					|| (p1 == x2 && q1 == y2) || (p1 == x2 && y1 == q2)) {
				System.out.println("c");
			}
			//b. 겹치는 부분이 선인 경우
			else if(x2 == p1 || y2 == q1 || p2 == x1 || q2 == y1) {
				System.out.println("b");
			}
			//a. 공통부분이 사각형인 경우
			else 
				System.out.println("a");
			
		}//i
	}//main
}//class
