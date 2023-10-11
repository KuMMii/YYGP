package boj_5373.ryu;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[][] back = new int[3][3];
		int data = 1;
		for (int r=0; r<3; r++) {
			for (int c=0; c<3; c++) {
				back[r][c] = data;
				data++;
			}
		}
		
		//해당 면도 수정해줘야 함
		for (int k=0; k<3; k++) {
			int[] temp = new int[] {back[0][0], back[0][1]};
			for (int i=0; i<2; i++) {
				back[0][i] = back[2-i][0];
				back[2-i][0] = back[2][2-i];
				back[2][2-i] = back[i][2];
				back[i][2] = temp[i];
			}
		}
		
		System.out.println(Arrays.deepToString(back));
	}
}
