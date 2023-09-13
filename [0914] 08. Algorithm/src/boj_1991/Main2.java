package boj_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

	 static class Node{
		char data;
		Node left;
		Node right;
		
		Node(char data, Node left, Node right) {
			this.data= data;
			this.left = left;
			this.right = right;
		}
	}//class Node

	static int N;
	static String ans="";
	static Node head=new Node('A',null,null);

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			String [] str = br.readLine().split(" ");
			char root = str[0].charAt(0);
			char left = str[1].charAt(0);
			char right = str[2].charAt(0);
			insertNode(head,root,left,right);
		}
		
		
		preorder(head);
		System.out.println(ans);
		ans="";
		inorder(head);
		System.out.println(ans);
		ans="";
		postorder(head);
		System.out.println(ans);
	}//main
	
	
	
	
	private static void postorder(Node node) {
		//left-root-right
		if(node==null) return;
		postorder(node.left);
		postorder(node.right);
		ans+=node.data;
	}
	
	

	private static void inorder(Node node) {
		//left-root-right
		if(node==null) return;
		inorder(node.left);
		ans+=node.data;
		inorder(node.right);
	}







	private static void preorder(Node node) {
		//root-left-right
		if(node==null) return;
		ans+=node.data;
		preorder(node.left);
		preorder(node.right);
	}//preorder

	
	
	
	
	
	
	static void insertNode(Node tmp, char root, char left, char right) {
		//루트노드(A)인가?
		if(tmp.data==root) {
			//자식 노드가 . 이면 null, 아니면 새로운 노드 만들기
			tmp.left=(left=='.'? null:new Node(left,null,null));
			tmp.right=(right=='.'? null:new Node(right,null,null));
		}else {
			if(tmp.left!=null) insertNode(tmp.left, root, left, right);
			if(tmp.right!=null) insertNode(tmp.right, root, left, right);
		}
	}//insertNode
}//class
