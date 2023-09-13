package boj_11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node{
	int value;
	public Node(int value) {
		this.value=value;
	}
}//Node

public class Main_pqByMyself{
	static int N,K,size=0;
	static Node[] heap;
	static final int PRIORITY=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); //amount of numbers
		K=Integer.parseInt(st.nextToken());//index
		
		
		heap=new Node[K+1];
		
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int tmp=Integer.parseInt(st.nextToken());
			if(size<K) {
				enqueue(tmp);
			}
		}
		
	}//main

	private static void enqueue(int tmp) {
		int idx=size;
		Node node=new Node(tmp);
		if(size==0) { //when the array is empty
			heap[PRIORITY]=node;
		}else {
			heap[idx]=node;
			int parentIdx=idx/2;
			while(idx>0 && heap[parentIdx].value<tmp) {
				swap(parentIdx,idx);
				idx=parentIdx;
				parentIdx=idx/2;
				System.out.printf("parentIdx=%d , idx=%d\n",parentIdx,idx);
				
				
			}//while
			//print~~
			for(int i=0; i<size;i++) {
				System.out.println(heap[i].value);
			}
		}
		size++;
	}//enqueue
	
	private static void swap(int fpos, int spos) {
		Node tmp=heap[fpos];
		heap[fpos]=heap[spos];
		heap[spos]=tmp;
	}
	
	
}//class
