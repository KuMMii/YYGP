package boj_1647.j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	//for Edge Array
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
	static List<Edge>[] adjArr; //Edge Array
	static boolean[] visited; 
	//선택한 거 넣는 큐, 남은 도시 넣는 큐(Prim방식 사용)
	static PriorityQueue<Edge> pq;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		visited=new boolean[N+1]; //도시번호가 1부터 시작
		
		
		//index=집 번호
		adjArr=new ArrayList[N+1]; //도시번호가 1부터 시작해서
		
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
		
			
		Prim(1);//도시는 1부터 있으니까
		
		
	}//main



	public static void Prim(int idx) {
		int pick=0; //뽑은 개수
		int max=Integer.MIN_VALUE;//가장 큰 값을 따로 저장해서 마지막 합에서 뺄 예정
		int sum=0; //MST 전체 합
		pq=new PriorityQueue<>(); //간선들을 담고 가장 작은값을 빼는 pq
		
		//첫번째 인덱스는 그냥 넣기
		pq.addAll(adjArr[idx]);
		visited[idx]=true;
		
		
		//프림으로 전체 루트 보기
		while(pick!=adjArr.length-2) {
			//하나 빼기
			Edge e=pq.poll();
			
			if(!visited[e.ed]) {
				//새로 가는 곳이면 합에 가중치 더해주기
				sum+=e.w;
				//최대값을 찾기 위해 하는 것(크루스칼로 할때 마지막꺼를 안더하면 이과정이 없어도 됨)
				max=Math.max(max, e.w);
				//또 도착정점이 시작점인 간선 전부 추가
				pq.addAll(adjArr[e.ed]);
				visited[e.ed]=true;
				pick++;
				
			}
				
		}//while
			//전체 합에서 가장 큰 간선빼기	
			System.out.println(sum-max);
		
		
	}//prim

}//class
