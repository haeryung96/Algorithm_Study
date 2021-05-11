import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * How 구현?
 * 1. BFS 사용
 * 2. 배추지렁이의 개수 -> 인접한 배추들을 하나의 그룹으로 만들고 그룹의 개수와 동일
 * 3. 그룹의 개수를 구하기 위해서는 BFS 메소드 안에서 cnt++ 를 하는 것이 아니고 BFS 탐색을 다 한 후에 cnt++
 */

public class ex1012 {
	public static int T, M, N, K;
	public static int[] dx = {1, -1, 0, 0}; // 상하좌우
	public static int[] dy = {0, 0, 1, -1}; // 상하좌우 
	public static int[][] map;
	public static boolean[][] visited;
	public static int cnt; // 배추흰지렁이 개수 
	static Queue<Integer> qx = new LinkedList<>();
	static Queue<Integer> qy = new LinkedList<>();
	
	public static void BFS(int x, int y) {
		qx.add(x);
		qy.add(y);
		
		while(!qx.isEmpty() && !qy.isEmpty()) {
			int cx = qx.poll();
			int cy = qy.poll();
			visited[cx][cy] = true;
			
			for(int k=0; k < 4; k++) {
				int location_x = cx + dx[k];
				int location_y = cy + dy[k];
								
				if(location_x >=0 && location_y >=0 && location_x < M && location_y < N) {
					
					if(map[location_x][location_y] == 1 && visited[location_x][location_y] == false) {
						qx.add(location_x);
						qy.add(location_y);
						visited[location_x][location_y] = true;
						
//						cnt++;
					}
				}
			}
		}
		
//		System.out.println(cnt);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		StringTokenizer st;
		
		for(int i = 0; i < T; i++) {
			String[] input = br.readLine().split(" ");
			M = Integer.parseInt(input[0]); // 배추밭의 가로 길이 행
			N = Integer.parseInt(input[1]); // 배추밭의 세로 길이 열
			K = Integer.parseInt(input[2]); // 배추가 심어져 있는 위치의 개수 
			
			map = new int[M][N];
			visited = new boolean[M][N];
			cnt = 0;
			
			for(int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int cabbageX = Integer.parseInt(st.nextToken());
				int cabbageY = Integer.parseInt(st.nextToken());
				
				map[cabbageX][cabbageY] = 1;
			}
			
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < N; k++) {
					if(map[j][k] == 1 && visited[j][k] == false) {
						BFS(j,k);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
		
	}

}
