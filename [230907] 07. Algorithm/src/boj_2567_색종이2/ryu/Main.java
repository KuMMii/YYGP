package boj_2567_색종이2.ryu;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[102][102];
		int length = 10; //len of paper
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		int N = sc.nextInt(); //num of paper
		for (int n=0; n<N; n++) {
			int sy, sx, ey, ex;
			sx = sc.nextInt()+1;
			sy = sc.nextInt()+1;
			ex = sx+length;
			ey = sy+length;
			
			for (int r=sy; r<ey; r++) {
				for (int c=sx; c<ex; c++) {
					arr[r][c] = 1;
				}
			}
		}
		int ans = 0;
		for (int r=0; r<arr.length; r++) {
			for (int c=0; c<arr[0].length; c++) {
				if (arr[r][c]==1) {
					for (int i=0; i<4; i++) {
						if (arr[r+dr[i]][c+dc[i]]==0) ans++;
					}
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}

}
