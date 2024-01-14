package 스터디;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	//프로그래머스엔 static 빼기
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> q = new LinkedList<>(); // 다리 지나는 트럭 무게를 q에 넣을것
		int w = 0; // 다리 지나는 트럭 총 무게
		int t = 0; // 경과 시간
		int[] m = new int[truck_weights.length]; // 트럭마다 간 거리
		int num = 0; // 다리 지난 트럭 개수
		int num2 = 0; // 다리 출발한 트럭 개수

		do {
			t += 1;
//			System.out.println("**************t=" + t);

			// 있던 트럭들은 앞으로 전진
			for (int i = num; i < num + q.size(); i++) {
				if (m[i] > 0 && m[i] <= bridge_length) {
					m[i] += 1;
//					System.out.println("m[i] = " + m[i]);
//					System.out.println("q size: " + q.size());
//					System.out.println("전진");
				}
				// bidge_length만큼 거리 지나면 - 다리에서 뺌
				if (m[i] > bridge_length) {
					w -= truck_weights[i];
					num++;
					q.poll();
//					System.out.println("q size: " + q.size());
//					System.out.println("뺌");
				}
			}

			// weight 안 넘으면 && 아직 출발 안한 트럭이면 - 다리 위 트럭 추가
			// (이걸 앞에 두면 출발하고 또 이동해서 뒤에 둠)
			if (num2 < truck_weights.length) {
				if (w + truck_weights[num2] <= weight && m[num2] == 0) {
					q.offer(truck_weights[num2]);
					w += truck_weights[num2];
					m[num2] += 1;
					num2++;
//					System.out.println("m[num]: " + m[num]);
//					System.out.println("num: " + num);
//					System.out.println("num2: " + num2);
//					System.out.println("q size: " + q.size());
//					System.out.println("출발\n");
				}
			}
		} while (num < truck_weights.length);

		int answer = t;
		return answer;
//		System.out.println(answer);
	}
}



public class PG_42583 {
	public static void main(String[] args) {
		int[] a = new int[] { 7, 4, 5, 6 };
		Solution.solution(2, 10, a);
	}
}
