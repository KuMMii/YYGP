package boj_20056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class ball{
		int R;
		int C;
		int M;
		int S;
		int D;
		public ball(int r, int c, int m, int s, int d) {
			R = r;
			C = c;
			M = m;
			S = s;
			D = d;
		}
	}//ball
	
	static int[] dr= {-1,-1,0,1,1,1,0,-1};
	static int[] dc= {0,1,1,1,0,-1,-1,-1};
	static int N,M,K,r,c,m,s,d;//가로세로길이,공개수,횟수,좌표,질량,속력,방향
	static int[][][] arr;
	static Queue<ball> q;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		arr=new int[N+1][N+1][5];//질량m,속력s, 방향d의 홀수짝수, 방향d
		q=new LinkedList<>();
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			r=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			s=Integer.parseInt(st.nextToken());
			d=Integer.parseInt(st.nextToken());
			
			q.add(new ball(r,c,m,s,d));
		}
		br.close();
		////input fin
		
		//K번 돌리기
		for(int k=0; k<K; k++) {
			
			//큐에 있는만큼만 돌리기
			int T=q.size();
			//arr에 정보 다 더해서 저장
			for(int t=0; t<T; t++) {
				ball b=q.poll();
				
				//공의 새로운 위치
				int ballR=(b.R+dr[b.D]*b.S)%N;
				//1부터 N까지니까 이렇게 처리함
				if(ballR==0) ballR=N;
				else if(ballR<1) ballR=ballR+N;
				
				int ballC=(b.C+dc[b.D]*b.S)%N;
				if(ballC==0) ballC=N;
				else if(ballC<1) ballC=ballC+N;
				
				//질량, 속력, 개수, 뱡향의 짝홀체크, 방향
				arr[ballR][ballC][0]+=b.M;
				arr[ballR][ballC][1]+=b.S;
				arr[ballR][ballC][2]++;
				arr[ballR][ballC][3]+=(b.D%2);
				arr[ballR][ballC][4]=b.D;
			}//arr에 덧셈끝
			
			//0이 아닌 것들 찾기
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {

					//그 자리의 개수
					int quan=arr[i][j][2];
					//1개인 경우는 큐에 바로 추가
					if(quan==1) {
						q.add(new ball(i,j,arr[i][j][0],arr[i][j][1],arr[i][j][4]));
					}
					//1개 이상이면 수술...들어가야함
					else if(quan>1) {
						//질량이 0인 경우는 걍..넘어가기
						if(Math.floor(arr[i][j][0]/5)==0) continue;
						//아닌 경우면 4개로 나눠줘야함
						else{
							int[] direction= new int[]{0,2,4,6};
							//방향이 전부 짝수/홀수
							for(int I=0; I<4; I++) {
								if(arr[i][j][3]!=0 &&  arr[i][j][3]!=quan) direction= new int[]{1,3,5,7};
								
								q.add(new ball(i,j,(int)Math.floor(arr[i][j][0]/5),(int)Math.floor(arr[i][j][1]/quan),direction[I]));
								
							}
						}//else
					}//else if(1개 이상)
					
					
				}//j
			}//i

			//0으로 초기화
			for(int I=1; I<=N; I++) {
				for(int J=1; J<=N; J++) {
					for(int z=0; z<=4; z++) {
						arr[I][J][z]=0;
					}
				}
			}
		}//K번 돌리기

		
		int ans=0;
		//무게더하기
		for(ball Ball : q) {
			ans+=Ball.M;
		}
		
		System.out.println(ans);
	}//main
}//class