// 코드 
package SWEA_5432_쇠막대기자르기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_5432_쇠막대기자르기/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int o=0; //여는 괄호 개수
			int r=0; //레이저 개수
			int sum=0;
			
			String str=sc.next();
			str=str.replace("()", "r"); //()를 그냥 r로 다 바꿔버림ㅎㅎ
			for(int i=0; i<str.length();i++) {
				char bracket=str.charAt(i);
				
				if(bracket=='(') {
					o++;
				}else if(o>0 && bracket=='r') { //r이 맨 앞이나 맨뒤에 있는 경우는 제외
					if(str.charAt(i+1)=='(') { //열린 괄호만 있을때 r나오면
						r++;
						sum+=o*r;
						r=0;
					}else {
						r++;
						
					}
				}else if(bracket==')'){
					sum+=o*r+1; //쇠막대기 개수*잘린수+ 한개의 막대가 닫히면 r을 안해도 조각이 하나 추가로 더 생김
					o--;
					r=0;
				}
				
			}//i
			System.out.printf("#%d %d\n", tc, sum);
		}//tc
	}//main
}//class