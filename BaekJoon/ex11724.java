import java.io.*;
import java.util.*;

/*
 * How 구현?
 * 1. dfs로 구현
 * 2. 모든 노드를 dfs로 검사하고 탐색이 끝나면 그래프의 개수를 카운트 
 */

public class ex11724 {
	public static int[][] map ;
	public static int N, M; // 정점의 개수, 간선의 개수 
	public static boolean[] visited ;
	
	public static void dfs(int node) {
		visited[node] = true; // 노드를 방문했다고 표시해주고 
		
		for(int i = 1; i <= N; i++) { // 1번 노드부터 N번노드까지 모두 검사하기
			if(map[node][i] == 1 && visited[i] == false) { // node와 i가 연결되어있고 방문하지 않은 요소라고 하면
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수 
		M = Integer.parseInt(st.nextToken()); // 간선의 개수 
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		int cnt = 0; // 그래프의 개수 카운트하기 위해서 사용
		
		// 그래프 구성하기 
		for(int i=0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			// 인접행렬로 구현
			map[u][v] = map[v][u] = 1;
		}
		
		// 노드 1번부터 6개의 노드를 모두 검사하기 
		for(int i=1; i <= N; i++) {
			if(visited[i] == false) { // 아직 방문하지 않은 노드라고 하면 
				dfs(i); // dfs로 재귀호출하고
				cnt++; // 그래프의 개수가 몇개인지 카운트하기 
			}
		}
		System.out.println(cnt);
	}

}
