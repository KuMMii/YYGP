package boj_10158_개미.sy;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//가로w*세로h인 격자 공간
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		//처음 위치 (p, q)
		int p = sc.nextInt();
		int q = sc.nextInt();
				
		int t = sc.nextInt();
		
		
		//p와 q를 따로 보면 w*2초만큼 움직이면 자기 자리로 되돌아 옴
		p += t % (w * 2);
		q += t % (h * 2);
		
		p = p > w ? Math.abs((w * 2) - p) : p;
		q = q > h ? Math.abs((h * 2) - q) : q; 		
		
		System.out.println(p + " " + q);
		
	}//main
}//class

//99%에서 시간초과
//		while(t > 0) {
//			int tP = dirP > 0 ? w-p : p;
//			int tQ = dirQ > 0 ? h-q : q;
//			
//			int tPQ = Math.min(tP, tQ);
//			int min = Math.min(tPQ, t);
//			t -= min;
//			
//			if(tP > tQ) dirQ = -1;
//			else if(tP < tQ) dirP = -1;
//			else {
//				dirP = -1;
//				dirQ = -1;
//			}
//		}