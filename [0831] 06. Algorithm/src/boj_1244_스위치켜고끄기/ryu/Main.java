package boj_1244_스위치켜고끄기.ryu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine()); // N<=100
		int[] power = new int[N+1];
		String[] powerLine = bf.readLine().split(" ");
		for (int i=1; i<=N; i++) {
			power[i] = Integer.parseInt(powerLine[i-1]);
		}
		int M = Integer.parseInt(bf.readLine()); // M<=100
		
		for (int m=0; m<M; m++) {
			String[] line = bf.readLine().split(" ");
			boolean isMan;
			int num;
			
			isMan = line[0].equals("1");
			num = Integer.parseInt(line[1]);
			
			if (isMan) {
				int curr = num;
				int i = 1;
				while (curr*i <= N) {
					power[curr*i] = 1-power[curr*i];
					i++;
				}
				
			} else {
				int curr = num;
				power[curr] = 1-power[curr];
				
				int i = 1;
				while (curr-i >= 1 && curr+i <= N) {
					if (power[curr-i] != power[curr+i]) break;
					power[curr-i] = 1-power[curr-i];
					power[curr+i] = 1-power[curr+i];
					i++;
				}
			}
		}
		
		for (int i=1; i<=N; i++) {
			if (i%20==0) {
				System.out.println(power[i]);
			} else {
				System.out.print(power[i]+" ");
			}
		}
	}

}
