package boj_2839.sy;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//��ĳ�ʸ� ����..
		sc.close();
		
		//1. 5�� ����� ��� 5kg¥���� ��� ��������
		if(N % 5 == 0) {
			System.out.println(N / 5);
		//2. 5�� �������� �� �������� 3�̸� ��ŭ 5kg¥���� �������� 3kg¥�� 1��
		}else if(N % 5 == 3) {
			System.out.println((N / 5) + 1);
		//3. 5�� �������� �� �������� 1�̸� ��-1��ŭ 5kg¥���� �������� 3kg¥�� 2��
		}else if(N % 5 == 1 && N / 5 >= 1) {
			System.out.println(((N / 5) - 1) + 2);
		//4. 5�� �������� �� �������� 4�̸� ��-1��ŭ 5kg¥���� �������� 3kg¥�� 3��
		}else if(N % 5 == 4 && N / 5 >= 1) {
			System.out.println(((N / 5) - 1) + 3);
		//5. 5�� �������� �� �������� 2�̸� ��-2��ŭ 5kg¥���� �������� 3kg¥�� 4��
		}else if(N % 5 == 2 && N / 5 >= 2){
			System.out.println(((N / 5) - 2) + 4);
		//6. �� �ܿ��� 5kg, 3kg¥���� ����� �Ұ���
		}else {
			System.out.println("-1");
		}
		
	}//main
}//class
