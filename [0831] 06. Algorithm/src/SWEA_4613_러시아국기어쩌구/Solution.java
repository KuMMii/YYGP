package SWEA_4613;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static char[][] arr;
	static int sum,min,R,C;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/SWEA_4613/input2.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			R=sc.nextInt();
			C=sc.nextInt();
			
			arr=new char[R][C];
			
			min=2500;
			
			//깃발 입력
			for(int i=0; i<R; i++) {
				String tmpStr=sc.next();
				arr[i]=tmpStr.toCharArray();
			}
			
			
			for(int l=1; l<=R-2; l++) { //길이용 l
				//가로 움직이기
				for(int r=1; r<=R-1-l; r++) { //row idx
					sum=0;
					
					for(int c=0; c<C; c++) { //col idx
						
						
						//blue
						for(int i=0; i<l;i++) {//두께
							if(arr[r+i][c]!='B') sum++;
						}//for i
					
						//white
						for(int j=0; j<r;j++) {
							if(arr[j][c]!='W') sum++;
						}//for white
						
						//red
						for(int j=r+l; j<R;j++) {
							if(arr[j][c]!='R') sum++;
						}//for red
						
						
					
					}//for c 
					min=Math.min(min, sum);
				}//for r
			}//for l
			
			System.out.printf("#%d %d\n",tc,min);
		}//tc
		
	}//main
}//class


