import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * How 구현?
 * 1. 구할 영역을 모두 0으로 map에 그려질 영역을 모두 1로 채움
 * 2. 영역의 넓이는 BFS 메소드 안에서 상하좌우 탐색이 완료되면 증가시켜서 list에 넣어줌
 * 3. list에 넣어준 값을 main에서 정렬한 뒤 출력
 */

public class ex2583 {
   public static int map[][];
   public static boolean visited[][];
   public static int M, N, K;
   public static int[] dx = {1, -1, 0, 0};
   public static int[] dy = {0, 0, 1, -1};
   public static Queue<Integer> qx = new LinkedList<>();
   public static Queue<Integer> qy = new LinkedList<>();
   public static int width;
   public static ArrayList<Integer> list = new ArrayList<Integer>();
   
   public static void BFS(int x, int y) {
      width = 0;
      qx.add(x);
      qy.add(y);
      
      while(!qx.isEmpty() && !qy.isEmpty()) {
         int tx = qx.poll();
         int ty = qy.poll();
         visited[tx][ty] = true;
         
         for(int k=0; k < 4; k++) {
            int lx = tx + dx[k];
            int ly = ty + dy[k];
            
            if(lx >=0 && ly >=0 && lx < N && ly < M) {
               if(map[lx][ly] == 0 && visited[lx][ly] == false) {
                  qx.add(lx);
                  qy.add(ly);
                  visited[lx][ly] = true;
               }
            }
         }
         width++; // 넓이 
      }
      
      list.add(width);

   }

   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] input = br.readLine().split(" ");
      
      M = Integer.parseInt(input[0]); // 
      N = Integer.parseInt(input[1]); // 
      K = Integer.parseInt(input[2]); // k개의 직사각형
      
      map = new int[N][M];
      visited = new boolean[N][M];
      
      StringTokenizer st;
      for(int i = 0; i < K; i++) {
         st = new StringTokenizer(br.readLine()," ");
         
         int x1 = Integer.parseInt(st.nextToken()); // 왼쪽 위 x좌표
         int y1 = Integer.parseInt(st.nextToken()); // 왼쪽 위 y좌표
         int x2 = Integer.parseInt(st.nextToken()); // 오른쪽 아래 x좌표
         int y2 = Integer.parseInt(st.nextToken()); // 오른쪾 아래 y좌표
         
         
         for(int j = x1; j < x2; j++) {
            for(int k = y1; k < y2; k++) {
               map[j][k] = 1;
            }
         }
      }
      
      int cnt = 0;
      int w[] = new int[N*M];
      
      for(int i=0; i < N; i++) {
         for(int j=0; j < M; j++) {
            if(map[i][j] == 0 && visited[i][j] == false) { // 0으로 채워진 공간 탐색 
               BFS(i,j);
               cnt++; // 영역의 개수 
            }
         }
      }
      
      System.out.println(cnt);
      
      Collections.sort(list); // 넓이 오름차순으로 정렬 
      
      for(int i=0; i < list.size(); i++) {
    	  System.out.print(list.get(i) + " ");
      }
   }

}
