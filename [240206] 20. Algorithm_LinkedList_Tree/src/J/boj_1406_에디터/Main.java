package J.boj_1406_에디터;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Character> linkedList = new LinkedList<>();
        char[] charArray = br.readLine().toCharArray();

        for (char c : charArray) {
            linkedList.add(c);
        }

        // iterator 메소드 호출
        ListIterator<Character> iter = linkedList.listIterator();

        // 커서를 맨 뒤로 움직이기
        while (iter.hasNext()) iter.next();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            switch (cmd) {
                case 'P':
                    char alphabet = st.nextToken().charAt(0);
                    iter.add(alphabet);
                    break;
                case 'L':
                    if (iter.hasPrevious()) iter.previous();
                    break;
                case 'D':
                    if (iter.hasNext()) iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
            }


        }

        for (Character c : linkedList) {
            bw.write(c);
        }

        bw.flush();
        bw.close();
    }

}
