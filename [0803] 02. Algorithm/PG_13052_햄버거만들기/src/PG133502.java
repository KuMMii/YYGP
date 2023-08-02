import java.util.ArrayList;

public class PG133502 {
	public static void main(String[] args) {
		int[] ingredient = new int[] {1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1};
		
		int answer = 0;
		ArrayList<Integer> igd = new ArrayList<>();
        
        for(int i: ingredient) {
            igd.add(i);
        }
        
        for(int i = 0; i < igd.size()-3; i++) {
        	if(igd.get(i)==1 && igd.get(i+1)==2 && igd.get(i+2)==3 && igd.get(i+3)==1) {
        		for(int j = 1; j <= 4; j++) {
        			igd.remove(i);
        			
        		}
    			i = 0;
                answer++;
    			
        	}
        }

        System.out.println(answer);
		
		
	}
}
