package boj_2563_색종이.j;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		int[][] rnc=new int[N][2];
		int maxr=0;
		int maxc=0;
		
		for(int n=0; n<N; n++) {
			int c=sc.nextInt();
			int r=sc.nextInt();
			rnc[n][0]=r;
			rnc[n][1]=c;
			
			maxc=Math.max(maxc, c);
			maxr=Math.max(maxr, r);
		}//for n

		int[][] arr=new int[maxr+11][maxc+11];
		
		for(int i=0; i<N; i++) {
			for(int r=rnc[i][0]; r<rnc[i][0]+10;r++) {
				for(int c=rnc[i][1]; c<rnc[i][1]+10;c++) {
					arr[r][c]=1;
				}
			}
		}
		
		int cnt=0;
		
		for(int[] i : arr) {
			for(int j : i) {
				if(j==1) cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}//main
}//class
