package boj_11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	static int N,K,size=0;
	static PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); //amount of numbers
		K=Integer.parseInt(st.nextToken());//index
		
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int tmp=Integer.parseInt(st.nextToken());
			if(size==0) {
				pq.add(tmp);
				size++;
			}
			else {
				if(size<K) {
					pq.add(tmp);
					size++;
				}
				else {
					if(tmp<pq.peek()) {
						pq.remove();
						size--;
						pq.add(tmp);
						size++;
					}
				}
				
			}
		}//for i
		
		System.out.println(pq.peek());
		
		
	}//main
	
	
}//class
