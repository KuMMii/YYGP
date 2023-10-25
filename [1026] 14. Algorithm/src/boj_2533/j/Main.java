package boj_2533;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static boolean[] visited; //for bfs
	static List<Integer> [] graph;
	//dp : 해당 지점까지의 얼리어답터 인원수(트리 구조라 자식 노드들의 dp개수를 더해옴)
	static int[][] dp; //[r][c]일 때, r : 노드 번호, c : 0 -> 해당 노드가 earlyAdaptor이 아닐때, 1 -> 해당 노드가 얼리어답터일때
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		graph=new ArrayList[N+1];
		visited=new boolean[N+1];
		dp=new int[N+1][2];
		
		for(int i=1; i<=N; i++) {
			graph[i]=new ArrayList<>();
		}
		
		//input
		for(int i=1; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			
			graph[s].add(e);
			graph[e].add(s);
			
		}
		///////////////input fin
		
		//트리 구조라 1부터 시작
		DFS(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
		
	}//main

	public static void DFS(int idx) {
		visited[idx]=true;
		dp[idx][0]=0; //해당 노드가 얼리어답터가 아닌 경우
		dp[idx][1]=1; //해당 노드가 얼리인 경우(우선 시작 시 해당 지점이 얼리어답터이므로 개수 1)
		
		for(int child : graph[idx]) {
			if(!visited[child]) {
				DFS(child); //dfs 재귀 호출을 통해 자식 노드의 dp값을 미리 구한다
				dp[idx][0]+=dp[child][1]; //자식 노드가 무조건 얼리어답터야함
				dp[idx][1]+=Math.min(dp[child][0], dp[child][1]);
			}
		}
	}

}//class
