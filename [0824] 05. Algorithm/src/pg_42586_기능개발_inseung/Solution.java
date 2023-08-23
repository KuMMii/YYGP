package pg_42586_기능개발_inseung;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) {
		int[] a = {95, 90, 99, 99, 80, 99};
		int[] b = { 2, 1, 1, 1, 1, 1 };
//		int[] a = {95, 90, 99, 99, 80, 99};
//		int[] b = { 1, 1, 1, 1, 1, 1 };
//		int[] a = { 93, 30, 55 };
//		int[] b = { 1, 30, 5 };
		int[] ans = solution(a, b);
		System.out.println(Arrays.toString(ans));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		// 더 큰 숫자 나올때 까지의 개수를 더해줌 - days[] 배열이 [3 1 1 4 2 2 5 3] 이면 -> 답은 [3 3 2]

		Queue<Integer> q = new LinkedList<>();

		int[] days = new int[progresses.length]; // 며칠 걸리는지
		
		// days[i] : (남은 퍼센트 / 하루 작업 퍼센트) 를 반올림.
		//  round -> 반올림. floor -> 내림 (바닥으로 floor). ceil -> 올림 (천장으로 ceiling).
		for (int i = 0; i < progresses.length; i++) {
			days[i] = (int) (Math.ceil( (100 - progresses[i]) / (double) speeds[i]));
		}
		
		int max = days[0]; // 더 큰 숫자 나타나면 max에 저장
		int num = 1; // 그떄까지의 기능 개수를 num으로 세줄것임
		for (int i = 1; i < progresses.length; i++) {
			
			if (max < days[i]) { // 더 큰 숫자 나타나면
				max = days[i]; // max에 저장
				q.add(num); // 지금까지 센 num을 q에 추가
				num = 0; // num은 0으로 초기화
			}
			num++; // days[i]가 무슨 값이든, 기능 개수에 더해줌
			
			if (i == progresses.length - 1) { // 마지막 값 나타나면 그떄까지 센 num을 q에 추가 
				q.add(num);
			}
		}
		int N = q.size();
		int[] answer = new int[N]; // 같은 기능 배포일에 몇개씩 배포하는지 배열 
		for (int i = 0; i < N; i++) { // 아.. i < q.size() 하면 size가 계속 변하는구나 (똑같은 실수 한적 있음)
			answer[i] = q.poll();
		}
		return answer;
	}
}
