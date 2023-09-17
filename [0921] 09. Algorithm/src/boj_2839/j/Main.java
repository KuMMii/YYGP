package boj_2839;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt(); //total KG
		
		int ans=-1;//기본으로 안되는 경우 설정
		int Max=N/5; //5kg 최대개수
		
		for(int i=Max; i>=0; i--) { //5의 최대개수부터 0까지 반복문 돌림
			if(i==0) {
				if(N%3==0) {
					ans=N/3;
				}
			}else {
				if((N-(5*i))%3==0) { //5의 배수만큼 뺀후 나머지가 3으로 나눠지면
					ans=i+((N-(5*i))/3); //결과물 출력
					break;
				}//if
				
			}//if else
		}//for
			
		System.out.println(ans);
		
	}//main
}//class
