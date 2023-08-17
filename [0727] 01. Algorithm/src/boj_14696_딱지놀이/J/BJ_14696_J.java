package boj_14696_딱지놀이.J;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_14696_J {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(bf.readLine());
		
		
		for(int ts=0; ts<T;ts++) {
			
			int aCnt4=0;
			int aCnt3=0;
			int aCnt2=0;
			int aCnt1=0;
			
			int bCnt4=0;
			int bCnt3=0;
			int bCnt2=0;
			int bCnt1=0;
			
//			System.out.println("A입력 수 : ");
//			int a=Integer.parseInt(bf.readLine());
			String[] strArr=bf.readLine().split(" ");
			int a=Integer.parseInt(strArr[0]);
			int[] aArr=new int[a];
			for(int i=1; i<=a;i++) {
				
//				System.out.println("A카드 입력하기");
				aArr[i-1]=Integer.parseInt(strArr[i]);
			}
			
			
			for(int i=0; i<a;i++) { //무늬 카운트
				if(aArr[i]==4) {
					aCnt4++;
				}else if(aArr[i]==3) {
					aCnt3++;
				}else if(aArr[i]==2) {
					aCnt2++;
				}else {
					aCnt1++;
				}
			}
//			System.out.printf("A : %d %d %d %d\n", aCnt4,aCnt3,aCnt2, aCnt1);
//			System.out.println("B입력 수 : ");
//			int b=Integer.parseInt(bf.readLine());
			strArr=bf.readLine().split(" ");
			int b=Integer.parseInt(strArr[0]);
			int[] bArr=new int[b];
			
			for(int i=1; i<=b;i++) {
				
//				System.out.println("B카드 입력하기");
				bArr[i-1]=Integer.parseInt(strArr[i]);
			}
			
			for(int i=0; i<b;i++) { //무늬 카운트
				if(bArr[i]==4) {
					bCnt4++;
				}else if(bArr[i]==3) {
					bCnt3++;
				}else if(bArr[i]==2) {
					bCnt2++;
				}else {
					bCnt1++;
				}
			}
			
//			System.out.printf("B: %d %d %d %d\n", bCnt4,bCnt3,bCnt2, bCnt1);
			
			//비교
			if(aCnt4>bCnt4) {
				System.out.println("A");
			}else if(aCnt4<bCnt4) {
				System.out.println("B");
			}else {
				if(aCnt3>bCnt3) {
					System.out.println("A");
				}else if(aCnt3<bCnt3) {
					System.out.println("B");
				}else {
					if(aCnt2>bCnt2) {
						System.out.println("A");
					}else if(aCnt2<bCnt2) {
						System.out.println("B");
					}else {
						if(aCnt1>bCnt1) {
							System.out.println("A");
						}else if(aCnt1<bCnt1) {
							System.out.println("B");
						}else {
							System.out.println("D");
						}
					}
				}
			}
			
		}
		
	}
	
}
