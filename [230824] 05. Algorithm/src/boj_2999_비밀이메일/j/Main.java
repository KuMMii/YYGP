package boj_2999_비밀이메일.j;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String input=sc.next();
		
		StringBuilder sb=new StringBuilder(input);
		int max=0; //for R max
		
		//배열 크기부터 찾기
		for(int i=1; i<=sb.length()/2+1; i++) {
			if(sb.length()%i==0) {
				if(i<=sb.length()/i)
					max=Math.max(max, i);
			}//if
		}//배열 크기 for
		int r=max;
		int c=sb.length()/max;
		char[][] arr=new char[r][c]; //init array
		int n=0;
		String rev=sb.reverse().toString();
		for(int j=c-1; j>=0; j--) { //c
			for(int i=r-1 ; i>=0; i--, n++) { //r
				arr[i][j]=rev.charAt(n);
			}//for i
		}//for j
		
		for(char[] i : arr) {
			for(char j : i) {
				System.out.print(j);
			}
		}
	}
}
