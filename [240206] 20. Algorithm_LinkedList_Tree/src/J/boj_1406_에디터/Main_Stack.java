package J.boj_1406_에디터;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main_Stack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // left에 쌓고 커서 옮길 때마다 right로 옮기기
        Stack<Character> leftSt = new Stack<>();
        Stack<Character> rightSt = new Stack<>();

        char[] charArray = br.readLine().toCharArray();

        for (char c : charArray) {
            leftSt.push(c);
        }


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            switch (cmd) {
                case 'P':
                    char alphabet = st.nextToken().charAt(0);
                    leftSt.push(alphabet);
                    break;
                case 'L':
                    if (!leftSt.isEmpty()) rightSt.push(leftSt.pop());
                    break;
                case 'D':
                    if (!rightSt.isEmpty()) leftSt.push(rightSt.pop());
                    break;
                case 'B':
                    if (!leftSt.isEmpty()) leftSt.pop();
                    break;
            }


        }

        // 왼쪽 스택은 출력의 반대 방향으로 쌓여있기 때문에 오른쪽으로 전부 옮겨줌
        while (!leftSt.isEmpty()) rightSt.push(leftSt.pop());

        // 오른쪽 스택의 것들을 전부 꺼내며 write
        while (!rightSt.isEmpty()) bw.write(rightSt.pop());


        bw.flush();
        bw.close();
    }

}
