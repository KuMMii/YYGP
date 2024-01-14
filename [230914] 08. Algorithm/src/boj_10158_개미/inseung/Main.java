package boj_10158_개미.inseung;

import java.util.Scanner;


// 시간 초과 -> 검색해서 x축 y축 따로 생각하라는 tip 보고 함
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 안쓰고 String split메서드로 바꿔봄
		String str = br.readLine();
		int w = Integer.parseInt(str.split(" ")[0]);
		int h = Integer.parseInt(str.split(" ")[1]);
		str = br.readLine();
		int p = Integer.parseInt(str.split(" ")[0]);
		int q = Integer.parseInt(str.split(" ")[1]);
		int t = Integer.parseInt(br.readLine());

		// 가로 위치 (2w 주기에서 남는 양 -> 그만큼을 가로위치에서 더해줌 -> 2w 넘는 경우 다시 남는 양 구함)
		int x = (p + t % (2 * w)) % (2 * w);
		int y = (q + t % (2 * h)) % (2 * h); // 세로 위치

		x = w - Math.abs(w - x); // 35-42줄을 if문 안쓰려면 일게 쓸수있음 (검색해봄..)
		y = h - Math.abs(h - y);
		
		
//		// 1234 3210 이 주기에서 3210 부분에 있으면, 아래와 같이 계산해줌
//		if (x > w) {
//			x = 2 * w - x;
//		}
//
//		if (y > h) {
//			y = 2 * h - y;
//		}

		bw.write(x + " " + y);
		
//		System.out.println(x + " " + y);

		bw.flush();
		bw.close();
	}
}

//public class Main {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int w = sc.nextInt(); // 격자 가로길이
//		int h = sc.nextInt(); // 격자 세로길이
//		int p = sc.nextInt(); // 가로위치
//		int q = sc.nextInt(); // 세로위치
//		int t = sc.nextInt(); // 몇번 움직이는지
//
//		// 가로 위치 (2w 주기에서 남는 양 -> 그만큼을 가로위치에서 더해줌 -> 2w 넘는 경우 다시 남는 양 구함)
//		int x = (p + t % (2 * w)) % (2 * w);
//		int y = (q + t % (2 * h)) % (2 * h); // 세로 위치
//
//		// 1234 3210 이 주기에서 3210 부분에 있으면, 아래와 같이 계산해줌
//		if (x > w) {
//			x = 2 * w - x;
//		}
//
//		if (y > h) {
//			y = 2 * h - y;
//		}
//
//		System.out.println(x + " " + y);
//	}
//
//}

//int x = 1; // 가로로 움직이는 양
//int y = 1; // 세로로 움직이는 양
//
//for(int i = 1; i<=t; i++) {
//
//	if (p == 0 || p == w) { // 가로 경계 만나면 x 부호 바뀜
//		x = -x;
//	}
//	if (q == 0 || q == h) { // 세로 경계 만나면 y 부호 바뀜
//		y = -y;
//	}
//	
//	p += x;
//	q += y;
//	
//}

