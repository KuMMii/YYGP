package silver.boj_17952_과제는_끝나지_않아;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Assignment {
        int score;
        int min;

        public Assignment(int score, int min) {
            this.score = score;
            this.min = min;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Assignment now = new Assignment(0, 0);
        Stack<Assignment> rest = new Stack<>();

        int totalScore = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int info = Integer.parseInt(st.nextToken());
            if(info == 1 && now.min == 0) {
                int score = Integer.parseInt(st.nextToken());
                int min = Integer.parseInt(st.nextToken());
                now.score = score;
                now.min = min - 1;
            } else if(info == 1 && now.min != 0) {
                int score = Integer.parseInt(st.nextToken());
                int min = Integer.parseInt(st.nextToken());
                rest.add(new Assignment(now.score, now.min));
                now.score = score;
                now.min = min - 1;
                if(now.min == 0) {
                    totalScore += now.score;
                }
            } else if(info == 0 && now.min == 0) {
                if(!rest.isEmpty()) {
                    Assignment newOne = rest.pop();
                    now.score = newOne.score;
                    now.min = newOne.min - 1;
                    if(now.min == 0) {
                        totalScore += now.score;
                    }
                }
            } else if(info == 0 && now.min != 0) {
                now.min -= 1;
                if(now.min == 0) {
                    totalScore += now.score;
                }
            }
        }
        System.out.println(totalScore);
    }
}
