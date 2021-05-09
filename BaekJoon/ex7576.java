import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * How 구현? -> BFS (미로탐색과 비슷하게)
 * 1. 토마토가 익은 점들을 x,y 좌표로 따로 큐에 넣어줌 
 * 2. 익은 토마토를 기준으로 상하좌우 검색 후 익지 않은 토마토가 있다면 큐에 널고 위치의 값은 최대 일수를 계산하기 위해 첫 시작점값 + 1 헤줌
 * 3. 큐가 빌때까지 반복
 * 4. 전체 토마토를 탐색하여 익지 않은 토마토 0의 값이 하나라도 있으면 -1 출력 -> 예제 입력 2번의 경우 
 * 5. 위의 경우들을 제외하고서는 모두 최대 일수 출력
 */

public class ex7576 {
	public static int N; // 상자의 가로 칸의 수 
	public static int M; // 상자의 세로 칸의 수 
	public static int[] dx = {1, -1, 0, 0}; // 상하좌우
	public static int[] dy = {0, 0, 1, -1}; // 상하좌우 
	public static int[][] map;
	public static boolean[][] visited;
	static Queue<Integer> tomatoX = new LinkedList<>(); // 토마토의 x 좌표
	static Queue<Integer> tomatoY = new LinkedList<>(); // 토마토의 y 좌표 
	
	public static void BFS(int x, int y) { // x는 N y는 M
		int cnt = 0;
		
		while(!tomatoX.isEmpty() && !tomatoY.isEmpty()) {
			int tx = tomatoX.poll();
			int ty = tomatoY.poll();
			visited[tx][ty] = true; // 방문처리 3, 5방문처리 
			
			// 상하좌우로 탐색
			for(int k = 0; k < 4; k++) {
				int location_x = tx + dx[k]; // x의 위치에서 상하좌우 검색하기
				int location_y = ty + dy[k]; // y의 위치에서 상하좌우 검색하기
				
				// 범위에서 벗어나지 않는다면 
				if(location_x >= 0 && location_y >= 0 && location_x < N && location_y < M) {
					// 안익은 토마토의 발견
					if(map[location_x][location_y] == 0) {
						tomatoX.add(location_x); // (2,5) (3,4)
						tomatoY.add(location_y);
						visited[location_x][location_y] = true; // 방문처리하고 
						
						// 익게 만들었으니까 0을 1로 변경 
						map[location_x][location_y] = map[location_x][location_y] + 1;
						
						map[location_x][location_y] = map[tx][ty] + 1; // 일수를 카운트하기 위해 익은 토마토가 있는 기점을 일수 1로 두고 값을 갱신 1+1
						cnt = map[location_x][location_y];  // 첫 시작 : 2부터 
						//cnt++; // 일수 카운트 -> 이렇게 하면 상하좌우 검색해서 0일 때 일수 상관없이 모두 카운트해서 문제 
					}
				}
			}
		}
		
		// 모두 탐색했지만 안익은 토마토가 있다면 -> 출력값이 -1 인 경우 
		for(int i=0; i < N; i++) {
			for(int j=0; j < M; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		// 주의 !!! 
		// 모든 토마토가 익은 상태이면 0을 출력하기 위한 조건 if 조건을 안달아주면 -1로 출력함 
		if(cnt > 0) {
			cnt--; // 첫 시작점(익은 토마토를 기준으로) 첫 일수를 1부터 시작했으므로 1 적게 출력 
		}
		
//		cnt--; // 첫 시작점(익은 토마토를 기준으로) 첫 일수를 1부터 시작했으므로 1 적게 출력
		
		System.out.println(cnt);
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		M = Integer.parseInt(input[0]); // 상자의 가로 칸의 수 -> 열
		N = Integer.parseInt(input[1]); // 상자의 세로 칸의 수 -> 행 
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		StringTokenizer st;
		
		for(int i=0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 익은 토마토가 있다면 큐에 넣어주기 
				if(map[i][j] == 1) {
					tomatoX.add(i);
					tomatoY.add(j);
				}
			}
		}
		
		BFS(N,M);
	}

}
