package YYP.boj_2309;

import java.util.*;

class boj_2309{
	public static void main(String[] args) {
			
	    Scanner sc=new Scanner(System.in);
	    List<Integer> list=new ArrayList<>();
	    for(int i=0; i<9; i++){
	    	System.out.println("입력 : ");
	        list.add(sc.nextInt());
	    }
	    
	    int sum=0;
	    
	    for(int i:list){
	        sum+=i;
	    }
	    
	    System.out.println("sum:"+sum);
	    int target=sum-100;
	    System.out.println("target:"+target);
	    
	    Collections.sort(list);
	    for(int i=0;i<list.size();i++){
        	if(list.contains(target-list.get(i))&&list.indexOf(target-list.get(i))!=i) {
        		
	            int tmp=list.get(i);
	            list.remove(Integer.valueOf(tmp));
	            list.remove(Integer.valueOf(target-tmp));
	            break;
        	}
	    }
	    
	    for(int n:list){
            System.out.println(n);
        }
	    
	}
    
}