package boj_5014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int F,S,G,U,D;
	static boolean[] visited;
	static Queue<Integer> q;
	static int[] cnt;
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		F=sc.nextInt();
		S=sc.nextInt();
		G=sc.nextInt();
		U=sc.nextInt();
		D=sc.nextInt();
		
		visited=new boolean[F+1];
		q=new LinkedList<>();
		cnt=new int[F+1]; //층수가 1부터 시작해서 이렇게 정함
		
		
		//input fin
		
		BFS(0);
		
		
		
	}//main
	public static void BFS(int num) {
		//최소값이니까 BFS
		
		//첫값 담기
		q.add(S);
		//cnt배열에 0 담기 ->이게 cnt임
		cnt[S]=num;
		
		//큐가 빌때까지
		while(!q.isEmpty()) {
			//큐에서 빼기
			int floor=q.poll();
			
			//꺼낸 값이 목표값과 같으면 끝
			if(floor==G) {
				System.out.println(cnt[G]);
				return;
			}
			
			//꺼낸 층수가 범위 내고, 새로 간 층일때
			if(1<=floor && floor<=F && !visited[floor]) {
				
				//올라가는게 0이 아니고(0인것도 포함하면 쓸데없이 카운트됨) 올라갔을 때 범위내일 때만
				if(U!=0&&floor+U<=F ) {
					q.add(floor+U);
					//그냥 카운트를 하니까 모든 경우를 다 더해버렸음. 그래서 각 값별 배열에 이전 층 카운트에 +1한걸 배열에 담음
					cnt[floor+U]=cnt[floor]+1;
				}
				//내려가는게 0이 아니고(0인것도 포함하면 쓸데없이 카운트됨) 내려갔을 때 범위내일 때만
				if(D!=0&&floor-D>=1) {
					q.add(floor-D);
					cnt[floor-D]=cnt[floor]+1;
				}
				
				//층 간거 표시해주기
				visited[floor]=true;
			}
		}
		
		
		
		//돌릴때까지 같은 층이 없었다는 거니까 없다는 거 출력
		System.out.println("use the stairs");
		
		
		
		
	}

}//class
