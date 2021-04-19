import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * How 구현?
 * 1. dfs 로 구현
 * 2. map의 상하좌우 대각선을 움직이면서 다 검사하기
 * 3. 각 섬이 상하좌우로 연결되어 있거나 대각선으로 갈 수 있다면 하나의 섬으로 보기 
 * 4. 행과 열을 주의하기 !!! -> 실수 
 */
public class ex4963 {
	static int dx[] = {-1, -1, -1, 0, 0, 1, 1 ,1}; // 상하좌우 대각선의 x좌표
	static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1}; // 상하좌위 대각선의 y좌표
	static int map[][] ; // 섬의 지도
	static boolean visited[][]; // 방문 표시 배열
	static int w,h; // 지도의 너비와 높이 
	
	public static void dfs(int yNode, int xNode) {
		visited[yNode][xNode] = true;
		
		for(int i =0; i < 8; i++) { // 방향벡터만큼 돌리기
			int ny = yNode + dy[i];
			int nx = xNode + dx[i];
			
			// 지도에서 벗어나지 않는다면 탐색하기 
			if(0 <= nx && nx < w && 0 <= ny && ny < h) {
				if(map[ny][nx] == 1 && visited[ny][nx] == false) { // 서로 연결이 되어있고 방문하지 않았다면
					dfs(ny, nx);
				}
			}
		}
	} 

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		String[] input = br.readLine().split(" ");
		
		w = Integer.parseInt(input[0]); // 지도의 너비
		h = Integer.parseInt(input[1]); // 지도의 높이
		
		while(!(w == 0 && h == 0)) { // 지도의 크기가 0이 아닌 경우 반복하기
			map = new int[h][w];
			visited = new boolean[h][w];
			
			// 지도의 값을 입력받기 행과 열 조심하기 
			for(int i=0; i < h; i++) {
				String[] tmp = br.readLine().split(" ");
				for(int j=0; j < w; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			int cnt = 0; // 섬의 개수 카운트하기 
			for(int i=0; i < h; i++) {
				for(int j=0; j < w; j++) {
					if(map[i][j] == 1 && visited[i][j] == false) { // 방문하지 않았다면
						visited[i][j] = true; // 방문했다고 표시한 뒤
						dfs(i,j);
						cnt++; // 섬의 개수 카운트
					}
				}
			}
			
			System.out.println(cnt);
			
			// 다시 w와 h 입력받기 위해서 갱신
			input = br.readLine().split(" ");
			w = Integer.parseInt(input[0]);
			h = Integer.parseInt(input[1]);
		}
	}

}
