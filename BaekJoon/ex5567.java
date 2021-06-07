import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex5567 {
	public static int N, M;
	public static int cnt;
	public static int[][] map;
	public static boolean[][] visited;
	public static Queue<Integer> qx = new LinkedList<>();
	public static Queue<Integer> qy = new LinkedList<>();
	
	public static void BFS(int x, int y) {
		qx.add(x);
		qy.add(y);
		visited[x][y] = true;
		cnt = 0;
		
		while(!qx.isEmpty() && !qy.isEmpty()) {
			int lx = qx.poll();
			int ly = qy.poll();
			
			for(int i=1; i < N; i++) {
				if(map[lx][i] == 1 && visited[x][i] == false) {
					
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 상근이의 동기의 수 
		M = Integer.parseInt(br.readLine()); // 리스트의 길이 
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		StringTokenizer st;
		
		// 동기의 수만큼 map 채우기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = 0;
			}
		}
		
		// 친구의 관계 
		for(int i=0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			
			map[p1][p2] = map[p2][p1] = 1;
		}
		
		
	}

}
