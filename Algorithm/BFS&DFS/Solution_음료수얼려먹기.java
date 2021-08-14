package nadongbin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 토크나이저 왜 안되는지 모르겠다 빡친다 진짜;

public class Solution_음료수얼려먹기 {
	public static int N, M;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static Queue<Integer> qx = new LinkedList<>();
	public static Queue<Integer> qy = new LinkedList<>();
	public static int icecream;
	
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
				
				if(lx >= 0 && ly >= 0 && lx < N && ly < M) {
					if(map[lx][ly] == 0 && visited[lx][ly] == false) { 
						qx.add(lx);
						qy.add(ly);
						visited[lx][ly] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]); // 4 세로 길이 열
		M = Integer.parseInt(input[1]); // 5 가로 길이 행
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) { // 4
			String tmp = br.readLine();
			String[] temp = tmp.split("");
			for(int j = 0; j < M; j++) { // 5
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i=0; i < N; i++) {
			for(int j=0; j < M; j++) {
				if(map[i][j] == 0 && visited[i][j] == false) {
					BFS(i,j);
					icecream++;
				}
			}
		}
		
		System.out.println(icecream);
	}

}

/*
 * 15 14
00000111100000
11111101111110
11011101101110
11011101100000
11011111111111
11011111111100
11000000011111
01111111111111
00000000011111
01111111111000
00011111111000
00000001111000
11111111110011
11100011111111
11100011111111
 * */
