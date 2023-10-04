package boj_17471;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N,min;
	static int[] ppl;
	static int[][] adjArr;
	static boolean[] visited, BFSvisted;
	static Queue<Integer> q;
	

	public static void main(String[] args) {
		//input
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt(); //town quan
		
		//ppl
		ppl=new int[N];
		for(int i=0; i<N; i++) {
			ppl[i]=sc.nextInt();
		}
		
		//adjacent Array
		adjArr=new int[N][N];
		
		for(int i=0; i<N; i++) {
			int tmp=sc.nextInt();
			for(int j=0; j<tmp; j++) {
				int tmp2=sc.nextInt()-1;
				adjArr[i][tmp2]=1;
				adjArr[tmp2][i]=1;
			}
		}
		sc.close();
		//input fin

		
		//visited
		visited=new boolean[N];
		
		min=Integer.MAX_VALUE;
		//1. power set
		powerSet(0);
		
		if(min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}//main



	public static void powerSet(int num) {
		
		//recursion terminates
		if(num==N) {
			//2. check whether it is union or not by BFS
			isConnected();
			return;
		}
	
		visited[num]=true;
		powerSet(num+1);
		visited[num]=false;
		powerSet(num+1);
		
		
		
	}//powerSet




	public static void isConnected() {
		List<Integer> g1=new ArrayList<>();
		List<Integer> g2=new ArrayList<>();
		
		//true, false인 애들끼리 묶음
		for(int i=0; i<visited.length; i++) {
			if(visited[i]) g1.add(i);
			else g2.add(i);
		}
		
		//마을 1개는 무조건 있어야함
		if(g1.size()>0 && g2.size()>0) {
			
			//3. if it is united, then get the sum and compare with the min
			if(BFS(g1) && BFS(g2)) {
				int sum=0;
				for(int i=0; i<g1.size(); i++) {
					sum+=ppl[g1.get(i)];
				}
				for(int i=0; i<g2.size(); i++) {
					sum-=ppl[g2.get(i)];
				}
				min=Math.min(Math.abs(sum), min);
				
			}
			
		}
	}//isConnected



	public static boolean BFS(List<Integer> group) {
		
		BFSvisted=new boolean[N];
		//check the connected number's quantity
		int conNum=0;
		int[][] tAdjArr=new int[N][N];
		
		//adjArr를 사용하면 영원히 바뀌니까 임시 인접행렬 생성
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				tAdjArr[i][j]=adjArr[i][j];
			}
		}
		

		q=new LinkedList<Integer>();
		q.add(group.get(0));
		BFSvisted[group.get(0)]=true;

		//bfs
		while(!q.isEmpty()) {
			int t=q.poll();
			
			//check a num which is not visited and connected with t
			for(int i=0; i<group.size(); i++) {
				if(tAdjArr[t][group.get(i)]==1) {
					q.add(group.get(i));
					conNum++;
					//break the link
					tAdjArr[t][group.get(i)]=0;
					tAdjArr[group.get(i)][t]=0;
					BFSvisted[group.get(i)]=true;
					
				}
			}
		}//while
		
		
		//return if all nodes of list are true
		int cnt=0;
		for(int i=0; i<BFSvisted.length; i++) {
			if(BFSvisted[i]) cnt++;
		}
		return cnt==group.size();
	}//BFS
	
}//class
