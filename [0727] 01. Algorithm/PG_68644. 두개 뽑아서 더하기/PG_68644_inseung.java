import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class PG_68644 {}

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> sum = new HashSet<>();
        for (int i = 0; i<numbers.length; i++) {
            for (int j = i + 1; j<numbers.length; j++) {
                sum.add(numbers[i] + numbers[j]);
            }
        }
        Integer[] answer_pre = sum.toArray(new Integer[sum.size()]);
        int[] answer = new int[sum.size()];
        for (int i = 0; i<sum.size(); i++) {
        	answer[i] = answer_pre[i].intValue();
        }
        Arrays.sort(answer);
        return answer;
    }
}
