package boj_2567_색종이2.sy;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int minR = 100, maxR = 0, minC = 100, maxC = 0;
		for(int i = 1; i <= N; i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			minR = Math.min(minR, R);
			maxR = Math.max(maxR, R);
			minC = Math.min(minC, C);
			maxC = Math.max(maxC, C);
		}
		System.out.println(minR + " " + maxR + " " + minC + " " + maxC);
		
		//겉 부분의 둘레    
		
		int cir = (maxR + 10 - minR) * 2 + (maxC + 10 - minC) * 2;
		System.out.println(cir);
		
	}
}//class
