package boj_12789_도키도키_간식드리미;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	//왼쪽에 1열로 설 수 있는 공간 stack
	public static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//승환이 앞에 줄 서있는 학생들의 수 N
		int N = sc.nextInt();
		
		//승환이의 기분을 String 변수 mood로 설정 및 Nice로 초기화
		String mood = "Nice";
		//라인을 통과할 수 있는 번호 getNum 변수 설정 및 1로 초기화
		int getNum = 1;
		
		int idx = 0;
		//통과한 인원을 담기 위한 getPeople int배열 N의 크기로 생성
		int[] getPeople = new int[N];
		
		for(int i = 1; i <= N; i++) {
			//학생들의 번호표 순서대로 입력
			int num = sc.nextInt();
			//1. 라인을 통과할 수 있는 번호(getNum)와 번호표 번호(num)가 동일하면
			if(num == getNum) {
				//getPeople 배열에 추가
				getPeople[idx++] = num;
				//라인을 통과할 수 있는 번호 증가
				getNum++;
				//스택이 비어있지 않고, stack의 가장 위의 요소가 getNum과 동일하지 않아질 때까지
				while(!stack.isEmpty() && stack.peek() == getNum) {
					//스택에서 꺼내서 통과한 인원 getPeople에 넣고
					getPeople[idx++] = stack.pop();
					//라인을 통과할 수 있는 번호 증가
					getNum++;
				}
			//2. 번호표의 번호(num)와 라인을 통과할 수 있는 번호(getNum)가 일치하지 않으면
			}else if(num != getNum) {
				//스택이 비어있거나 stack의 가장 위의 번호보다 번호표 번호가 작으면
				if(stack.isEmpty() || stack.peek() > num) {
					//스택에 추가
					stack.add(num);
				//가장 위의 번호보다 번호표 번호가 크면
				}else if(stack.peek() < num) {
					//mood를 "Sad"로 바꾸고
					mood = "Sad";
					//반복문 종료
					break;
				}
			}//num, getNum
		}//i
		
		System.out.println(mood);
		
	}//main
}//class
