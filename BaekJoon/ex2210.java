package BOJ;
// 숫자판 점프
// 만들 수 있는 서로 다른 6자리 수
// 조합으로 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ex2210 {
    static int[][] map;
    static boolean[][] visited;
    static HashSet<String> hs = new HashSet<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt;

    public static void comb(int x, int y, int r, String str){
        if(r == 0){ // 다 뽑았다면
            hs.add(str);
//            cnt++;
            return;
        }

        // 상하좌우 이동
        for(int k = 0; k < 4; k++){
            int nx = dx[k] + x;
            int ny = dy[k] + y;

            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5){
                continue;
            }

            comb(nx, ny, r-1, str+map[x][y]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[5][5];
        visited = new boolean[5][5];
        cnt = 0;

        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String str = "";
        for(int i = 0; i < 5; i++){

            for(int j = 0; j < 5; j++){
                comb(i, j, 6, str);
            }
        }

        System.out.println(hs.size());
    }
}
