package boj_1158.sy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N명의 사람 원으로 앉기
		int N = sc.nextInt();
		//K번째 사람 제거
		int K = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		
		//N명의 사람 모두 queue에 넣기
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		System.out.print("<");
		
		//큐가 빌 때까지 반복
		while(!queue.isEmpty()) {
			//1번째 사람부터 K-1번재 사람까지 큐에서 빼서 다시 넣기
			for(int i = 1; i < K; i++) {
				queue.add(queue.poll());
			}
			//K번째 사람은 출력
			System.out.print(queue.poll());
			if(!queue.isEmpty()) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
		
	}//main
}//class
