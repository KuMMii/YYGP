package boj_2941_크로아티아알파벳.j;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		str=str.replace("c=", "c");
		str=str.replace("c-", "c");
		str=str.replace("dz=", "c");
		str=str.replace("d-", "c");
		str=str.replace("lj", "c");
		str=str.replace("nj", "c");
		str=str.replace("s=", "c");
		str=str.replace("z=", "c");
		System.out.println(str.length());
	}
}
