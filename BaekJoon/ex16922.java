package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 순서를 생각하지 않음 -> 조합을 사용 (백트래킹)
// 단, 숫자를 더했을때 같은 수가 있을 수 있으므로 중복된 수는 걸러냄
public class ex16922 {
    static int[] arr = {1, 5, 10, 50};
    static int N, ans;
    static boolean[] visited = new boolean[100000];

    static void perm(int depth, int index, int sum){
        if(depth == N){
            if(!visited[sum]){
                visited[sum] = true;
                ans++;
            }
            return;
        }

        for(int i = index; i < 4; i++){
            perm(depth+1, i, sum + arr[i]);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        perm(0, 0, 0);
        System.out.println(ans);
    }
}
