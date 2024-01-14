package BOJ_2851_j;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int[] arr=new int[10];
		for(int i=0; i<10; i++) {
			arr[i]=sc.nextInt();
		}
		int max=0;
		for(int i=1; i<10; i++) { //고정 인덱스
			arr[i]+=arr[i-1];
			if(Math.abs(100-arr[i])<=Math.abs(100-arr[i-1])) {
				max=arr[i];
			}else {
				break;
			}
			
		}//i
		
		System.out.println(max);
		
		
		
	}
}
