package boj_1158.inseung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 숫자 개수
		int K = sc.nextInt(); // K번째 숫자 제거
		Queue<Integer> q1 = new LinkedList<>(); // 숫자 왔다갔다 할 큐
		Queue<Integer> q2 = new LinkedList<>(); // 출력할 큐
		//일단 q1에 다 넣음
		for (int i = 1; i <= N; i++) {
			q1.offer(i);
		}
		// q1에 숫자 없어질 때까지 반복
		while (q1.size() != 0) {
			// K-1개만큼 q1 맨앞에서 꺼내서 q1 맨뒤로 넣음
			for (int i = 1; i < K && q1.size() != 0; i++) {
				q1.offer(q1.poll());
			}
			// K번째 숫자는 q1맨앞에서 꺼내서 q2에 넣음
			q2.offer(q1.poll());
			
		}
		int size = q2.size(); // q2 size만큼 숫자 출력할거임
		System.out.print("<");
		for (int i = 1; i < size; i++) {
			System.out.print(q2.poll() + ", ");
		}
		System.out.print(q2.poll() + ">"); // 마지막 숫자는 콤마 없이 출력
	}
}
