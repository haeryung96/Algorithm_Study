package nadongbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_특정거리의도시찾기 {
	public static int N, M, K, X;
	public static int[] distance;
	// 노드의 연결을 표현하기 위해 이중 배열 리스트 사용 
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static Queue<Integer> q = new LinkedList<>();
	
	public static void BFS(int h) {
		q.add(h); // 시작 노드 삽입 
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i : graph.get(now)) {
				if(distance[i] == -1) {
					distance[i] = distance[now] + 1;
					q.offer(i);
				}
			}
		}
//		System.out.println(Arrays.toString(distance));
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); // 도시의 개수
		M = Integer.parseInt(input[1]); // 도로의 개수 
		K = Integer.parseInt(input[2]); // 거리의 정보
		X = Integer.parseInt(input[3]); // 출발 도시의 번호 
		
		// 그래프 거리 및 최단 거리 테이블 
		distance = new int[N+1];
		for(int i=0; i < N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		// 미리 거리를 -1로 초기화 
		Arrays.fill(distance, -1);
		
		StringTokenizer st;
		for(int i=0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b); // a 노드와 b 노드를 연결하여 표현 
		}
		
		distance[X] = 0; // 출발 도시에서 출발도시의 거리는 0으로 설정 
		
		BFS(X);
		
		boolean chk = false;
		for(int i = 1; i <= N; i++) {
			if(distance[i] == K) {
				System.out.println(i); // 도시의 번호를 출력
				chk = true;
			}
		}
		
		if(!chk) System.out.println(-1);

	}

}
