package boj_2563_색종이.ryu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[][] pixel = new int[100][100];
		int N = Integer.parseInt(bf.readLine());
		
		for (int i=0; i<N; i++) {
			String[] line = bf.readLine().split(" ");
			int sc, sr, ec, er;
			sc = Integer.parseInt(line[0]);
			sr = 99 - Integer.parseInt(line[1]);
			ec = sc+10; //전까지만 
			er = sr-10;
			
			for (int r=sr; r>er; r--) {
				for (int c=sc; c<ec; c++) {
					pixel[r][c] += pixel[r][c]==1 ? 0 : 1;
				}
			}
		}
		
		int answer = 0;
		for (int r=0; r<100; r++) {
			for (int c=0; c<100; c++) {
				answer += pixel[r][c];
			}
		}
		System.out.println(answer);
	}

}
