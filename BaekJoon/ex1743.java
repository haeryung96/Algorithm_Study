import java.io.*;
import java.util.*;

public class ex1743 {
	public static int N, M, K; 
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static Queue<Node> q = new LinkedList<>();
	public static ArrayList<Integer> w = new ArrayList<>();
	public static int width;
	
	public static class Node{
		int x; int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void BFS(int x, int y) {
		width = 0;
		q.add(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			visited[node.x][node.y] = true;
			
			for(int k=0; k < 4; k++) {
				int nx = node.x + dx[k];
				int ny = node.y + dy[k];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if(map[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.add(new Node(nx, ny));
					}
				}
			}
			width++;
		}
		
		w.add(width);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i < K; i++) {
			String[] str = br.readLine().split(" ");
			int r = Integer.parseInt(str[0]);
			int c = Integer.parseInt(str[1]);
			
			map[r-1][c-1] = 1;
		}
		
		for(int i=0; i < N; i++) {
			for(int j=0; j < M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					BFS(i, j);
				}
			}
		}
		
		Collections.sort(w);
		int max = w.get(w.size() - 1);
		
		System.out.println(max);
	}

}
