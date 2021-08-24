package nadongbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_경쟁적전염 {
	public static int N; // 맵의 크기
	public static int K; // 바이러스의 종류 
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static Queue<Node> q = new LinkedList<>();
	public static StringTokenizer st;
	public static int S, X, Y;
	
	public static class Node{
		int x, y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void BFS(int virus) {
		for(int i=0; i < N; i++) {
			for(int j=0; j < N; j++) {
				if(map[i][j] == virus) { // 바이러스 번호가 같다면 모두 큐에 넣기 
					q.add(new Node(i, j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node num = q.poll();
			
			for(int k=0; k < 4; k++) {
				int lx = num.x + dx[k];
				int ly = num.y + dy[k];
				
				if(lx >=0 && ly >= 0 && lx < N && ly < N) { // 범위안에 있고
					if(map[lx][ly] == 0) { // 바이러스에 전염안되었다면 
						map[lx][ly] = virus;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		
		for(int i=0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken()); // 몇 초 뒤
		X = Integer.parseInt(st.nextToken()) -1; // 좌표
		Y = Integer.parseInt(st.nextToken()) -1; // 좌표 
		
		loop: // 이중 루프를 한번에 빠져나가기 위해서 사용할 수 있음!!!
		for(int i=0; i < S; i++) { // 몇 초후인지 
			for(int j=0; j < K; j++) { // 바이러스 개수 만큼 돌리기
				BFS(j+1); // 바이러스의 번호는 1부터 시작
				
				if(map[X][Y] != 0) { // 맵에서 바이러스가 들어있다면 전파 못함
					break loop;
				}
			}
		}
		
		System.out.println(map[X][Y]);
	}

}
