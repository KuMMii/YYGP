package BOJ_2563;

import java.util.Scanner;

//3개 겹쳤을 때 안됨
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		int[][] arr=new int[N][4];
		
		int sum=0;
		
		//{가로 시작, 가로 끝, 세로 시작, 세로 끝}
		for(int n=0; n<N; n++) {
			arr[n][0]=sc.nextInt();
			arr[n][1]=arr[n][0]+10;
			arr[n][2]=sc.nextInt();
			arr[n][3]=arr[n][2]+10;
		}//for n
		
		for(int i=0; i<N; i++) {// 비교 지정
			for(int j=0; j<N; j++) {//다 돌림
				if(i!=j) {
					
					if((arr[i][0]<=arr[j][0] && arr[j][0]<arr[i][1]) &&
							((arr[i][2]<=arr[j][3] && arr[j][3]<arr[i][3]) ||
							(arr[i][2]<=arr[j][2] && arr[j][2]<arr[i][3]))) {
						sum+=(10-Math.abs(arr[j][0]-arr[i][0]))*(10-Math.abs(arr[i][3]-arr[j][3]));
					}//if
					
					if((arr[i][0]<arr[j][1] && arr[j][1]<arr[i][1]) &&
							((arr[i][2]<=arr[j][3] && arr[j][3]<arr[i][3]) ||
							(arr[i][2]<=arr[j][2] && arr[j][2]<arr[i][3]))) {
						
						sum+=(10-Math.abs(arr[j][0]-arr[i][0]))*(10-Math.abs(arr[i][3]-arr[j][3]));
					}//if
					
				}//if i!=j
			}//for j
		}//for i
		
		System.out.println(100*N-sum/2);
		
	}//main
}//class
