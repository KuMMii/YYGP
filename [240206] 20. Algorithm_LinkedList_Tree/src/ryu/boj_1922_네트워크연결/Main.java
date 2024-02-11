package ryu.boj_1922_네트워크연결;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int V, E;

    static class Edge implements Comparable<Edge> {
        int a, b, w;

        public Edge(int a, int b, int w) {
            super();
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    static int[] parents, rank;
    private static void makeSet() {
        parents = new int[V+1];
        rank = new int[V+1];

        for (int i=1; i<parents.length; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }
    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a==b) return false;

        //각 트리의 높이(rank)를 기억한 다음, 두개의 트리를 비교해 높이가 작은 트리를 높이가 큰 트리에 붙이는 방법
        if (rank[a] > rank[b]) {
            rank[a] += rank[b];
            parents[b] = a;
        } else {
            rank[b] += rank[a];
            parents[a] = b;
        }
        return true;
    }

    private static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int e=0; e<E; e++) {
            int a, b, w;
            a = sc.nextInt();
            b = sc.nextInt();
            w = sc.nextInt();

            pq.offer(new Edge(a, b, w));
        }

        //make set
        makeSet();

        int pick = 0;
        int ans = 0;
        while (!pq.isEmpty() && pick!=V-1) {
            Edge e = pq.poll();

            if (union(e.a, e.b)) {
                ans += e.w;
                pick++;
            }
        }

        System.out.println(ans);

        sc.close();
    }
}