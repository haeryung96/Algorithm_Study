import java.util.*;

public class ex1260 {
	static int[][] adjArray ; // 인접 행렬로 구현
	static boolean visited[]; // 방문 여부 검사 위해
	
	// dfs 구현
	static void dfs(int v, int[][] adjArray, boolean[] visited) {
		int l = adjArray.length-1; // 인접행렬의 길이 -> 메인에서 1개 더 크게 선언했기 때문에 1을 뺴줌
		visited[v] = true; // 방문을 했으면 true 반환
		System.out.print(v + " "); // 방문을 한 노드라면 정점 출력
		
		// 재귀로 구현
		for(int i = 1; i<=l; i++) { // 인접 행렬의 길이만큼 반복
			if(adjArray[v][i] == 1 && !visited[i]) { // 행렬에서 꺼낸 노드가 방문하지 않은 노드인 경우
				dfs(i, adjArray, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 정점의 개수
		int m = sc.nextInt(); // 간선의 개수
		int v = sc.nextInt(); // 탐색을 시작할 정점의 개수 
			
		
		adjArray = new int [n+1][n+1]; // 인접 행열로 구현
		visited = new boolean[n+1]; // 방문 여부 검사 
		
		// 간선이 연결하는 두 정점 
		int a; 
		int b;  
		
		for(int i=0; i<m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			// 인접행열로 그래프 구현
			adjArray[a][b] = 1;
			adjArray[b][a] = 1;
		}
		dfs(v, adjArray, visited); // dfs로 답 구하기
	}
}
