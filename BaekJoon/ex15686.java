package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 0은 빈칸, 1은 집, 2는 치킨집
// 치킨 거리는 집과 가장 가까운 치킨집 사이의 거리
// 인덱스의 시작은 1,1 이고 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|

/*
* 로직
* 1. 집과 치킨집 배열을 따로 저장한다.
* 2. M개를 뽑아야하기 때문에 치킨집 배열을 DFS돌리면서 M개를 뽑는다.
* 3. M개를 다 뽑았다면 집과의 거리를 구해서 누적합을 구한다.
* 4. 누적합 중에서 거리가 가장 작은 값을 구해서 출력한다.
* */

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

    public static void main(String[] args) throws IOException {
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
    // M개를 구했다면 집과 치킨집 사이의 거리를 계산
    public static void combination(int start, int cnt) {
        if(cnt == M) {
            int sum = 0; // 치킨집 기준으로 집과의 거리들의 합

            for(int i = 0; i < home.size(); i++) {
                int min = Integer.MAX_VALUE;
                // 선택된 치킨집들까지의 치킨 거리의 최솟값
                for(int j = 0; j < chicken.size(); j++) {
                    if(visited[j] == true) {
                        //System.out.println(visited.length);
                        int dist = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);
                        min = Math.min(min, dist);
                    }
                }
                sum += min;

            }
            answer = Math.min(answer, sum);
            return;
        }

        for(int i = start; i < chicken.size(); i++) {
            visited[i] = true;
            combination(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}
