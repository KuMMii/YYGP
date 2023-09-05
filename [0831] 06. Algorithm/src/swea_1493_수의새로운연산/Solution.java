package swea_1493_수의새로운연산;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//998개 맞음..
public class Solution {
	public static int[][] arr = new int[401][401];
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/swea_1493_수의새로운연산/input.txt"));
		Scanner sc = new Scanner(System.in);
		//테스트케이스 T
		int T =sc.nextInt();
		
		//대각선으로 이동하며 숫자가 커지게 배열 생성
		int num = 1;
		for(int r = 1; r <= 400; r++) {
			int i = r;
			for(int c = 1; i >= 1; c++) {
				arr[i--][c] = num++;
			}
		}
		
//		for(int r = 0; r <= 400; r++) {
//			for(int c = 0; c <= 400; c++) {
//				System.out.print(arr[r][c] + " ");
//			}
//			System.out.println();
//		}
		
		
		for(int tc = 1; tc <= T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			//P(rP, cP), Q(rQ, cQ) 좌표 구하기
			int rP = 0, cP = 0, rQ = 0, cQ = 0;
			for(int r = 1; r <= 400; r++) {
				for(int c = 1; c <= 400; c++) {
					if(arr[r][c] == p) {
						rP = r;
						cP = c;
					}
					if(arr[r][c] == q) {
						rQ = r;
						cQ = c;
					}
				}
			}
			
			
			//새로 구할 값의 좌표
			int R = rP + rQ;
			int C = cP + cQ;
			
			System.out.printf("#%d %d\n", tc, arr[R][C]);
				
			
		}//tc
		
	}//main
}//class
