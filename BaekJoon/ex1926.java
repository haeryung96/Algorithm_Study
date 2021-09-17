import java.io.*;
import java.util.*;

public class ex1926 {
	static int N, M; // 가로 세로 크기
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<Node> q = new LinkedList<>();
	static ArrayList<Integer> width = new ArrayList<>();
	static int w;
	
	public static class Node{
		int x; int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void BFS(int x, int y) {
		w = 0;
		q.add(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			visited[node.x][node.y] = true;
			
			for(int k=0; k < 4; k++) {
				int nx = node.x + dx[k];
				int ny = node.y + dy[k];
				
				if(0 <= nx && 0 <= ny && nx < N && ny < M) {
					if(map[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.add(new Node(nx, ny));
					}
				}
			}
			w++;
		}
		
		width.add(w);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		StringTokenizer st;
		for(int i=0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for(int i=0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					BFS(i, j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
		int MAX = Integer.MIN_VALUE;
		if(width.size() == 0) {
			MAX = 0;
		}
		else {
			for(int i=0; i < width.size(); i++) {
				MAX = Math.max(MAX, width.get(i));
			}
		}
		
		System.out.println(MAX);
		
	}

}
