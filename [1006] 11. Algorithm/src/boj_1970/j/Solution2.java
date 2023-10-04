package SWEA_1970;

import java.util.Scanner;

public class Solution2 {
	static int[] ten, fifty;
	static {
		ten=new int [10];
		fifty=new int [10];
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int i=0; i<=9; i++	) {
			if(i<5) {
				ten[i]=i;
				fifty[i]=0;
			}else {
				ten[i]=ten[i-5];
				fifty[i]=1;
			}
		}
		
		for(int tc=1; tc<=T; tc++) {
			int overTenThous=0;
			int money=sc.nextInt();
			
			//if money is more than 100000
			//get 50000 quan
			if(money>100000) {
				int tmp=money%1000000;
				tmp%=100000;
				overTenThous=(money-tmp)/50000;
				money=tmp;
			}
			
			
			int tenthous=money/10000;
			int thous=(money%10000)/1000;
			int hunds=(money%1000)/100;
			int tenInt=(money%100)/10;
			
			
			System.out.println("#"+tc);
			System.out.printf("%d %d %d %d %d %d %d %d\n", 
					fifty[tenthous]+overTenThous,ten[tenthous],fifty[thous],ten[thous],
					fifty[hunds],ten[hunds],fifty[tenInt],ten[tenInt]);
		}//tc
		sc.close();
	}//main
}//class
