package J.boj_2841;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int ans;
    static Stack<Integer> one,two,three,four,five,six;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());


        one = new Stack<>();
        two = new Stack<>();
        three = new Stack<>();
        four = new Stack<>();
        five = new Stack<>();
        six = new Stack<>();

        ans=0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int pret = Integer.parseInt(st.nextToken());

            switch (line) {
                case 1: count(one,pret); break;
                case 2: count(two,pret); break;
                case 3: count(three,pret); break;
                case 4: count(four,pret); break;
                case 5: count(five,pret); break;
                case 6: count(six,pret); break;

            }

        }
        System.out.println(ans);
    }

    private static void count(Stack<Integer> stack, int pret) {

        while (true){
//            System.out.println("stackWhile = " + stack);
//            System.out.println("pretWhile = " + pret);
            if (stack.size() < 1) {
                stack.add(pret);
                ans++;
                return;
            }
            int topNum = stack.peek();
            if (topNum ==pret) break;
            if (topNum < pret) {
                stack.add(pret);
                ans++;
                break;
            }

            stack.pop();
            ans++;

        }
    }
}
