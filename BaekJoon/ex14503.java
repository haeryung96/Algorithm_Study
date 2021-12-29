package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 왼쪽 방향부터 차례대로 인접한 칸을 탐색
// 방향 -> 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있음
// 왼쪽 방향으로 이동하기 위해서는 방향 인덱스를 3씩 증가시킴

// 현재 위치를 청소한 후에 왼쪽으로 방향을 움직인 뒤, 청소할 공간이라면 청소를 하고 청소하지 못하는 공간이라면 다시 왼쪽으로 방향 전환
// 만약 모든 방향을 다 돌았는데도 청소할 공간이 없거나 벽이라면 한 칸 후진
// 후진까지도 불가능 하면 The end

public class ex14503 {
    static int N, M; // 세로 크기와 가로 크기
    static int[][] map;
    static int r, c, dir;
    static int cnt = 0; // 로봇 청소기가 청소한 공간의 크기 카운트
    static int[] dx = {-1, 0, 1, 0}; // 북,동,남,서
    static int[] dy = {0, 1, 0, -1};

    public static void clean(int x, int y, int dir){
        boolean flag = false; // 4방향이 다 청소되어있거나 벽인 경우

        // 현재 위치 청소 -> 청소된 공간은 값 7로 변경하고 공간 카운트
        if(map[x][y] == 0){
            map[x][y] = 7;
            cnt++;
        }

        int beforeDir = dir;
        // 왼쪽부터 탐색
        for(int k = 0; k < 4; k++){
            int nextDir = (dir + 3) % 4;
            int nextX = x + dx[nextDir];
            int nextY = y + dy[nextDir];

            if(nextX > 0 && nextY > 0 && nextX < N && nextY < M){
                if (map[nextX][nextY] == 0){ // 아직 청소하지 않은 공간이라면
                    clean(nextX, nextY, nextDir);
                    flag = true;
                    break;
                }
            }
            dir = (dir + 3) % 4; // 방향전환
        }
        // 만약 모든 방향이 청소됐고 벽인 경우는 후진
        if(!flag){
            int nextDir = (beforeDir + 2) % 4;
            int nextDx = x + dx[nextDir];
            int nextDy = y + dy[nextDir];

            if(nextDx > 0 && nextDy > 0 && nextDx < N && nextDy < M) {
                if(map[nextDx][nextDy] != 1) { // 벽이 아니라면
                    clean(nextDx, nextDy, beforeDir);
                    //clean(nextDx, nextDy, nextDir);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 맵의 세로와 가로 길이 입력받기
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];

        // 로봇청소기의 좌표와 방향
        String[] input2 = br.readLine().split(" ");
        r = Integer.parseInt(input2[0]);
        c = Integer.parseInt(input2[1]);
        dir = Integer.parseInt(input2[2]);

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                /*System.out.print(map[i][j] + " ");*/
            }
        }

        clean(r, c, dir);
        System.out.println(cnt);
    }
}
