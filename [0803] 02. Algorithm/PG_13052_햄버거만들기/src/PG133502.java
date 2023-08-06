import java.util.ArrayList;

public class PG133502 {
	public static void main(String[] args) {
		int[] ingredient = new int[] {1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1};
		
		int answer = 0;
		ArrayList<Integer> igd = new ArrayList<>();
        
        for(int i: ingredient) {
            igd.add(i);
        }
        
        for(int i = 3; i < igd.size(); i++) {
//        	System.out.println("i=" + i);
        	if(i >= 3 && igd.get(i)==1 && igd.get(i-1)==3 && igd.get(i-2)==2 && igd.get(i-3)==1) {
        		
        		igd.remove(i);
        		igd.remove(i-1);
        		igd.remove(i-2);
        		igd.remove(i-3);
    			i -= 3;
                answer++;
    			
        	}
        }

        System.out.println(answer);
		
		
	}
}
