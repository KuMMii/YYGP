package boj_1236_성지키기.j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int R,C,cnt=0;
        char[][] arr;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            arr[i]=br.readLine().toCharArray();
        }

        for (int cr = 0; cr < R; cr++) {
            for (int c = 0; c < C; c++) {
                if(arr[cr][c]=='X') continue;
            }

            outer2:for (int c = 0; c < C; c++) {
                for (int r = 0; r < R; r++) {
                    if(arr[r][c]=='X') continue ;
                }
                arr[cr][c]='X';
                cnt++;
                break;
            }


        }
        System.out.println(cnt);

    }//main
}
