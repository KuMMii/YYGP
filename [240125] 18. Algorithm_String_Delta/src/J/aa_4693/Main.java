package J.aa_4693;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] CR = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] CC = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[][] arr;
    static boolean[][] flag;
    static int R,C;
    static List<Integer> ansList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String command = br.readLine();
            if (command.equals("0 0")) break;

            StringTokenizer st = new StringTokenizer(command);
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            arr = new int[R][C];
            flag = new boolean[R][C];

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                int j=0;
                while (st.hasMoreTokens()&&j<C) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    j++;
                }
            }

            // input fin

            int ans=0;

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (arr[r][c] == 1 && flag[r][c] == false) {
                        flag[r][c]=true;
                        bfs(r, c);
                        ans++;
                    }
                }
            }

            ansList.add(ans);


        }//while

        for (Integer integer : ansList) {
            System.out.println(integer);
        }
    }//main

    private static void bfs(int r, int c) {
        for (int i = 0; i < 8; i++) {
            int cr = r + CR[i];
            int cc = c + CC[i];
            if ((0<=cr&&cr<R) && (0<=cc&&cc<C)) {

                if (arr[cr][cc] == 1 && flag[cr][cc] == false) {
                    flag[cr][cc] = true;
                    bfs(cr, cc);
                }
            }
        }
        return;
    }
}
