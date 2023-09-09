package boj_10158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int R,C,r,c,T;
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
		
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
		
		int tmp=(r+T)%(R*2);
		if(tmp<=R) {
			r=tmp;
		}else {
			r=R-(tmp%R);
		}
		
		tmp=(c+T)%(C*2);
		if(tmp<=C) {
			c=tmp;
		}else {
			c=C-(tmp%C);
		}
		
		
		System.out.println(r+" "+c);
		

	}//main

}//class
