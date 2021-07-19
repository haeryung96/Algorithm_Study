package Level2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 주의
 * 1. n*m 크기의 맵임 즉 맵이 정사각형일수도 아닐수도 있다는 것 !!
 * 2. BFS 최단거리 구하기 
 * */

public class Solution_게임맵최단거리 {
	public static boolean[][] visited;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static Queue<Integer> qx = new LinkedList<>();
	public static Queue<Integer> qy = new LinkedList<>();
	public static boolean flag;
	public static int N, M; // 맵의 크기 

	public static void main(String[] args) {
		int[][] map1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(map1)); // 11

		int[][] map2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		System.out.println(solution(map2)); // -1
	}
	
	public static void BFS(int x, int y, int[][] map) {
		qx.add(x);
		qy.add(y);
		
		while(!qx.isEmpty() && !qy.isEmpty()) {
			int tx = qx.poll();
			int ty = qy.poll();
			visited[tx][ty] = true;
			
			for(int i=0; i < 4; i++) {
				int lx = tx + dx[i];
				int ly = ty + dy[i];
				
//				if(lx == N-1 && ly == M-1) { // 목표물에 도달했다면 
//					flag = true;
//					System.out.println(flag);
//					System.out.println(map[lx][ly]);
//					return;
//				} -> 이렇게 하면 map[lx][ly]의 값을 아래에서 갱신해서 못가지고 옴 
				
				if(lx >= 0 && ly >=0 && lx < N && ly < M) {
					if(map[lx][ly] == 1 && !visited[lx][ly]) {
						qx.add(lx);
						qy.add(ly);
						map[lx][ly] = map[tx][ty] + 1; // 맵에 값을 증가시킴
//						System.out.println(map[lx][ly]);
						visited[lx][ly] = true;
					}
				}
			}
		}
	}

	public static int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        
        BFS(0,0,maps);
        
        answer = maps[N-1][M-1];
        
        if(answer <= 1) return -1;  // 상대방에게 도착하지 못한다면 maps[N-1][M-1] 의 값이 2 이상 될 수 없음 
        return answer;     // 상대방에게 도착했다면 
    }
}
