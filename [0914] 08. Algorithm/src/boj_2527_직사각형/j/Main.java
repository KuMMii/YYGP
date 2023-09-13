package boj_2527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map=new HashMap<>();
		
		for(int tc=1; tc<=4; tc++) {
			char ans='a'; //r
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int x1= Integer.parseInt(st.nextToken());
			int y1= Integer.parseInt(st.nextToken());
			int p1= Integer.parseInt(st.nextToken());
			int q1= Integer.parseInt(st.nextToken());
			int x2= Integer.parseInt(st.nextToken());
			int y2= Integer.parseInt(st.nextToken());
			int p2= Integer.parseInt(st.nextToken());
			int q2= Integer.parseInt(st.nextToken());
			
			//점
			if(((x1==p2)&& ((q1==y2) || (y1==q2))) || ((p1==x2) && ((q1==y2)|| (y1==q2)))){
				ans='c';
			}
			//선분
			else if(y1==q2|x1==p2||q1==y2||p1==x2) {
				ans='b';
			}
			//겹치는 부분 없음
			else if(x1>p2||p1<x2||y1>q2|| q1<y2) {
				ans='d';
			}

			System.out.println(ans);
			
		}//tc
		
	}//main
}//class
