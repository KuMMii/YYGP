package pg_12909_�ùٸ���ȣ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
	public static void main(String[] args) {
		solution("()()");
	}

	// ����ϱ� �ϴµ� ȿ�������� ������ Ǯ��
	static boolean solution(String s) {
		// String ss = s.substring(0,0); --> ���ڿ�("")�� ss�� �����
		int N = s.length()/2;
		for (int k = 1; k <= N; k++) { // ����: N ��� s.length()�� �ϴϱ� ��� ���� �޶����� �ݺ����� ���� ����
			int i = s.indexOf("()"); // ��ã���� -1 ����
			if (i == 0) {
				s = s.substring(2, s.length());
			} else if(i != -1) {
				s = s.substring(0,i) + s.substring(i+2, s.length());
			} else {
				return false;
			}
		}
		System.out.println("s");
		if (s.equals("")) {
			return true;
		} 
		return false;
	}
}


		
		
		//���� ���� Ǯ�� - ������ ()�� �����鼭 queue�� ��� �ֱ� �ݺ�
		
//		Queue<String> q = new LinkedList<>();
//		Queue<String> q2 = new LinkedList<>();
//		String[] array = s.split(""); // �ѱ��ھ� String �迭�� ����
//		for(int i = 0; i<q.size(); i++) {	// q�� ��ȣ �ϳ��� ����		
//			q.offer(array[i]);
//		}
////		System.out.println(Arrays.toString(array));
//		
//		while( !q.isEmpty() ) {
//			if (q.peek() == ) {
//				
//			}
//		}
//		
//	}
//}

// ����ϱ� �ϴµ� ȿ�������� ������ Ǯ��

//		Stack<String> stack = new Stack<>();
//		Queue<String> q = new LinkedList<>();
//		String[] array = s.split(""); // �ѱ��ھ� String �迭�� ����
//		System.out.println(Arrays.toString(array));
//
//		// array���̸�ŭ 0���� ������ �迭.
//		// ���� out�ȵ� ��ȣ ¦�� : 0
//		// out�� ��ȣ ¦�� : -1 �� ����
//		int[] count = new int[array.length];
//
//		// '('�� ')' ���� ������ ��
//		int num = 0;
//		for (int i = 0; i < array.length; i++) {
//			if (array[i].equals("(")) {
//				num += 1;
//			} else
//				num -= 1;
//		}
//		if (num != 0)
//			return false; // num�� 0�� �ƴϸ� ���� �ٸ� -> false
//
////		// �� �������� '('�� -> false
////		if (array[array.length - 1].equals("(")) return false;
//
//		for (int i = array.length - 2; i >= 0; i--) { // �ڿ������� '(' ã��
//			// ¦�� ��ȣ�� �ε����� �´� count�迭 -1 : ¦�� ��ȣ out
//			// out�� ¦�� ��ȣ�� ���� ����������, �ڿ������� �ٽ� '(' ã�Ƽ� �� ���Ŀ� ���� ')'�� ¦����
//			if (array[i].equals("(")) {
//				count[i]--;
//				for (int j = i + 1; j < array.length; j++) {
//					if (count[j] == 0) {
//						count[j]--;
//						break; // i ���� ���� ')'�� count[]���� -1 ����
//					}
//				}
//			}
//		}
//
//		System.out.println(Arrays.toString(count));
//
//		// count[]�� ��� ���� -1�̸� true, �ƴϸ� false
//		for (int i = 0; i < array.length; i++) {
//			if (count[i] != -1)
//				return false;
//		}
//		return true;
//
//	}
//}

//�������� ���ݰ� ������ Ǯ��

//////		
////		// wall = ������ '('�� ���° �ε�������
////		int wall = 0;
////		for (int i = array.length - 2; i >= 0; i--) { // �ڿ������� ã��
////			if (array[i].equals("(")) {
////				
//////				wall = i;
////				break;
////			}
////		}
////
////		// ������ '(' ��������, ���� stack��, �ڴ� q�� ����.
////		for (int i = 0; i <= wall; i++) {
////			stack.push(array[i]);
////		}
////		for (int i = wall + 1; i < array.length; i++) {
////			q.offer(array[i]);
////		}
////		
////		System.out.println(stack.toString());
////		System.out.println(q.toString());
////		
////		// stack, q ���� �ϳ� ��� - �ݺ��� ����
////		while (!stack.isEmpty()) {
////			// stack���� '(' ���� -> q���� ')' ���;� �� --
////			if (stack.peek().equals("(") && q.peek().equals(")")) {
////				stack.pop();
////				q.poll();
////				
////			// stack���� ')' ���� -> stack���� �״㿣 '(' ���;� �� - (�ƴϸ� false)
////			} else if (stack.peek().equals(")")) {
////				stack.pop();
////				if (stack.peek().equals(")")) {
////					stack.pop();
////				} else
////					return false;
////			}
////		}
////		
////		System.out.println(stack.toString());
////		System.out.println(q.toString());
////
////		// stack�� '(' ���Ҵµ� q�� ')'�� �� ������ (�ݴ� ��쵵 ��������) -> ��ȣ ������ ������ �ȸ��� -> false
////		if (!(stack.isEmpty() && q.isEmpty())) {
////			return false;
////		}
////
////		// return false �ȵǰ� ������� ������ �� true��
////		return true;
//	}
//}