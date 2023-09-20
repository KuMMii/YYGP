package boj_11399.ryu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		arr = Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		
		int ans = 0;
		int prev = 0;
		for (int i=0; i<N; i++) {
			ans += prev + arr[i];
			prev += arr[i];
		}
		System.out.println(ans);
	}

}
