package boj_11399.sy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//����� �� N
		int N = sc.nextInt();
		
		//���� �����ϴµ� �ɸ��� �ð� Pi�� �����ϱ� ���� �迭 ����
		int[] p = new int[N];
		for(int i = 0; i < N; i++) {
			p[i] = sc.nextInt();
		}
		
		//������ ����� ���� �Ǵ� p1 ~ pN������ ��
		//�� �ð��� ���� �۾����� ���ؼ��� �տ� ����� ���� ��ٷ����� -> �������� ����
		Arrays.sort(p);
		
		//1��° ����� ���� �ð���ŭ ��ٸ��� ����� n��
		//2��° ����� ���� �ð���ŭ ��ٸ��� ����� n-1��
		//... 
		int sum = 0;
		int n = N;
		for(int i = 0; i < N; i++) {
			sum += p[i] * n--; 
		}
		
		System.out.println(sum);
		
	}//main
}//class
