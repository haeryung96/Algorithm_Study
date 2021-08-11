import java.io.*;
import java.util.*;

// 0은 빈칸, 1은 집, 2는 치킨집
// 인덱스의 시작은 1,1 이고 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|

public class ex15686 {
	public static class Location {
		int x;
		int y;
		
		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int N, M; // 맵의 크기, 최대 M개 고르기 
	public static int[][] map;
	public static boolean[] visited;
	public static ArrayList<Location> home = new ArrayList<>();
	public static ArrayList<Location> chicken = new ArrayList<>();
	public static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new int[N+1][N+1];
		
		StringTokenizer st;
		for(int i=1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) { // 집이라면 
					home.add(new Location(i,j));
				}
				else if(map[i][j] == 2) { // 치킨집이라면 
					chicken.add(new Location(i,j));
				}
			}
		}
		
		visited = new boolean[chicken.size()];
		
		combination(0,0);
		System.out.println(answer);
		
	}
	// 구할 수 있는 조합 구하기 
	public static void combination(int start, int cnt) {
		if(cnt == M) {
			distance();
			return;
		}
		
		for(int i= start; i < chicken.size(); i++) {
			visited[i] = true;
			combination(i + 1, cnt + 1);
			visited[i] = false;
		}
	}

  // 거리 구하기 
	public static void distance() {
		int sum = 0; // 치킨집 기준으로 집과의 거리들의 합 
		for(int i = 0; i < home.size(); i++) {
			int min = Integer.MAX_VALUE;
			
			for(int j = 0; j < chicken.size(); j++) {
				int dist = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);
				min = Math.min(min, dist);
			}
			
			sum += min;
		}
    
		answer = Math.min(answer, sum);
	}
}
