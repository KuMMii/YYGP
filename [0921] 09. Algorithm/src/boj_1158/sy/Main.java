package boj_1158.sy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N���� ��� ������ �ɱ�
		int N = sc.nextInt();
		//K��° ��� ����
		int K = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		
		//N���� ��� ��� queue�� �ֱ�
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		System.out.print("<");
		
		//ť�� �� ������ �ݺ�
		while(!queue.isEmpty()) {
			//1��° ������� K-1���� ������� ť���� ���� �ٽ� �ֱ�
			for(int i = 1; i < K; i++) {
				queue.add(queue.poll());
			}
			//K��° ����� ���
			System.out.print(queue.poll());
			if(!queue.isEmpty()) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
		
	}//main
}//class
