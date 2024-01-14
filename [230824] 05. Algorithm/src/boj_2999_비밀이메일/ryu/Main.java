package boj_2999_비밀이메일.ryu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// N<=100, R<=C
		int N, R, C;
		R = 0;
		C = 0;
		
		// 약수구하기
		String og = bf.readLine();
		N = og.length();
		for (int i=(int)Math.sqrt((double)N); i>=1; i--) {
			if (N%i == 0) {
				R = i;
				C = N/R;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int r=0; r<R; r++) {//뭉치에 담긴 수
			for (int c=0; c<C; c++) {//뭉치 수
				sb.append(og.charAt(r+c*R));
			}
		}
		
		System.out.println(sb);
	}
	
}
