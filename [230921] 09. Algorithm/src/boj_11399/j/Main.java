package boj_11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		int [] arr=new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		int tmp=0;
		int ans=0;
		for(int i : arr) {
			tmp+=i;
			ans+=tmp;
		}
		System.out.println(ans);
	}
}
