package boj_2941_크로아티아알파벳.sy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static Stack<String> alphabet = new Stack<>();
	public static Map<String, String> cro = new HashMap<>();
	static {
		cro.put("c=", "1");
		cro.put("c-", "2");
		cro.put("dz=", "3");
		cro.put("d-", "4");
		cro.put("lj", "5");
		cro.put("nj", "6");
		cro.put("s=", "7");
		cro.put("z=", "8");
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] str = sc.next().split("");
		
		for(int i = 0; i < str.length; i++) {
			if(!(str[i].equals("=")) && !(str[i].equals("-")) && !(str[i].equals("j"))) {
				alphabet.push(str[i]);
				
			}else if(!(alphabet.isEmpty()) && str[i].equals("-") && (alphabet.peek().equals("c") || alphabet.peek().equals("d"))) {
				String key = alphabet.pop() + str[i];
				alphabet.push(cro.get(key));
				
			}else if(!(alphabet.isEmpty()) && str[i].equals("j") && (alphabet.peek().equals("l") || alphabet.peek().equals("n"))) {
				String key = alphabet.pop() + str[i];
				alphabet.push(cro.get(key));
				
			}else if(!(alphabet.isEmpty()) && str[i].equals("=") && (alphabet.peek().equals("c") || alphabet.peek().equals("s"))) {
				String key = alphabet.pop() + str[i];
				alphabet.push(cro.get(key));
			}else if(!(alphabet.isEmpty()) && str[i].equals("=") && alphabet.peek().equals("z")) {
				String temp = alphabet.pop();
				String key;
				if(!(alphabet.isEmpty()) && alphabet.peek().equals("d")) {
					key = alphabet.pop() + temp + str[i];
				} else {
					key = temp + str[i];
				}
				alphabet.push(cro.get(key));

			}else {
				alphabet.push(str[i]);
			}	
		}
		System.out.println(alphabet.size());
//		
	}//main
}//class
