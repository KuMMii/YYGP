package boj_1244_스위치켜고끄기.j;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();//스위치 개수
		int[] arr=new int[N+1]; //인덱스때매 한개 더 크게
		
		//스위치 담기
		for(int n=1; n<=N; n++) { //인덱스 1부터 넣기
			arr[n]=sc.nextInt();
		} //for n
		
		int P=sc.nextInt(); //사람수
		
		for(int p=0; p<P; p++) {
			int gen=sc.nextInt(); //여자남자 구분
			int num=sc.nextInt(); //받은 숫자
			
			switch(gen) {
			
			case 1 : //남자면
				for(int i=1; i<=N; i++) {
					if(i%num==0) {//받은 숫자의 배수면
						arr[i]=(arr[i]+1)%2;//스위치 전환
					}//if
				}//for i
				break;
			case 2 : //여자면
				arr[num]=(arr[num]+1)%2;//받은 숫자 스위치 전환
				for(int i=1; i<=N/2; i++) { //이제 양옆 스위치 확인
					//양옆으로 범위에 벗어나지 않고, 스위치 상태가 대칭이면
					if(num+i<=N && num-i>=1 && arr[num+i]==arr[num-i]) {
						arr[num+i]=(arr[num+i]+1)%2;
						arr[num-i]=(arr[num-i]+1)%2;
					}else {
						break;
					}
				}//for i
				break;
			}//switch
		}//for p
		
		//출력
		for(int i=1; i<=N; i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0) System.out.println();
		}
		System.out.println();
	}//main

}//class
