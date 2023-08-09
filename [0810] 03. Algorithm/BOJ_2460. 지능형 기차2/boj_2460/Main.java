package YYP.boj_2460;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int ppl=0;
		int max=0;
		
		for(int i=0; i<10; i++) {
			int minus=sc.nextInt();
			int plus=sc.nextInt();
			/*for(int j=0; j<2; j++) {
				minus=sc.nextInt();
				plus=sc.nextInt();
			} 
			이렇게 하면 스캐너가 20번 이상으로 도는데 이유가 뭘까..?*/
			ppl=ppl-minus+plus;
			if(ppl>max) {
				max=ppl;
			}
		}
		System.out.println(max);
	}
}
