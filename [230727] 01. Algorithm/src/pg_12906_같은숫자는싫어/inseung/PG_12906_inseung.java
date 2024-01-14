package pg_12906_같은숫자는싫어.inseung;

import java.util.LinkedList;
import java.util.Queue;

public class PG_12906_inseung {
	    public int[] solution(int[] arr) {
	        
	        Queue<Integer> q = new LinkedList<>();
	        q.offer(arr[0]);
	        int num = 1;
	        
	        for (int i = 1; i<arr.length; i++) {
	            if (arr[i] != arr[i - 1]) {
	                q.offer(arr[i]);
	                num++;
	            }
	        }

	        int[] answer = new int[num];
	        for (int i = 0; i<num; i++) {
	                answer[i] = q.poll();
	        }
	        
	        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//	        System.out.println(Arrays.toString(answer));

	        return answer;
	    }
}
