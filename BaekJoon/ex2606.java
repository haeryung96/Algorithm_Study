import java.util.*;

/*
 * 1. DFS 로 구현 : 더 나아갈 길이 보이지 않을 떄까지 깊이 들어감
 * 2. 인접행렬과 재귀로 구현
 * 3. 컴퓨터의 수를 노드의 수. 네트워크의 수를 간선의 수로 생각하고 풀이
 * 4. visited 배열에서 true인 노드는 바이러스 감염된 노드이기 떄문에 카운트 해주기
 * */

public class ex2606 {
	static int[][] map; // 인접 행렬 선언
	static boolean visited[]; // 방문의 여부 확인 행렬 선언
	
	// dfs 메소드 생성 
	static void dfs(int v, int map[][], boolean visited[]) {
		visited[v] = true; // 해당 노드를 방문했다면 true 반환
		
		// recursive
		for(int i=1; i<map.length; i++) {
			if(map[v][i]==1 && !visited[i]) { // 행렬에서 꺼낸 노드가 방문하지 않은 노드라면
				dfs(i, map, visited);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int com = sc.nextInt(); // 컴퓨터의 수 : 노드의 수
		int net = sc.nextInt(); // 네트워크의 수 : 간선의 수 
		
		// 배열의 크기를 노드의 수보다 1개 더 크게 선언
		map = new int[com+1][com+1];
		visited = new boolean[com+1];
		
		// 네트워크가 연결하는 두 정점
		int a ;  
		int b ;
		
		for(int i = 0; i<net; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			map[a][b] = 1; // 인접행렬로 구현하기
			map[b][a] = 1; 
		}
		
		// 노드가 방문이 된 경우 즉, 바이러스에 감염되었다는 의미 
		int cnt = 0; // 방문한 경우만 바이러스 감염이니까 true의 개수를 세어주면 값이 나옴 
				
		dfs(1, map, visited); // 1번 컴퓨터부터 시작하기로 했으니까 1을 넣어두기
		
		for(boolean bool : visited) { // visited의 모든 배열을 검사하라
			if(bool == true) { // true이면 바이러스가 걸린것 이기 때문에
				cnt++; // 카운트해주기 
			}
		}
		System.out.println(cnt-1); // 1번 노드 빼고 카운트
	}
}
