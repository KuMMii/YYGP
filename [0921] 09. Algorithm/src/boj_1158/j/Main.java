package boj_1158;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		int N=sc.nextInt();
		int T=sc.nextInt();
		List<Integer> list=new ArrayList<>();
		List<Integer> ans=new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			list.add(i);
		}//for
		
		int idx=0;
		while(list.size()>0) {
			idx+=T-1;
			if(idx>list.size()-1) idx%=list.size();
			ans.add(list.remove(idx));
		}
		sc.close();
		String s=ans.toString().replace("[", "<").replace("]", ">");
		System.out.printf(s);
		
	}//main
}//class
