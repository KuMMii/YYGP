package swea_1248_공통조상;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static List<Node> nodeList;
	public static int n; 
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/swea_1248_공통조상/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//정점의 개수
			int V = sc.nextInt();
			nodeList = new ArrayList<>();
			for(int i = 1; i <= V; i++) {
				Node node = new Node(i);
				nodeList.add(node);
			}
			
			//간선의 개수
			int E = sc.nextInt();

			//공통 조상을 찾는 두 개의 정점 번호
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			for(int i = 1; i <= E; i++) {
				int p = sc.nextInt();
				int ch = sc.nextInt();
				if(nodeList.get(p-1).left == 0) {
					nodeList.get(p-1).left = ch;
					nodeList.get(ch-1).parent = p;
				}else {
					nodeList.get(p-1).right = ch;;
					nodeList.get(ch-1).parent = p;
				}
			}//E

			boolean[] visited = new boolean[V+1];

			//공통조상 p
			int p = 0;
			//부모노드를 따라 올라가면서 방문한 노드는 true로 변경
			int p1 = v1;
			while(p1 != 1) {
				p1 = nodeList.get(p1-1).parent;
				visited[p1] = true;
			}
			
			//부모노드를 따라 올라가다가 true가 나오면 p에 저장
			int p2 = v2;
			while(p2 != 1) {
				p2 = nodeList.get(p2-1).parent;
				if(visited[p2] == true) {
					p = p2;
					break;
				}
			}
			
			//서브트리 크기 n
			n = 0;
			n = preOrder(p);
			System.out.printf("#%d %d %d%n", tc, p, n);
			
		}//tc
	}//main
	
	public static class Node {
		int parent;
		int data;
		int left;
		int right;
		
		public Node(int data) {
			parent= 0;
			this.data = data;
			left = 0;
			right = 0;
		}
		
	}
	
	public static int preOrder(int data) {
		if(data == 0 || nodeList.get(data-1) == null) {
			return n;
		}
		
		Node node = nodeList.get(data-1);
		n++;
		preOrder(node.left);
		preOrder(node.right);	
		return n;
		
	}
		
}//Solution
