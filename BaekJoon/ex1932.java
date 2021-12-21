package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// bottom-up 방식으로
// 아래에서부터 계산해서 위로 올라감

public class ex1932 {
    public static int[][] tri; // 정수삼각형
    public static int[][] dp;
    public static int N; // 정수 삼각형 크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tri = new int[N+1][N+1];
        dp = new int[N+1][N+1];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j <= i; j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 삼각형의 맨 아래 부분 dp 채우기
        // 예제로 dp테이블에 4 5 2 6 5 채움
        for(int i = 0; i < N; i++){
            dp[N-1][i] = tri[N-1][i];
            //System.out.print(dp[N-1][i] + " ");
        }

        // bottom-up
        for(int i = N-2; i >= 0; i--){
            for (int j = 0; j <= i; j++){
                // 왼쪽 아래쪽 중에 최대값을 구해서 더함
                dp[i][j] = tri[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        System.out.println(dp[0][0]);
    }
}
