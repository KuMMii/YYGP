package YYP.PG_134240;

public class PG_134240 {

}
class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        
        int[] idx=new int[food.length-1];
        for(int i=1; i<food.length;i++) {
        	idx[i-1]=food[i];
        	
        	if(idx[i-1]!=0) {
        		for(int j=0;j<(int)idx[i-1]/2;j++) {
        			answer+=(i+"");
        		}
        	}
        }
        String rev="";
        
        for(int i=0; i<answer.length();i++){
            rev=answer.charAt(i)+rev;
        }
        answer+="0"+rev;
        
        if(answer.length()>=3) {
        	
        	return answer;
        }
        return null;
    }
}