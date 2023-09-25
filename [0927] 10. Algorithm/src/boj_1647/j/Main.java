package boj_1647.j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Edge implements Comparable<Edge>{
		int st;
		int ed;
		int w;
		
		public Edge(int st, int ed, int w) {
			super();
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w-o.w;
		}

		
	}//Edge
	
	
	static int N,M,min,sum; 
	static int[] arr; //인덱스 담는 배열
	static List<Edge>[] adjArr;
	static boolean[] visited;
	//선택한 거 넣는 큐, 남은 도시 넣는 큐
	static PriorityQueue<Edge> pq1;
	static PriorityQueue<Edge> pq2;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		visited=new boolean[N+1];
		
		
		//index=집 번호
		adjArr=new ArrayList[N+1];
		
		//리스트 초기화
		for(int i=1; i<=N; i++) {
			adjArr[i]=new ArrayList<Edge>();
		}
		
		//가중치 넣기
		for(int i=0; i<M; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			//왕복 추가
			adjArr[a].add(new Edge(a,b,c));
			adjArr[b].add(new Edge(b,a,c));
		}
		
		//집합으로 하기
//		for(int i=2; i<=N/2; i++) {
//			arr=new int[i];
//			powerSet(1,0,i);
//			
//		}
			arr=new int[2];
			powerSet(1,0,2);
			
		
		
		
	}//main

	
	public static void powerSet(int at, int idx, int size) {
		//여기서는 조합만 하는곳!
		
		
		
		//크기만큼 같아지면 min이랑 비교하기 return;
		if(idx==size) {
			sum=0;
			min=Math.min(Prim(arr[0]),min);
//			System.out.println(Arrays.toString(arr));
			return;
		}
		
		
		for(int i=at; i<=N; i++) {
			if(!visited[i]) {
				arr[idx]=i;
				visited[i]=true;
				powerSet(i+1,idx+1,size);
				visited[i]=false;
				
			}
		}
		
		
	}//powerSet


	public static int Prim(int idx) {
		int pick=0;
//		System.out.println(Arrays.toString(arr));
		
		pq1=new PriorityQueue<>();
		pq2=new PriorityQueue<>();
		
		//먼저 선택한 그룹부터 구해보자
		pq1.addAll(adjArr[idx]);
		visited[idx]=true;
		
		
		while(!pq1.isEmpty()) {
			Edge e=pq1.poll();
			for(int i=; i<arr.length; i++) {
				if(e.ed==arr[i] && !visited[e.ed]) {
					System.out.println(e.ed);
					pq1.addAll(adjArr[e.ed]);
					visited[e.ed]=true;
					pick++;
				}
				
			}
			
			if(pick==arr.length-1) {
				break;
			}
			
		}//while
		
		
		
		
		return 0;
	}

}//class
