package boj_14696_딱지놀이.inseung;

import java.util.Scanner;

public class BOJ_14696_inseung {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        //a,b 1~4 숫자 일단 각각 배열에 넣음
        for(int i = 0; i<N; i++) {
            int a = sc.nextInt();
            int[] array_a = new int[a];
            for(int j = 0; j<a; j++) {
            	array_a[j] = sc.nextInt();
            }
            
            int b = sc.nextInt();
            int[] array_b = new int[b];
            for(int j = 0; j<b; j++) {
                array_b[j] = sc.nextInt();
            }
            
          //4, 3, 2, 1 숫자 개수를 배열에 순서대로 넣음
            int[] num_a = new int[4];
            for(int j = 0; j<a; j++) {
                if (array_a[j] == 4) {
                    num_a[0] += 1;
                } else if (array_a[j] == 3) {
                    num_a[1] += 1;
                } else if (array_a[j] == 2) {
                    num_a[2] += 1;
                } else if (array_a[j] == 1) {
                    num_a[3] += 1;
                }
            }
            
            int[] num_b = new int[4];
            for(int j = 0; j<b; j++) {
                if (array_b[j] == 4) {
                    num_b[0] += 1;
                } else if (array_b[j] == 3) {
                    num_b[1] += 1;
                } else if (array_b[j] == 2) {
                    num_b[2] += 1;
                } else if (array_b[j] == 1) {
                    num_b[3] += 1;
                }
            }
            
            //승패 비교
            if (num_a[0] > num_b[0] ) {
                System.out.println("A");
            } else if (num_a[0] < num_b[0] ) {
                System.out.println("B");
            } else if (num_a[0] == num_b[0] ) {
            	
                if (num_a[1] > num_b[1] ) {
                    System.out.println("A");
                } else if (num_a[1] < num_b[1] ) {
                    System.out.println("B");
                } else if (num_a[1] == num_b[1] ) {
                	
                    if (num_a[2] > num_b[2] ) {
                        System.out.println("A");
                    } else if (num_a[2] < num_b[2] ) {
                        System.out.println("B");
                    } else if (num_a[2] == num_b[2] ) {
                    	
                        if (num_a[3] > num_b[3] ) {
                        	System.out.println("A");
                        } else if (num_a[3] < num_b[3] ) {
                        	System.out.println("B");
                        } else if (num_a[3] == num_b[3] ) {
                    	
                        	System.out.println("D");
                        }
                    }
                }
            }
        }
	}
}
