package YYP.bj_1592;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1592 {
	public static void main(String[] args) throws IOException{
	    	
	        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	        String[] strArr=br.readLine().split(" ");
	        int M=Integer.parseInt(strArr[0]); //사람
	        int N=Integer.parseInt(strArr[1]); //값
	        int L=Integer.parseInt(strArr[2]); //칸
	        
	        int[] arr=new int[M];
	        
	        int cnt=0;
	        int idx=0;
	        while(true){
	        	
	        	if(arr[idx]%2==1) { //홀수일때 시계방향
	        		idx+=L;
		            if((idx) > (M-1)){
		                idx=idx%M;
		            }
	        	}else { //짝수일때 반시계
	        		idx-=L;
	        		if((idx) <0){
	        			idx=M+idx;
	        		}
	        		
	        	}
	            arr[idx]++;
	            for(int i=0; i<arr.length;i++) {
	            	if(arr[i]==N) {
	            		System.out.println(cnt);
 	            		return;
	            	}
	            }
	            cnt++;
	        }
	    }
	    
}

