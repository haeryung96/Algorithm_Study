import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ex10026 {
	static int N; 
	static int[][] colourmap1;
	static int[][] colourmap2;
	static boolean[][] visited1;
	static boolean[][] visited2;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static Queue<Node> q = new LinkedList<>();
	static int cnt1;
	static int cnt2;
	
	static class Node{
		int x; 
		int y; 
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
 
	public static void BFS(int x, int y, int[][] map, boolean[][] visited) {
		q.add(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			visited[node.x][node.y] = true;
			
			for(int k=0; k < 4; k++) {
				int nx = node.x + dx[k];
				int ny = node.y + dy[k];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if(map[x][y] == map[nx][ny] && !visited[nx][ny]) {
						q.add(new Node(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		colourmap1 = new int[N][N];
		visited1 = new boolean[N][N];
		
		for(int i=0; i < N; i++) {
			String input = br.readLine();
			for(int j=0; j < N; j++) {
				if(input.charAt(j) == 'R') {
					colourmap1[i][j] = 0;
				}
				else if(input.charAt(j) == 'G') {
					colourmap1[i][j] = 1;
				}
				else {
					colourmap1[i][j] = 2;
				}
			}
		}
		
		colourmap2 = new int[N][N];
		visited2 = new boolean[N][N];

		for(int i=0; i < N; i++) {
			for(int j=0; j < N; j++) {
				if(colourmap1[i][j] == 0 || colourmap1[i][j] == 1) {
					colourmap2[i][j] = 0;
				}
				else {
					colourmap2[i][j] = 1;
				}
			}
		}
		
		cnt1 = 0;
		for(int i=0; i < N; i++) {
			for(int j=0; j < N; j++) {
				if(!visited1[i][j]) {
					BFS(i, j, colourmap1, visited1);
					cnt1++;
				}			
			}
		}
		
		cnt2 = 0;
		for(int i=0; i < N; i++) {
			for(int j=0; j < N; j++) {
				if(!visited2[i][j]) {
					BFS(i, j, colourmap2, visited2);
					cnt2++;
				}			
			}
		}
		
		System.out.println(cnt1 + " " + cnt2);
	}

}
