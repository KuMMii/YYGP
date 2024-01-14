package boj_2839;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//엄청 빨리 푼 사람의 답
public class Main2 {
	static int p5 = 5, p3 = 3, N, Ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		while(true) {
			if(N%5==0) {//N이 5의 배수일 때
				Ans+=(N/5);
				break;
			}else if(N<0) {//계속 빼다가 음수가 됐으면 -1 return
				//(N<5)가 아닌 이유 : 5보다 작아도 3의 배수일수도 있기 때문에 아예 답을 낼수 없는 음수일때 -1함
				Ans=-1;
				break;
			}
			N-=3; //계속해서 3을 빼줌
			Ans++; //그리고 Ans의 값은 1씩 늘림
		}

		System.out.println(Ans);
	}

}//class
