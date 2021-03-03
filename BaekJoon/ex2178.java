import java.io.*;
import java.util.*;

// 최단거리 구하기는 BFS 이용

/*
 * How 구현?
 * 1. 최단거리는 BFS로 풀기
 * 2. BFS는 Queue
 * 3. 큐에 먼저 값을 넣고 상하좌우를 살피면서 노드의 값을 탐색
 * 4. 노드의 값이 1이라면 큐에 값을 넣고 방문했다고 한 후,이동횟수를 구함
 */

public class ex2178 {
	static int dx[] = {0,0,1,-1}; // 상하좌우의 x좌표 동작
	static int dy[] = {1,-1,0,0}; // 상하좌우의 y좌표 동작
	static boolean visited[][]  = new boolean[100][100]; // 방문 여부 체크 
	static int[][] map = new int[100][100]; // 미로 
	static int n,m; // 미로의 크기 
	
	public static void bfs(int x, int y) { // 최단거리는 BFS !!
		Queue<Integer> qx = new LinkedList<Integer>(); // x좌표에 대한 큐 
		Queue<Integer> qy = new LinkedList<Integer>(); // y좌표에 대한 큐 

		// 큐에 x좌표와 y좌표를 넣기 -> 먼저 0,0을 넣고 시작 
		qx.add(0);
		qy.add(0);
		
		visited[0][0] = true; // 먼저 0,0을 방문했다고 바꾸기 
		
		// 큐가 비기 전까지 반복
		while(!qx.isEmpty()) {
			int i = qx.poll(); // x 좌표 빼기
			int j = qy.poll(); // y 좌표 빼기
						
			// 상하좌우 확인하기
			for(int k=0; k<4; k++) {
				int location_x = i + dx[k]; // x의 위치에서 상하좌우 검색하기
				int location_y = j + dy[k]; // y의 위치에서 상하좌우 검색하기
				
				visited[x][y] = true;
				
				// 범위를 벗어나지 않는 공간에서 탐색 진행하기
				if(location_x>=0 && location_y>=0 && location_x<n && location_y<m) {
					// 방문하지 않았고 값이 1인 경우 탐색
					if(map[location_x][location_y] == 1 && visited[location_x][location_y] == false) {
						qx.add(location_x);
						qy.add(location_y);
						
						visited[location_x][location_y] = true; // 방문했다고 바꿔주고
						
						map[location_x][location_y] = map[i][j] + 1; // 이동횟수 구하기 
					}
				}
			}	
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 미로 받기
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0,0);
		System.out.print(map[n-1][m-1]); // (n,m) 출력, 좌표 값이기 때문에 -1을 해줘야 값이 나옴 
	}
}
