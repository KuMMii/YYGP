package boj_1991;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[] tree;
	static int L;
	static String ans="";
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		
		tree=new char[(int)Math.pow(2, N-1)+2];
		L=tree.length;
		
		char root=sc.next().charAt(0);
		char left=sc.next().charAt(0);
		char right=sc.next().charAt(0);
		
		tree[1]=root;
		tree[2]=left;
		tree[3]=right;
		
		for(int i=1; i<N; i++) { //입력 줄 개수
			root=sc.next().charAt(0);
			left=sc.next().charAt(0);
			right=sc.next().charAt(0);
			
			for(int j=1; j<L; j++) {
				if(tree[j]==root) {
					tree[j]=root;
					tree[j*2]=left;
					tree[j*2+1]=right;
					break;
				}
			}//for j
		}//for i
		
		
		preorder(1);
		System.out.println(ans);
		ans="";
		inorder(1);
		System.out.println(ans);
		ans="";
		postorder(1);
		System.out.println(ans);
	}//main

	private static void preorder(int i) {
		if(tree[i]=='\u0000') return;
		if(i<L) {
			
			if(tree[i]!='.') {
				ans+=tree[i];
			}
			preorder(i*2); //L
			preorder(i*2+1); //R
		}
	}//preorder
	
	private static void inorder(int i) {
		if(tree[i]=='\u0000') return;
		if(i<L) {
			inorder(i*2); //L
			if(tree[i]!='.') {
				ans+=tree[i];
			}
			inorder(i*2+1); //R
			
		}
	}//inorder
	private static void postorder(int i) {
		if(tree[i]=='\u0000') return;
		if(i<L) {
			postorder(i*2); //L
			postorder(i*2+1); //R
			if(tree[i]!='.') {
				ans+=tree[i];
			}
			
		}
	}//postorder

}//class
