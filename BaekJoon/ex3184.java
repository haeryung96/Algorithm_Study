import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ex3184 {
	public static int r,c;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static Queue<Node> q = new LinkedList<>();
	static int ship; // 양의 개수 카운트
	static int wolves; // 늑대의 개수 카운트 
	static int sumShip = 0;
	static int sumWolves = 0;
	
	public static class Node{
		int x; 
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void BFS(int x, int y) {
		ship = 0;
		wolves = 0;
		
		q.add(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			visited[node.x][node.y] = true;
			
			if(map[node.x][node.y] == 2) { // 늑대의 개수 
				wolves++;
			}
			else if(map[node.x][node.y] == 1) { // 양의 개수 
				ship++;
			}
			
			for(int k=0; k < 4; k++) {
				int nx = node.x + dx[k];
				int ny = node.y + dy[k];
				
				if(nx >= 0 && ny >= 0 && nx < r && ny < c) {
					if(map[nx][ny] != 3 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.add(new Node(nx, ny));
					}
				}	
			}
		}
		
		if(wolves < ship) {
			wolves = 0;
		}
		else {
			ship = 0;
		}
		
		sumShip += ship;
		sumWolves += wolves;

	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		r = Integer.parseInt(input[0]); // 행
		c = Integer.parseInt(input[1]); // 열
		
		map = new int[r][c];
		visited = new boolean[r][c];
		
		for(int i=0; i < r; i++) {
			String txt = br.readLine();
			for(int j=0; j < c; j++) {
				if(txt.charAt(j) == '.') { // 빈공간 
					map[i][j] = 0;
				}
				else if(txt.charAt(j) == '#') { // 울타리
					map[i][j] = 3;
				}
				else if(txt.charAt(j) == 'v') { // 늑대
					map[i][j] = 2;
				}
				else { // 양
					map[i][j] = 1;
				}
			}
		}
		
		for(int i=0; i < r; i++) {
			for(int j=0; j < c; j++) {
				if(map[i][j] != 3 && !visited[i][j]) {
					BFS(i,j);
				}
			}
		}
		
		System.out.print(sumShip + " " + sumWolves);

	}

}
