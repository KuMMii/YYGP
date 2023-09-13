package swea_2930_힙;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/swea_2930_힙/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스 수
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			System.out.print("#" + tc + " ");
			//연산의 수
			int N = sc.nextInt();
			for(int i = 1; i <= N; i++) {
				int op = sc.nextInt();
				if(op == 1) {
					int x = sc.nextInt();
					pq.add(x);
				}else {
					if(pq.peek() == null) {
						System.out.print(-1 + " ");
					}else {
						System.out.print(pq.poll() + " ");						
					}
				}
			}//i
			System.out.println();
		}//tc
	}//main
}//class
