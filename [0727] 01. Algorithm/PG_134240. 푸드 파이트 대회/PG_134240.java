package YYP.PG_134240;

public class PG_134240 {

}
class Solution {
    public String solution(int[] food) {
        String answer = "";
        int one=0;
        int two=0;
        int three=0;
        
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
        
        for(int i=0; i<answer.length();i++){
            rev=answer.charAt(i)+rev;
        }
        answer+="0"+rev;
        
        
        
        return answer;
    }
}