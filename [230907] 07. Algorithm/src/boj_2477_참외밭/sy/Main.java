package boj_2477_참외밭.sy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1m2당 참외의 개수
		int cnt = sc.nextInt();
		
		//주어지는 육각형 변의 길이를 담을 1차원 배열
		int[] arr = new int[6];
		//가장 긴 가로 길이 X, 가장 긴 세로 길이 Y, 해당 길이가 들어있는 index xIdx, yIdx
		int X = 0,  Y = 0;
		for(int i = 0; i < 6; i++) {
			//주어진 방향
			int dir = sc.nextInt();
			//변의 길이
			arr[i] = sc.nextInt();
			//남쪽, 북쪽 길이 중 최댓값과 해당 인덱스 구하기
			if((dir == 1 || dir == 2) && (X < arr[i])) {
				X = arr[i];
			}
			//동쪽, 서쪽 길이 중 최댓값과 해당 인덱스 구하기
			if((dir == 3 || dir == 4) && (Y < arr[i])) {
				Y = arr[i];
			}
		}//i
		
		//참외밭 면적
		int area = 0;
		//3번째, 6번째 입력된 길이를 제외하고 1, 2번째 3, 4번째 입력된 값을 이용하여 면적을 구하기
		//0*1과 3*4가 큰 사각형의 넓이가 아니면 두 사각형의 넓이를 더하고,
		if(arr[0] * arr[1] != X*Y && arr[3]*arr[4] != X*Y) {
			area = arr[0] * arr[1] + arr[3] * arr[4];
		//둘중 하나가 큰 사각형의 넓이라면, 나머지가 밭에서 제외되는 작은 사각형의 넓이가 되므로 빼기
		}else {
			area = Math.abs(arr[0] * arr[1] - arr[3] * arr[4]);
		}
		
		//참외의 개수 = 밭의 면적 * 1m2당 참외의 개수
		int N = area * cnt;
		
		System.out.println(N);

	}//main

}//class
