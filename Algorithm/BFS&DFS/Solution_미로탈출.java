package nadongbin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_미로탈출 {
	public static int N, M;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static Queue<Integer> qx = new LinkedList<>();
	public static Queue<Integer> qy = new LinkedList<>();
	public static int ans;
	
	public static void BFS(int x, int y) {
		qx.add(x);
		qy.add(y);
		
		while(!qx.isEmpty() && !qy.isEmpty()) {
			int nx = qx.poll();
			int ny = qy.poll();
			visited[nx][ny] = true;
			
			for(int i=0; i < 4; i++) {
				int lx = nx + dx[i];
				int ly = ny + dy[i];
				
				if(lx >=0 && ly >= 0 && lx < N && ly < M) {
					if(visited[lx][ly] == false && map[lx][ly] == 1) {
						qx.add(lx);
						qy.add(ly);
						map[lx][ly] = map[nx][ny] + 1;
						visited[lx][ly] = true;
					}
				}
			}
		}
		
		ans = map[N-1][M-1];
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i < N; i++) {
			String tmp = br.readLine();
			String[] temp = tmp.split("");
			for(int j=0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		BFS(0,0);
		
	}

}
