package YYP.PG_160586;

public class PG_160586 {
    public int[] solution(String[] keymap, String[] targets) {
    	
    	
    	int[] answer = new int[targets.length];
       
        
        String[] alphabet; //알파벳 split해서 담을 예정
        int num; //인덱스
        
        
        for(int i=0; i<targets.length;i++){ //targets 길이 만큼 돌림
        	alphabet=new String[targets[i].length()];
            alphabet=targets[i].split("");
            num=-1;
            for(int j=0; j<alphabet.length; j++){ // alphabet 길이 만큼 돌림
                for(int k=0; k<keymap.length;k++){
                    if(keymap[k].contains(alphabet[j])){ //알파벳 있는 경우만 알아볼거임
                        
                        int idx=keymap[k].indexOf(alphabet[j]);
                        
                        if(idx==0){//맨첫 인덱스에 있을 때
                           num=1;
                            break;
                        }else if(idx>0){
                            if(num>idx){
                                num=idx;
                            }else{
                                break;
                            }
                        }
                    }
                    answer[i]+=num;
                }
                
            }
            
        }
        
        
        return answer;
    }
		
		
}
