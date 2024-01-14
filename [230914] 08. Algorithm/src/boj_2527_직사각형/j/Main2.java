package boj_2527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
//이게 답
public class Main2 {
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
			
			//겹치는 부분 없음
			if(x1>p2||p1<x2||y1>q2|| q1<y2) {
				ans='d';
			}
			//점
			else if(((x1==p2)&& ((q1==y2) || (y1==q2))) || ((p1==x2) && ((q1==y2)|| (y1==q2)))){
				ans='c';
			}
			//선분
			else if(y1==q2|x1==p2||q1==y2||p1==x2) {
				ans='b';
			}

			System.out.println(ans);
			
		}//tc
		
	}//main
}//class
