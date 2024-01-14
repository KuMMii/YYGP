import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static List<Edge>[] adjList;
	static long[] d;
	static long INF = Integer.MAX_VALUE;
	static class Edge {
		int st, ed, w;

		public Edge(int st, int ed, int w) {
			super();
			this.st = st;
			this.ed = ed;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[V+1];
		d = new long[V+1];
		
		for (int v=1; v<=V; v++) {
			adjList[v] = new ArrayList<>();
			d[v] = INF;
		}
		
		for (int e=0; e<E; e++) {
			StringTokenizer line = new StringTokenizer(bf.readLine());
			int a, b, w;
			a = Integer.parseInt(line.nextToken());
			b = Integer.parseInt(line.nextToken());
			w = Integer.parseInt(line.nextToken());
			
			adjList[a].add(new Edge(a, b, w));
		}
		
		boolean hasNegativeCycle = bellman_ford(1);
		StringBuilder sb = new StringBuilder();
		if (hasNegativeCycle) {
			sb.append(-1+"\n");
		} else {
			for (int v=2; v<=V; v++) {
				sb.append(d[v]==INF ? -1+"\n" : d[v]+"\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean bellman_ford(int start) {
		d[start] = 0;
		
		for (int i=0; i<V; i++) {
			//모든 정점에 대한 간선 확인
			for (int v=1; v<=V; v++) {
				if (d[v]==INF) continue;
				
				for (Edge e : adjList[v]) {
					long nw = d[v] + e.w;
					if (nw<d[e.ed]) {
						if (i==V-1) {
							//has negative cycle
							return true;
						}
						
						d[e.ed] = nw;
					}
				}
			}
		}
		
		return false;
	}
}
