package boj_2533.sy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static class Pos {
		int p, ch;
		public Pos(int p, int ch) {
			this.p = p;
			this.ch = ch;
		}
		@Override
		public String toString() {
			return "Pos [p=" + p + ", ch=" + ch + "]";
		}
		
	}
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//트리 정점 개수
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		List<Pos>[] adjList = new ArrayList[N+1];
		
		for(int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int ch = Integer.parseInt(st.nextToken());
			arr[ch] = p;
			adjList[p].add(new Pos(p, ch));
		}	
		br.close();
		
		boolean[] visited = new boolean[N+1];

		arr[1] = 1;
		visited[1] = true;
		
		
		int earlyAdaptor = 0;
		boolean flag = false;
		Arrays.sort(adjList, new Comparator<List<Pos>>() {
			@Override
			public int compare(List<Pos> o1, List<Pos> o2) {
				return o2.size() - o1.size();
			}
		});

		for(int j = 0; j < N+1; j++) {
			if(adjList[j].size() != 0 && adjList[j].get(0).p != 1) {
				visited[adjList[j].get(0).p] = true;
				flag = true;
				for(int i = 1; i < N+1; i++) {
					if(arr[i] == adjList[j].get(0).p) {
						arr[i] = arr[adjList[j].get(0).p];
						visited[i] = true;
					}
					if(arr[i] != 1) {
						flag = false;
					}
				}//i
				adjList[0].clear();
				earlyAdaptor++;
			} else if(adjList[j].size() != 0 && adjList[j].get(0).p == 1) {
				adjList[0].clear();
			} else if(adjList[j].size() == 0) {
				break;
			}
//			System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(visited));
		}//j
		
		for(int i = 1; i < N+1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				earlyAdaptor++;
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(earlyAdaptor));
		bw.flush();
		bw.close();
	}//main
}//class
