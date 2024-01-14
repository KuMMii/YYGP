package boj_10994_별찍기19;

import java.util.Scanner;

public class Main2 {
	public static char[][] arr;
	public static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//가장 바깥 부분 사각형의 한 변의 별 개수
		cnt = 1+4*(N-1);
		arr = new char[cnt][cnt];
		
		star(cnt, 0);
		
		for(int r = 0; r < 1+4*(N-1); r++) {
			for(int c = 0; c < 1+4*(N-1); c++) {
				if(arr[r][c] == '\u0000') System.out.print(' ');
				else System.out.print(arr[r][c]);
			}
			System.out.println();
		}
		
	}
	
	public static void star(int cnt, int st) {
		//기저파트
		if(cnt == 1) {
			arr[st][st] = '*';
			return;
		}
		//재귀파트
		for(int j = st; j < st + cnt; j++) {
			arr[st][j] = '*';
			arr[st+cnt-1][j] = '*';
			arr[j][st] = '*';
			arr[j][st+cnt-1] = '*';
		}
		star(cnt-4, st+2);
	}
	
}//class
