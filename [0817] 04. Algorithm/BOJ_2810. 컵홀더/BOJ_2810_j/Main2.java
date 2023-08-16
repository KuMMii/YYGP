package BOJ_2810_j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String seat=br.readLine();
		seat=seat.replace("LL", "S");
		if(seat.length()+1>N) {
			System.out.println(N);
		}else {
			
			System.out.println(seat.length()+1);
		}
	}
}
