package boj_10994_별찍기19;

import java.util.Scanner;

public class Main {
	public static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		n = 1+4*(N-1);
		
		star(n);
		
	}
	
	public static void star(int i) {
		//기저파트
		if(i < 1) return;
		//재귀파트
		draw(i);
		star(i-2);
		draw(i+2);
	}
	
	public static void draw(int s) {
		if(s % 4 == 1) {
			for(int j = 1; j <= (n-s)/2; j++) {
				if(j % 2 == 1) System.out.print("*");
				else System.out.print(" ");
			}
			for(int j = (n-s)/2 + 1; j <= n-(n-s)/2; j++) {
				System.out.print("*");
			}
			for(int j = n - (n-s)/2 + 1; j <= n; j++) {
				if(j % 2 == 1) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}else {
			for(int j = 1; j <= (n-s)/2; j++) {
				if(j % 2 == 1) System.out.print("*");
				else System.out.print(" ");
			}
			for(int j = (n-s)/2 + 1; j <= n-(n-s)/2; j++) {
				System.out.print(" ");
			}
			for(int j = n - (n-s)/2 + 1; j <= n; j++) {
				if(j % 2 == 1) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
	}
}//class
