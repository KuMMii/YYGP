package YYP.PG_134240;

public class wrong {

}
class Solution {
    public String solution(int[] food) {
        String answer = "";
        int one=0;
        int two=0;
        int three=0;
        int four=0;
        int five=0;
        int six=0;
        int seven=0;
        int eight=0;
        
        
        
        int[] idx=new int[food.length-1];
        for(int i=1; i<food.length;i++) {
        	idx[i-1]=food[i];
        }
        
        if(food[1]!=0) {one=(int)food[1]/2;}
        if(food[2]!=0) {two=(int)food[2]/2;}
        if(food[3]!=0) {three=(int)food[3]/2;}
        String rev="";
        
        for(int i=0;i<one;i++){
            answer+="1";
        }
        for(int i=0;i<two;i++){
            answer+="2";
        }
        for(int i=0;i<three;i++){
            answer+="3";
        }
        for(int i=0;i<four;i++){
        	answer+="4";
        }
        for(int i=0;i<five;i++){
        	answer+="5";
        }
        for(int i=0;i<six;i++){
        	answer+="6";
        }
        for(int i=0;i<seven;i++){
        	answer+="7";
        }
        for(int i=0;i<eight;i++){
        	answer+="8";
        }
        
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