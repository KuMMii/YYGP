package boj_2533.inseung;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// 걍완전 블로그 봄 - DFS + dp
// 이것도 런타임 에러 뜨네!! 이제 그만!!
public class Main {

	public static void main(String[] args) {
	       
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new ArrayList[N+1]; 
		visited = new boolean[N+1];
		whoIsRoot = new ArrayList<>();
		for (int i = 1; i<=N; i++) {
			whoIsRoot.add(i); // root 후보인 1~N 다 추가함
			list[i] = new ArrayList<>(); // 1~N 인덱스에 빈 리스트 다 대입해줌
		}
		for (int i = 1; i<=N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b); // list[a] = a의 바로 밑에 자식들 리스트
			whoIsRoot.remove(new Integer(b)); // 자손으로 등장한 애는 root가 아님. 빼줌.
		}

		int root = whoIsRoot.get(0); // 끝까지 있는 애가 root임
		dp = new int[N+1][2];
		int answer = 0;
		
		// dp배열 다 채워줌
		for (int a = 1; a<=N; a++) {
			DFS(a);
		}
		
		System.out.println(Math.min(dp[root][0], dp[root][1]));
	}
	
	static int N;
	static List<Integer>[] list;
	static int[][] dp; // 값: 나 + 내 밑에 자손들 얼리어답터 수 / 0열: 나 얼리어답터일때 / 1열: 나 얼리 아닐 때
	static boolean[] visited;
	static List<Integer> whoIsRoot;
	
	static void DFS(int i) {
		visited[i] = true;
		dp[i][0] = 1; // 일단 나 얼리어답터야
		dp[i][1] = 0; 
		for (int a = 0; a<list[i].size(); a++) {
			int child = list[i].get(a); // 자식 한사람씩 나와
			if (!visited[child]) { // 아직 방문안했으면
				DFS(child); // 너네 dp값 구해와
			}
			// 나 얼리어답터일땐 자식이 뭐든 상관없음. 자식들 두 선택지 중 최소값 더해줌
			dp[i][0] += Math.min(dp[child][0], dp[child][1]);
			// 나 얼리 아닐 땐 자식이 다 얼리어답터여야 함. 
			dp[i][1] += dp[child][0];
		}
	}

}

