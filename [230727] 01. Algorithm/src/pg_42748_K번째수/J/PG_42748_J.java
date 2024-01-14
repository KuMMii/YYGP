package pg_42748_K번째수.J;

import java.util.Arrays;

public class PG_42748_J {

}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int T=commands.length; //실행 횟수
        int[] answer = new int[T];  //실행횟수길이로 배열 만들었음
        for(int r=0;r<T;r++) { 

        	int start=commands[r][0]-1;
        	int end=commands[r][1]-1;
        	int flag=commands[r][2]-1;
        	
        	int[] newList=new int[end-start+1]; //새로운 배열
        	
        	int idx=0;
        	for(int i=start;i<=end;i++) { 
        		 newList[idx++]=array[i];
        	}
        	
        	Arrays.sort(newList);
        	answer[r]=newList[flag];
        }
        return answer;
    }
}