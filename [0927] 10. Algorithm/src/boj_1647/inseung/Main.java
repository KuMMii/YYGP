package boj_1647.inseung;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// <폐기> 두 마을 부분집합 나눔 : visited[] true/false -> 한 마을 안에서 간선을 이음
// 기현 tip - 크루스칼 (두 마을로 나누고 하는거 X), 간단하게 생각해라
// <폐기> 간선 N-2개가 최소임. -> 간선 값 젤 작은거 N-2개 뽑고, 모든 정점이 하나의 간선이라도 선택됐는지 확인
// -> 안됐으면 그다음으로 큰거 뽑음, 다시 확인

// 크루스칼 방법으로 간선 걍 N-2개 뽑으면 되는거임 설마? 서클 안생기게 뽑히니까 최대 1개만 고립될거고,, -> 그랬다.
// 무슨 문제를 무슨 방법으로 푸는건지 판단할줄 알아야 한다!!
// 크루스칼로 가중치 제일 작은 간선 N-2개 뽑는다 (크루스칼은 서클 안생기게 뽑는, 다 연결해서 뽑는 방법이다) 
// (프림으로 하게되면 -> N-1개 뽑고, 가중치 젤 큰거 하나 빼줌)
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		edge = new int[M][3];
		
		// 0열 & 1열의 간선 값이 2열
		for (int i = 0; i < M; i++) {
			edge[i][0] = sc.nextInt();
			edge[i][1] = sc.nextInt();
			edge[i][2] = sc.nextInt();
		}
		
		// edge[]를 오름차순 정렬
		Arrays.sort(edge, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
//		Arrays.sort(edge, (a,b) -> a[2]-b[2]); // 동혁이형 tip! 간단
		
		// 최고조상 - 자기 자신으로 초기화
		p = new int[N+1];
		makeset();
		
		int sum = 0; // 간선 가중치 합
		int num = 0; // 선택한 간선 개수
		
		// 간선 N-2개 더해봄
		for (int a = 0; a < M; a++) {
			if(num == N-2) break; // 97%에서 틀림 -> 마을이 2개인 경우 때매 for문 맨 밑에서 위로 올림
			
			int x = edge[a][0];
			int y = edge[a][1];
			// 이미 최고조상이 같다는건, 이미 연결돼있단 뜻. 그 간선은 선택 안함
			if (findset(y) != findset(x)) {
				unionset(x, y);
				sum += edge[a][2];
				num++;
			}
			
		}
		
		System.out.println(sum);
	}

	static int N; // 집의 개수
	static int M; // 길의 개수
	static int[][] edge; // 간선 배열
	static int[] p; // 최고 조상

	static void unionset(int x, int y) {
		p[findset(y)] = findset(x);
	}
	
	static int findset(int x) {
		if (p[x] != x) {
			p[x] = findset(p[x]);
		}
		return p[x];
	}
	
	static void makeset() {
		for (int i = 1; i<N+1; i++) {
			p[i] = i;
		}
	}
}


