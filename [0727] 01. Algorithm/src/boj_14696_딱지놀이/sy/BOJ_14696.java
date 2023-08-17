package boj_14696_딱지놀이.sy;

import java.util.Scanner;

public class BOJ_14696 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N >= 1 && N <= 1000)
			for (int num = 1; num <= N; num++) {
				int a = sc.nextInt();
				int[] arrA1 = new int[a];
				if (a >= 1 && a <= 100) {
					for (int i = 0; i < a; i++) {
						arrA1[i] = sc.nextInt();
					}
				}

				int[] arrA2 = new int[4];
				for (int i = 0; i < arrA1.length; i++) {
					for (int j = 0; j < arrA2.length; j++) {
						if ((j + 1) == arrA1[i]) {
							arrA2[j]++;
						}
					}
				}
//				System.out.println(Arrays.toString(arrA2));

				int b = sc.nextInt();
				int[] arrB1 = new int[b];
				if (b >= 1 && b <= 100) {
					for (int i = 0; i < b; i++) {
						arrB1[i] = sc.nextInt();
					}

				}

				int[] arrB2 = new int[4];
				for (int i = 0; i < arrB1.length; i++) {
					for (int j = 0; j < arrB2.length; j++) {
						if ((j + 1) == arrB1[i]) {
							arrB2[j]++;
						}
					}
				}
//				System.out.println(Arrays.toString(arrB2));

				for (int i = 3; i >= 0; i--) {
					if (arrA2[i] != arrB2[i]) {
						if (arrA2[i] > arrB2[i]) {
							System.out.println("A");
							break;
						} else if (arrA2[i] < arrB2[i]) {
							System.out.println("B");
							break;
						}
					} else if (arrA2[i] == arrB2[i]) {
						if (i != 0) {
							continue;
						} else {
							System.out.println("D");
						}
					}
				}

			}
	}

}

