import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * How 구현?
 * 1. BFS 알고리즘 사용
 * 2. 주의해야할 점은 노드간의 연결이 방향성이 있다는 것 -> 입력받을떄 바로 인접행렬로 구하면 안됨 
 * 3. ex) 1번 노드와 연결되어 있는 1~7번 노드를 큐에 넣고 탐색 
 * 4. 위의 과정을 다른 노드들과 동일하게 반복 
 * 5. 행 단위로 검사하기 떄문에 방문배열을 초기화해줘야함!!!!!!!!!!!!
 * */

public class ex11403 {
	static int[][] map; 
	static boolean[] visited; // 방문 여부 배열 
	static int N; // 정점의 개수
	
	// xNode 부모노드 yNode 자식노드 
	static void BFS(int xNode, int yNode) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(yNode); // 큐에 시작 노드를 넣기 
		visited[yNode] = true; // 방문처리 해주고 
		
		while(!q.isEmpty()) {
			int tmp = q.poll(); 
			
			for(int i=0; i < N; i++) {
				if(map[tmp][i] == 1 && visited[i] == false) { // 간선이 연결되어 있고 방문하지 않은 노드라면 
					q.add(i); // 노드 i를 넣고
					visited[i] = true; // 방문처리하기 
					map[xNode][i] = 1;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 정점의 개수 
		map = new int[N][N];
//		visited = new boolean[N];
		
		StringTokenizer st;
		
		// 인접행렬 입력받기 
		for(int i=0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
//				map[i][j] = map[j][i] = 1; // 인접행렬로 구현
			}
		}
		
		// BFS 탐색 
		for(int i=0; i < N; i++) {
			visited = new boolean[N];
			for(int j=0; j < N; j++) {
				if(!visited[j] && map[i][j] == 1 ) {
					BFS(i, j);
				}
			}
		}
		
		for(int i=0; i < N; i++) {
			for(int j=0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println(); // 개행해주기 
		}
	}

}
