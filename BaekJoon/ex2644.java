import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * How 구현?
 * 1. 촌수 = 입력된 노드의 간선의 수와 동일
 * 2. 방문 배열은 큐에 새로은 노드값를 넣은 순간 연결된 노드의 방문 배열에 +1을 해줌
 * 3. 위의 방법을 계속 누적하면서 값을 구함
 * 4. 큐에 남아있는 노드의 값의 맨 윗값이 촌수를 계산해야하는 두번째 인물인 경우 두번째 인물의 방문배열 값을 출력
 * 그림을 그리면서 이해하면 쉬움 
 */

public class ex2644 {
	public static int N; // 전체 사람의 수 
	public static int M; // 부모 자식들 간의 관계의 개수 
	public static int V; // 부모 자식들 간의 관계 개수 
	public static int cnt; // 촌수
	public static int[][] map;
	public static int[] visited;
	public static Queue<Integer> qx = new LinkedList<Integer>();
	
	public static int BFS(int x, int y) {
		qx.add(x);
		
		while(!qx.isEmpty()) {
			int tx = qx.poll();
			
			for(int i=1; i < map.length; i++) {
				if(map[tx][i] == 1 && visited[i] == 0) {
					qx.add(i);
					// 연결되어있는 요소의 누적값으로 갱신 
					visited[i] = visited[tx] + 1;
				}
			}
			
			// 촌수를 계산해야하는 두번째 인물이 큐의 맨 처음 값이라면 
			// 방문배열에서 누적된 값을 출력 
			if(!qx.isEmpty() && qx.peek() == y) {
				return visited[y];
			}
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int p1 = Integer.parseInt(st.nextToken()); // 촌수를 계산해야 하는 첫번째 인물
		int p2 = Integer.parseInt(st.nextToken()); // 촌수를 계산해야 하는 두번째 인물
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());

		map = new int[N+1][N+1];
		visited = new int[N+1];
		
		for(int i=0; i < V; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}
		
//		BFS(p1, p2);
		System.out.print(BFS(p1, p2));
	}

}
