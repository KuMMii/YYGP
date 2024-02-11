package ryu.boj_30885_Φ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static Node[] nodes;
    static class Node {
        Node prev, next;
        long size;

        public Node(long size) {
            this.size = size;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N];
        String[] line = br.readLine().split(" ");
        for (int i=0; i<N; i++){
            nodes[i] = new Node(Integer.parseInt(line[i]));
        }

        for (int i=0; i<N; i++){
            if (i>=1){
                nodes[i].prev = nodes[i-1];
            }
            if (i<N-1) {
                nodes[i].next = nodes[i+1];
            }
        }

        int left = N;
        outer: while (left > 1) {
            for (int i=0; i<N; i++){
                Node curr = nodes[i];
                long currentSize = nodes[i].size;
                if (currentSize==0) continue;

                Node prev = curr.prev;
                Node next = curr.next;
                while (prev != null && prev.size == 0) {
                    prev = prev.prev;
                }
                while (next != null && next.size == 0) {
                    next = next.next;
                }

                if (prev != null && prev.size != 0 && prev.size <= currentSize) {
                    curr.size += prev.size;
                    prev.size = 0;
                    left--;
                }
                if (next != null && next.size != 0 && next.size <= currentSize) {
                    curr.size += next.size;
                    next.size = 0;
                    left--;
                }
            }
        }

        int order = 1;
        Node curr = nodes[0];
        while (curr.size == 0) {
            curr = curr.next;
            order++;
        }
        System.out.println(curr.size);
        System.out.println(order);

    }
}
