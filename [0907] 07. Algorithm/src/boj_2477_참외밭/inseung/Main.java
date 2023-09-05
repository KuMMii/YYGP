package boj_2477_참외밭.inseung;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1제곱미터 당 참외개수
		int[][] field = new int[6][2];
		int width = 0; // 가로 가장 긴변
		int widthIdx = -1; // 가로 가장 긴변의 i인덱스
		int length = 0; // 세로 가장 긴변
		int lengthIdx = -1; // 세로 가장 긴변의 i인덱스

		// 1,2 동쪽 서쪽 가장 긴변 찾기 / 3,4 남쪽 북쪽 가장 긴변 찾기 -> 이 긴변 두개는 서로 붙어있음.
		// 글구 이 긴변 2개와 또 붙어있는 다른 2개를 뺀 나머지 2개가 파먹힌 부분의 가로 세로 길이임

		// 가로, 세로 가장 긴변 찾음
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				field[i][j] = sc.nextInt();
			}
			// 가로 변 중에 제일 긴 변을 width에 저장, 그 인덱스를 widthIdx에 저장
			if ((field[i][0] == 1 || field[i][0] == 2) && field[i][1] > width) {
				width = field[i][1];
				widthIdx = i;
				// 세로 변 중에 제일 긴 변을 length에 저장, 그 인덱스를 lengthIdx에 저장
			} else if ((field[i][0] == 3 || field[i][0] == 4) && field[i][1] > length) {
				length = field[i][1];
				lengthIdx = i;
			}

		}

//		System.out.println(Arrays.deepToString(field));
//		System.out.println(width);
//		System.out.println(length);

		// 가로, 세로 가장 긴변 & 그 양옆 변의 i인덱스를 0으로 만들어줌
		// 인덱스0과 붙어있는 변이 인덱스5라서 이렇게 해줌
		field[widthIdx][0] = 0;
		field[lengthIdx][0] = 0;
		field[(widthIdx + 5) % 6][0] = 0;
		field[(lengthIdx + 5) % 6][0] = 0;
		field[(widthIdx + 7) % 6][0] = 0;
		field[(lengthIdx + 7) % 6][0] = 0;

		int eaten = 1; // 파먹힌 부분 넓이

		// i인덱스가 0이 아닌 행이 파먹힌 부분의 가로,세로 변임
		for (int i = 0; i < 6; i++) {
			if (field[i][0] != 0) {
				eaten *= field[i][1]; // 그 두 변을 곱해줘서 파먹힌 부분 넓이 구함
			}
		}

		// (가장 긴변 끼리 곱함 - 파먹힌 부분 넓이) * 1제곱미터 당 참외 개수
		System.out.println((width * length - eaten) * N);
	}

}
