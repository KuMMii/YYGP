package ryu.boj_1240_노드사이의거리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static class Edge implements Comparable<Edge> {
        int st, ed, w;
        public Edge(int st, int ed, int w) {
            this.st = st;
            this.ed = ed;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
    static int N, M;
    static List<Edge>[] adjList;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

//      인접 리스트
        adjList = new ArrayList[N+1];
        for (int i=1; i<=N; i++){
            adjList[i] = new ArrayList<>();
        }

        for (int i=0; i<N-1; i++){
            line = br.readLine().split(" ");
            int a, b, w;
            a = Integer.parseInt(line[0]);
            b = Integer.parseInt(line[1]);
            w = Integer.parseInt(line[2]);

            adjList[a].add(new Edge(a, b, w));
            adjList[b].add(new Edge(b, a, w));
        }

        for (int m=0; m<M; m++){
            line = br.readLine().split(" ");
            int st, ed;
            st = Integer.parseInt(line[0]);
            ed = Integer.parseInt(line[1]);

            dijkstra(st, ed);
        }

        System.out.println(sb);
    }

    private static void dijkstra(int st, int ed) {
        int[] cost = new int[N+1];
        for (int i=1; i<=N; i++){
            cost[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.addAll(adjList[st]);
        cost[st] = 0;

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int nw = cost[e.st] + e.w;
            if (nw < cost[e.ed]){
                cost[e.ed] = nw;
                pq.addAll(adjList[e.ed]);
            }
        }

        sb.append(cost[ed] + "\n");
    }
}
