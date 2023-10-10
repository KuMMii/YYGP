package boj_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,cnt;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			N=Integer.parseInt(st.nextToken());
			
			arr=new int [N];
			cnt=0;
			perm(0);
			
			System.out.println(cnt);
			
			
	}//main

	public static void perm(int depth) {
		
		if(depth==N) {
			cnt++;
			return;
		}
		
		//select row
		for(int i=0; i<N; i++) {
			arr[depth]=i;
			
			if(check(depth)) {
				perm(depth+1);
			}
		}
		
		
		
	}//perm

	//check if the column is placed on the same row or diagonal position
	private static boolean check(int col) {
		
		for(int i=0; i<col; i++) {
			//same row
			if(arr[col]==arr[i]) return false;
			//diagonal position
			if(Math.abs(col-i)==Math.abs(arr[col]-arr[i])) return false;
		}
		
		
		return true;
	}

	
}//class
