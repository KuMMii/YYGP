package YYP.boj_2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class boj_2798{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] NandM=br.readLine().split(" ");
        String[] cardStr=br.readLine().split(" "); //우선 String으로 받음
        int[] cards=new int[cardStr.length];
        for(int i=0; i<cards.length;i++) {
        	cards[i]=Integer.parseInt(cardStr[i]); //int 배열 만들어서 바꿈
        }
        
        Arrays.sort(cards); //오름차순으로 정렬해서 뒤에서 큰숫자부터 더해볼거임
        int max=0; //최대값 계속 비교하게 할 변수
        for(int i=cards.length-1;i>=0;i--){ //맨 뒤에서부터 도는애1
            for(int j=i-1;j>=0;j--){ 
            	//두번째 숫자. 얘는 i보다 큰값은 돌 필요가 없어서 i보다 작은 수부터 인덱스 0까지 돔
                if(j!=i){ // 빼도 될듯 이 코드는 옛날에 넣은 코드임
                    for(int k=j-1; k>=0; k--){ //세번째 숫자. 얘도 j보다 큰수는 돌 필요없음
                        if(k!=i && k!=j){
                        	int a=cards[i];
                        	int b=cards[j];
                        	int c=cards[k];
                        	int sum=a+b+c; //원래라면 한방에 쓸텐데 디버깅때매 다 변수로 만들어줌
                        	int target=Integer.parseInt(NandM[1]);
//                            if(sum<=target){
//                                System.out.println(cards[i]+cards[j]+cards[k]);
//                                return;
//                            }
                        	//원래는 이렇게 풀었는데 틀림; 왜틀렸는지 모르겠음 도와줘요 스터디원들~!
                        	//가장 큰수들부터 돌려서 더하면 제일먼저 타겟값보다 작아지는 값이 가장 큰거 아님?
                        	if(sum<=target && sum>max){
                            	max=sum; //계속 저게 틀려서 max변수를 비교후 바꾸는 방식으로 하니까 맞음
                            }
                        }
                    }
                }
            }    
        }
        System.out.println(max);
    }
}