package boj_1158.ryu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N, K;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for (int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder("<");
		int k = 0;
		while (!q.isEmpty()) {
			int n = q.poll();
			k++;
			if (k%K == 0) {
				sb.append(n+", ");
				continue;
			}
			q.offer(n);
		}
		sb.replace(sb.length()-2, sb.length(), ">");
		System.out.println(sb);
	}

}

