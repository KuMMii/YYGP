package 백준;

import java.util.Scanner;

public class BOJ_2292_inseung {
	public static void main(String[] args) {
        // 한 원의 끝숫자: 1 7 19 37 61 // n번째 수 = 3n제곱 - 3n + 1 // n번째 수까지 출력= n   
	    // 등차:   		6 12 18 24 // n번째 수 = 6k // n번째까지 합 = 3n*(n+1)
	    // 
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    int n = 0;
	
	    while(true) {
		    int k = (int)(3 * Math.pow(n, 2) - 3 * n + 1);
		    int k2 = (int)(3 * Math.pow(n + 1, 2) - 3 * (n + 1) + 1);
		    if (N == 1) {
		    	break;
		    } else if (N > k && N <= k2) {
		    	break;
		    }
		    n++;
	    }
	    System.out.println(n+1);
	}
}