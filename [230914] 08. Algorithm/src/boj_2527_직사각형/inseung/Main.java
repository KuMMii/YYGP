package boj_2527_직사각형.inseung;

import java.util.Scanner;

//두 길이(최대-최소 x좌표) & (두 가로길이 합) 을 비교하면 되는구나!!
// 도저히 모르겠어서 기현이한테 결정적인 힌트 받고 품.
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int k = 1; k <= 4; k++) {
			
			int	min_x = 50000; 
			int	min_y = 50000;
			int	max_x = 0; // 제일 오른쪽에 있는 x좌표
			int	max_y = 0; // 제일 오른쪽에 있는 y좌표
			
			int[][] spot = new int[4][2]; // 한 행 - [x좌표, y좌표]
			for (int i = 0; i<4; i++) {
				for (int j = 0; j<2; j++) {
					spot[i][j] = sc.nextInt();
				}
				// max, min x,y 값 구함
				if (min_x > spot[i][0]) min_x = spot[i][0];
				if (max_x < spot[i][0]) max_x = spot[i][0];
				if (min_y > spot[i][1]) min_y = spot[i][1];
				if (max_y < spot[i][1]) max_y = spot[i][1];
			}
			
			
			int diff_x = max_x - min_x; // 오른쪽 끝 ~ 왼쪽 끝 x좌표 길이
			int diff_y = max_y - min_y; // 오른쪽 끝 ~ 왼쪽 끝 y좌표 길이

			int sum_x = spot[3][0] - spot[2][0] + spot[1][0] - spot[0][0]; //  두 가로길이의 합
			int sum_y = spot[3][1] - spot[2][1] + spot[1][1] - spot[0][1]; //  두 세로길이의 합
			
			char answer = 'd';
			
			
			
			if (diff_x == sum_x && diff_y == sum_y) answer = 'c';
			else if ((diff_x == sum_x && diff_y > sum_y) || (diff_x > sum_x && diff_y == sum_y)) answer = 'd';
			else if ((diff_x == sum_x && diff_y < sum_y) || (diff_x < sum_x && diff_y == sum_y)) answer = 'b';
			else if (diff_x < sum_x && diff_y < sum_y) answer = 'a';
			
			System.out.println(answer);		

		
			

		}
	}

}