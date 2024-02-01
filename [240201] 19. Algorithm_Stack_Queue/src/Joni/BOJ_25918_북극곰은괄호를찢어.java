package BOJ_25918_북극곰은괄호를찢어;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String line = sc.next();
        char[] word = new char[N];
        for (int i = 0; i < N; i++) {
            word[i] = line.charAt(i);
        }

        Stack<Character> stack = new Stack<Character>();
        List<Integer> list = new ArrayList<>();
        // count = 일수 계산
        int count = 0;
        for (int i = 0; i < N; i++) {
            // stack이 비었으면 해당 괄호를 넣어주고 일 수 추가
            if (stack.isEmpty()) {
                stack.add(word[i]);
                count++;
            } else {
                // 같은 괄호라면 스택에 넣어추가 일 수 추가
                if (word[i] == stack.peek()) {
                    stack.add(word[i]);
                    count++;
                // 다른 괄호라면 스택에서 뺴고 일 수 감소
                } else {
                    stack.pop();
                    count--;
                }
            }
            // 반복하면서 일자 조회, 사실 여기서 Math.max로 계속 갱신해도됨.
            list.add(count);
        } // N번 반복 끝

        // 날짜 일수 최대값 갱신
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }
        
        // 만약 스택이 비어있지 않다면, 해당 경우는 짝수가 안맞거나 괄호를 못찢는 상황임.
        if (!stack.isEmpty()) {
            System.out.println(-1);
        } else {
            // 그 외 결과 출력
            System.out.println(max);
        }

    } // main
} // class
