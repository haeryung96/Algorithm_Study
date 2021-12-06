package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 상근이는 1번
public class ex5567 {

    public static int N, M;
    public static int[][] map;
    public static boolean[] visited;
    public static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 상근이의 동기의 수
        M = Integer.parseInt(br.readLine()); // 리스트의 길이

        StringTokenizer st;
        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            // 양방향
            map[p1][p2] = map[p2][p1] = 1;
        }

        for(int i=2; i < N+1; i++) {

            if(map[1][i] == 1) { // 상근이와 친구인 노드라면
                if(!visited[i]) { // 친구인데 검사를 하지않았다면
                    set.add(i); // 노드를 넣고
                    visited[i] = true;
                }

                for(int j=2; j < N+1; j++) {
                    // i번의 친구를 찾아서 초대
                    if(map[i][j] == 1 &&  !visited[j]) {
                        set.add(j);
                        visited[j] = true;
                    }
                }
            }
        }

        System.out.println(set.size());

    }

}
