package BOJ_2810_j;

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		String seat=sc.next();
		seat=seat.replace("LL", "S");
		if(seat.length()+1>N) {
			System.out.println(N);
		}else {
			
			System.out.println(seat.length()+1);
		}
	}
}
