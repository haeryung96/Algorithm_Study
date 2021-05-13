package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 안전영역이면 -> 1 안전영역 아니면 -> 0

/*
 * How 구현?
 * BFS 사용
 * 1. map에 강수량을 입력받고 건물의 높이보다 map의 값이 작으면 잠긴도시 -> 0으로 채우기
 * 2. 건물의 높이보다 map의 값이 크면 안잠긴 도시 -> 1로 채우기
 * 3. 1로 채운 공간 -> 영역의 크기 = 안전 영역
 */

/*
 * 아무 지역도 물에 잠기지 않을 수 있다. 
 * -> 지역의 높이는 1부터 시작하니 아무지역도 물에 잠기지 않으려면 비의 양이 0인 경우도 생각해
 */

public class ex2468 {
   public static int N; // 가로 세로 길이
   public static int cnt; // 안전영역의 개수 
   public static int max_cnt; // 최대 안전영역의 개수 
   public static int maxH; // 지역의 최대 높이, 물의높이 
   public static int[][] map;
   public static int[][] flood; // 안전영역인지 아닌지 
   public static boolean[][] visited; 
   public static int[] dx = {1, -1, 0, 0};
   public static int[] dy = {0, 0, 1, -1};
   public static Queue<Integer> qx = new LinkedList<>();
   public static Queue<Integer> qy = new LinkedList<>();
   
   public static void BFS(int x, int y) {
      qx.add(x);
      qy.add(y);
      
      while(!qx.isEmpty() && !qy.isEmpty()) {
         int wx = qx.poll();
         int wy = qy.poll();
         
         visited[wx][wy] = true;
         
         for(int k=0; k < 4; k++) {
            int lx = wx + dx[k];
            int ly = wy + dy[k];
            
            if(lx >= 0 && ly >= 0 && lx < N && ly < N) {
               if(flood[lx][ly] == 1 && visited[lx][ly] == false) {
                  qx.add(lx);
                  qy.add(ly);
                  visited[lx][ly] = true; 
               }
            }
         }
      }
   }

   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      N = Integer.parseInt(br.readLine());
      map = new int[N][N];
      flood = new int[N][N];
      visited = new boolean[N][N];
      
      maxH = 0; // 최대 높이 
      
      StringTokenizer st;
      for(int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         for(int j=0; j < N; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
            maxH = Math.max(map[i][j], maxH); // 높이의 최대값을 찾음
         }
      }
      
      cnt = 0; // 안전영역의 개수 
      max_cnt = 0;
      
      // BFS 탐색
      for(int i=0; i < N; i++) {
         for(int j=0; j < N; j++) {
        	
        	for(int k = 0; k <= maxH; k++) {
        		if(map[i][j] <= k) { // 잠긴 도시
                    flood[i][j] = 0;
                }
                  
                 else if (map[i][j] > N) { // 안잠긴 도시 
                    flood[i][j] = 1;
                }
        		
        		if(flood[i][j] == 1 && visited[i][j] == false) {
                    BFS(i,j);
                    cnt++;
                 } 
        	}
        	
        	for(boolean a[]:visited) {
        		Arrays.fill(a, false); // 방문 배열 다시 초기화 
        	}
        	
        	for(int b[]: flood) {
            	Arrays.fill(b, 0); // 초기화 
        	}
        	max_cnt = Math.max(cnt, max_cnt);
         }
      }
      
      System.out.println(max_cnt);
   }

}
