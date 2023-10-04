package SWEA_1970;

import java.util.Scanner;

public class Solution {
	static int[] money= {50000,10000,5000,1000,500,100,50,10};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		
		for(int tc=1; tc<=T; tc++) {
			int[] quan=new int[8];
			int N=sc.nextInt();
			
			for(int i=0; i<8; i++) {
				if(N>=money[i]) {
					quan[i]=N/money[i];
					N%=money[i];
				}
			}
			
			
			System.out.println("#"+tc);
			for(int i: quan) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
	}
}
