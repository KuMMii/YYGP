package YYP.bj_2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2292 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine().trim());
		
		int i=0; //N=1일때도 생각해줘야함!
		while(N>3*i*(i+1)+1) {
				++i;
		}
		System.out.println(i+1);
	}
}
