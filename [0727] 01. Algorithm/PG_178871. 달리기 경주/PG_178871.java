import java.util.Arrays;

public class PG_178871 {

    public static void main(String[] args) {
    	String[] players = new String[] {"mumu", "soe", "poe", "kai", "mine"};
    	String[] callings = new String[] {"kai", "kai", "mine", "mine"};
    	
    	// answer 배열을 player와 동일 크기로 생성 % 복사
    	String[] answer = new String[players.length];
        for (int i = 0; i < players.length; i++) {
            answer[i] = players[i];
        }
        
        // callings와 player를 이중for문으로 반복
        // callings의 요소와 players p번째의 요소가 같으면 answer의 p번째 요소와 p-1번째 요소를 교체
        // 시간초과....
        for(int c = 0; c < callings.length; c++) {
            for(int p = 0; p < players.length; p++) {
                if(callings[c].equals(players[p])) {
                    answer[p-1] = players[p];
                    answer[p] = players[p-1];
                    for (int i = 0; i < players.length; i++) {
                    	players[i] = answer[i];
                    }
                   
                }
            }
        }
        System.out.println(Arrays.toString(answer));
       
	}
}
