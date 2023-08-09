package boj_2460_ryu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int people = 0;
		int max = 0;
		for (int i=0; i<10; i++) {
			String[] s = bf.readLine().split(" ");
			// people += dpeople
			people += Integer.parseInt(s[1]) - Integer.parseInt(s[0]);
			if (people > max) max = people;
		}
		System.out.println(max);
	}
}
