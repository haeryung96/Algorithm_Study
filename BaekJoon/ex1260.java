import java.util.*;

/*
 * DFS와 BFS
 * */

/*
 * How구현?
 * 1. dfs, bfs 모두 인접 행렬로 구현
 * 2. 인접 행렬의 경우 a[1][2] = 1 a[2][1] = 1 이기 때문에 for문을 한번만 돌려도 모든 노드 검사 가능
 * 3. dfs와 bfs를 recursive로 구현
 * 4. 노드를 방문한 경우 visited = true로 갱신
 * 5. bfs는 큐 이용
 * */

public class ex1260 {
	static int[][] adjArray ; // 인접 행렬로 구현
	static boolean visited[]; // 방문 여부 검사 위해
	static Queue<Integer> q = new LinkedList<>(); // BFS 구현을 위해 큐 선언
	
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
	
	// bfs 구현 - 큐 이용
	static void bfs(int v, int[][] adjArray, boolean[] visited) {
		int n = adjArray.length-1; // 인접행렬의 길이 -> 메인에서 1개 더 크게 선언했기 때문에 1을 뺴줌
		
		q.add(v); // 큐에 먼저 정점을 넣어줌
		visited[v] = true; // 해당 정점을 방문했다면 true 반환
		
		while(!q.isEmpty()) { // 큐가 비어있지 않다면
			v = q.poll(); // 큐에서 하나 뺴기
			System.out.print(v + " "); // 큐에서 뺴는 순간 정점을 지난것으로 생각하고 출력
			
			for(int i=1; i<=n; i++) { // 인접 행렬의 길이만큼 반복
				if(adjArray[v][i] == 1 && !visited[i]) { // 큐에서 꺼낸 노드와 연결된 노드가 방문하지 않았던 노드라면
					q.add(i); // 큐에 정점을 넣고
					visited[i] = true; // 방문했으니까 true로 변경
				}
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
		Arrays.fill(visited, false); // BFS 값을 다시 구하기 위해서 visited 배열 초기화
		System.out.println(""); // 한줄 띄우고 출력
		bfs(v, adjArray, visited); // bfs로 답 구하기

	}

}
