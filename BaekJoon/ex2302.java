package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// VIP석은 고정 좌석 & Not VIP 좌석은 그 좌석과 바로 왼쪽 오른쪽 이동 가능

/*
* 고정석 제외하고 생각하면 N=1 이면 1가지
* N = 2이면 12 21 2가지
* N = 3이면 123 213 132 3가지
* N = 4이면 1234 2134 1324 1243 2143 5가지
* dp[N] = dp[N-1] + dp[N-2]
*
* VIP 석이 있다면 ?
* VIP 석을 기준으로 구역을 나누고 각각의 dp 값을 곱하면 됨.
*/
public class ex2302 {
    static int N; // 좌석의 개수
    static int M; // 고정석의 개수
    static int[] dp;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dp = new int[N+2];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;

        for(int i = 5; i <= N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        ans = 1;
        int start = 0; // 시작점
        int end = 0; // 끝점
        for(int i = 0; i < M; i++){
            end = Integer.parseInt(br.readLine());
            ans *= dp[end - start - 1];
            start = end;
        }

        // 마지막 안곱해지는거 다시 곱하기
        ans *= dp[N - end];
        System.out.println(ans);
    }
}
