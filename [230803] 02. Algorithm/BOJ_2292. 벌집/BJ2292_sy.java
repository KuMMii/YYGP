import java.util.Scanner;

public class BJ2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.close();
		
		int room = 1;
		int k = 0;
		int target = (6*k)+2;
		for(int i = 1; i <= N; i++) {
			if(i == target) {
				k++;
				target += 6*k;
				room++;
			}
		}
		System.out.println(room);
	
	}
}
