package pg_12909_올바른괄호;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
	public static void main(String[] args) {
		solution("()()");
	}

	// 통과하긴 하는데 효율성에서 실패한 풀이
	static boolean solution(String s) {
		// String ss = s.substring(0,0); --> 빈문자열("")이 ss에 저장됨
		int N = s.length()/2;
		for (int k = 1; k <= N; k++) { // 주의: N 대신 s.length()로 하니까 계속 값이 달라져서 반복문이 일찍 끝남
			int i = s.indexOf("()"); // 못찾으면 -1 리턴
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


		
		
		//구현 실패 풀이 - 연속한 ()를 버리면서 queue에 계속 넣기 반복
		
//		Queue<String> q = new LinkedList<>();
//		Queue<String> q2 = new LinkedList<>();
//		String[] array = s.split(""); // 한글자씩 String 배열에 저장
//		for(int i = 0; i<q.size(); i++) {	// q에 괄호 하나씩 넣음		
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

// 통과하긴 하는데 효율성에서 실패한 풀이

//		Stack<String> stack = new Stack<>();
//		Queue<String> q = new LinkedList<>();
//		String[] array = s.split(""); // 한글자씩 String 배열에 저장
//		System.out.println(Arrays.toString(array));
//
//		// array길이만큼 0으로 구성된 배열.
//		// 아직 out안된 괄호 짝꿍 : 0
//		// out된 괄호 짝꿍 : -1 될 예정
//		int[] count = new int[array.length];
//
//		// '('랑 ')' 개수 같은지 봄
//		int num = 0;
//		for (int i = 0; i < array.length; i++) {
//			if (array[i].equals("(")) {
//				num += 1;
//			} else
//				num -= 1;
//		}
//		if (num != 0)
//			return false; // num이 0이 아니면 개수 다름 -> false
//
////		// 맨 마지막이 '('면 -> false
////		if (array[array.length - 1].equals("(")) return false;
//
//		for (int i = array.length - 2; i >= 0; i--) { // 뒤에서부터 '(' 찾음
//			// 짝꿍 괄호의 인덱스에 맞는 count배열 -1 : 짝꿍 괄호 out
//			// out된 짝꿍 괄호는 빼고 생각했을때, 뒤에서부터 다시 '(' 찾아서 그 직후에 나온 ')'가 짝꿍임
//			if (array[i].equals("(")) {
//				count[i]--;
//				for (int j = i + 1; j < array.length; j++) {
//					if (count[j] == 0) {
//						count[j]--;
//						break; // i 직후 나온 ')'만 count[]에서 -1 해줌
//					}
//				}
//			}
//		}
//
//		System.out.println(Arrays.toString(count));
//
//		// count[]의 모든 값이 -1이면 true, 아니면 false
//		for (int i = 0; i < array.length; i++) {
//			if (count[i] != -1)
//				return false;
//		}
//		return true;
//
//	}
//}

//망했음을 깨닫고 중지한 풀이

//////		
////		// wall = 마지막 '('이 몇번째 인덱스인지
////		int wall = 0;
////		for (int i = array.length - 2; i >= 0; i--) { // 뒤에서부터 찾음
////			if (array[i].equals("(")) {
////				
//////				wall = i;
////				break;
////			}
////		}
////
////		// 마지막 '(' 기준으로, 앞은 stack에, 뒤는 q에 넣음.
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
////		// stack, q 둘중 하나 비면 - 반복문 나옴
////		while (!stack.isEmpty()) {
////			// stack에서 '(' 나옴 -> q에서 ')' 나와야 함 --
////			if (stack.peek().equals("(") && q.peek().equals(")")) {
////				stack.pop();
////				q.poll();
////				
////			// stack에서 ')' 나옴 -> stack에서 그담엔 '(' 나와야 함 - (아니면 false)
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
////		// stack에 '(' 남았는데 q에 ')'가 더 없으면 (반대 경우도 마찬가지) -> 괄호 두종류 개수가 안맞음 -> false
////		if (!(stack.isEmpty() && q.isEmpty())) {
////			return false;
////		}
////
////		// return false 안되고 여기까지 왔으면 넌 true다
////		return true;
//	}
//}