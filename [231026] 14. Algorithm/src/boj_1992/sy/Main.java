package boj_1992.sy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] edges;
	static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//컴퓨터의 수
		N = Integer.parseInt(br.readLine());
		//연결할 수 있는 선의 수
		M = Integer.parseInt(br.readLine());
		
		//[0]: 시작정점, [1]: 끝정점, [2]ㅣ: 가중치
		edges = new int[M][3];
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}//입력 끝
		
		br.close();
		
		//가중치 기준 오름차순 정렬
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		p = new int[N+1];
		
		//makeset
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		int cost = 0;
		int cnt = 0;
		for(int i = 0; i < M; i++) {
			int x = edges[i][0];
			int y = edges[i][1];
			
			//사이클이 형성되지 않을 경우
			if(findset(x) != findset(y)) {
				union(findset(x), findset(y));
				cost += edges[i][2];
				cnt++;
			}
			
			if(cnt == N-1) break;
		}//i
		
		System.out.println(cost);
		
	}//main
	
	static void union(int x, int y) {
		p[y] = x; 
	}//union

	static int findset(int x) {
		//path compression
		if(x != p[x]) 
			p[x] = findset(p[x]);
		return p[x];
	}//findset
	
}//class
