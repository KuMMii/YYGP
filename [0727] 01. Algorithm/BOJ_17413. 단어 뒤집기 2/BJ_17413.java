package YYP.bj_17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_17413 {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] strSp=br.readLine().split("");
		List<String> sent=new ArrayList<String>();
		for(int i=0; i<strSp.length;i++) {
			String str="";
			if(strSp[i]=="<") {
				while(strSp[i]==">") {
					str+=strSp[i];
				}
				sent.add(str);
			}else if(strSp[0]!="<") {
				int cnt=0;
				for(int j=0; j<strSp.length;j++) {
					if(strSp[i]=="<") cnt++;
				}
				
				if(cnt==0) {
					while(strSp[i]=="<") {
						str+=strSp[i];
					}
					
				}
				while(strSp[i]=="<") {
					str+=strSp[i];
				}
				StringBuilder sb = new StringBuilder(str);
				sent.add(sb.reverse().toString());
			}else if(strSp[i-1]==">") {
				while(strSp[i+1]=="<"||strSp[i+1]=="") {
					str+=strSp[i];
				}
				StringBuilder sb = new StringBuilder(str);
				sent.add(sb.reverse().toString());
			}
		}
		for(String s:sent) {
			System.out.print(s);
		}
	}
}
