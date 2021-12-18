import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex13023 {
    private static int n, m;
    private static ArrayList<Integer>[] list;
    private static boolean[] visited;
    private static boolean isFriend;

    private static void dfs(int x, int depth) {

        // 그래프의 깊이가 4라면 -> 친구 조건 만족
        if (depth == 4) {
            isFriend = true;
        } else {

            for (int i=0; i<list[x].size(); i++) {
                if (!visited[list[x].get(i)]) { // 방문하지 않았다면
                    visited[x] = true;
                    dfs(list[x].get(i), depth+1);

                    if (isFriend) return;
                    visited[x] = false;
                }
            }

        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        visited = new boolean[n];

        for (int i=0; i<n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        // 인접 행렬
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(reader.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }

        for (int i=0; i<n; i++) {
            isFriend = false;
            visited = new boolean[n];
            dfs(i,0); // 각 노드를 탐색

            if (isFriend) { // 친구의 깊이가 4가 만족되면
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}
