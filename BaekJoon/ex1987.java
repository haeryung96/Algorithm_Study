package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1987 {
    static int r, c;
    static int[][] map;
    static boolean[] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxCnt = 0; // 문자의 길이와 지나가는 칸의 수는 동일한 개념

    public static void DFS(int x, int y, int len) {
        visited[map[x][y]] = true;
        maxCnt = Math.max(len, maxCnt);

        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(0 <= nx && 0 <= ny && nx < r && ny < c){
                if(visited[map[nx][ny]] == false){ // 아직 방문하지 않은 알파벳이라면
                    visited[map[nx][ny]] = true;
                    DFS(nx, ny, len+1);
                    visited[map[nx][ny]] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        map = new int[r][c];
        visited = new boolean[26]; // 알파벳 26개

        for(int i = 0; i < r; i++){
            String alpha = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = alpha.charAt(j) - 'A'; // 숫자로 변환 A는 0부터
            }
        }

        DFS(0, 0, 1);
        System.out.println(maxCnt);
    }
}
