import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ex3190 {
	
	static class Location{
		int x; int y;
		
		Location(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌 
	public static int[] dy = {0, 1, 0, -1}; // 
	public static int N;
	public static int K;
	public static int[][] map;
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 보드의 크기 
		K = Integer.parseInt(br.readLine()); // 사과의 개수 
		map = new int[N+1][N+1];
		
		// 사과 채우기 - 1로
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			map[v1][v2] = 1;
		}
		
		Map<Integer, String> direction = new HashMap<>(); // 방향에 관란 맵 설정
		
		// 방향 설정하기 
		int L = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken()); // 초
			String d = st.nextToken();
			direction.put(sec, d);
		}

		int time = 0;
		int dir = 1;
		map[1][1] = 2; // 처음 뱀의 위치는 1,1
	
		Deque<Location> snake = new ArrayDeque<>();
		snake.add(new Location(1,1));
		
		while(true) {
			time++;
			
			int nx = snake.getFirst().x + dx[dir];
			int ny = snake.getFirst().y + dy[dir];
			
			// 만약 벽에 부딪히면
			if(nx <= 0 || ny <= 0 || nx > N || ny > N) {
				break;
			}
			
			// 만약 몸끼리 부딪힌다면
			if(map[nx][ny] == 2) {
				break;
			}
			
			// 만약 이동한 칸에 사과가 있다면
			if(map[nx][ny] == 1) {
				map[nx][ny] = 2; 
				snake.addFirst(new Location(nx, ny)); // 뱀의 머리 추가
			}
			else if(map[nx][ny] == 0) { // 사과가 없다면
				// 몸 길이를 줄여 꼬리가 위치한 칸 비워줌 
				map[nx][ny] = 2;
				snake.addFirst(new Location(nx, ny)); // 뱀의 머리 갱신 
				
				Location tail = snake.removeLast(); // 꼬리 없애고
				map[tail.x][tail.y] = 0;
			}
			
			if(direction.containsKey(time)) {
				// 오른쪽으로 90도 회전 
				if((direction.get(time).equals("D"))) {
					dir = (dir + 1) % 4;
//					System.out.println("*");
				}
				else {
					dir = (dir + 3) % 4;
				}
			}
		}
		
		System.out.println(time);
	}

}
