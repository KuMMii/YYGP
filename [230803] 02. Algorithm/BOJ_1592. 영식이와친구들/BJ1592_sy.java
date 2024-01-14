
import java.util.Scanner;

public class BJ1592 {
	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		
		int[] ball = new int[N];
		int p = 0;
	

		for(ball[p] = 1; ball[p] != M; ++ball[p]) {
			if(ball[p] != M) {
				if(ball[p] % 2 == 1) {
					p += L;
					if(p >= N) {
						p -= N;
					}
				} else {
					p -= L;
					if(p < 0) {
						p += N;
					}
				} 
			} else
				break;	
		}
		
		int sum = 0;
		for(int i = 0; i < N ; i++) {
			sum += ball[i];
		}
		
		System.out.println(sum-1);
	}
}







































