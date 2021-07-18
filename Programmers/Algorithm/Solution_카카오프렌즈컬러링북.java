package Kakao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
How 구현?
1. BFS를 사용해서 각 해당 값의 넓이를 구하고 그 값을 ArrayList에 저장
2. 저장된 넓이의 값에서 최대값을 구해서 답으로 리턴
3. 영역의 개수는 bfs를 탐색하고 난 후에 cnt를 증가시키면서 값을 갱신 후 리턴 
4. 전역변수 주의!!!!! -> 이 문제의 경우 전역변수로 설정해 둔 변수는 solution에서 다시 초기화를 해줘야 오류가 안남 
*/

public class Solution_카카오프렌즈컬러링북 {
	public static boolean[][] visited;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static Queue<Integer> qx = new LinkedList<>();
    public static Queue<Integer> qy = new LinkedList<>();
    public static int width; // 영역의 넓이 
    public static ArrayList<Integer> maxSize = new ArrayList<>();
    public static int cnt; // 영역의 개수 
    public static int max; // 영역의 최대 넓이 

    public static void BFS(int x, int y, int m, int n, int[][] pic) { // 큐에 들어갈 x,y 좌표, m과n은 그림의 폭과 높이 , pic은 입력받은 그림
        width = 0;
        qx.add(x);
        qy.add(y);

        while(!qx.isEmpty() && !qy.isEmpty()) {
            int tx = qx.poll();
            int ty = qy.poll();
            visited[tx][ty] = true;

            for(int i=0; i < 4; i++) {
                int lx = tx + dx[i];
                int ly = ty + dy[i];

                if(lx >=0 && ly >=0 && lx < m && ly < n) {
                    if(pic[x][y] == pic[lx][ly] && !visited[lx][ly]) {
                        qx.add(lx);
                        qy.add(ly);
                        visited[lx][ly] = true;
                    }
                }
            }
            width++; // 영역의 넓이 // 5 2 2 2
        }
        maxSize.add(width);
    }

    public int[] solution(int m, int n, int[][] picture) {

        visited = new boolean[m][n];
        cnt = 0; // 영역의 개수 
        maxSize = new ArrayList<>(); // 전역변수 다시 초기화해줘야함 

        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(picture[i][j] > 0 && visited[i][j] == false) {
                    BFS(i, j, m, n, picture);
                    cnt++; // 4
                }
            }
        }


        max = 0;
        for(int i=0; i < maxSize.size(); i++) {
            if(max < maxSize.get(i)) {
                max = maxSize.get(i);
            }
        }

        int[] answer = new int[2];
        answer[0] =  cnt;
        answer[1] = max;
        return answer;
    }
}
