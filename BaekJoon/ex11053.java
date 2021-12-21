package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex11053 {
    static int N; // 수열의 크기
    static int[] dp;
    static int[] arr;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            dp[i] = 1;
            // 앞의 원소값이랑 비교하면서 값을 갱신
            for(int j = 0; j < i; j++){
                // 증가하는 부분 수열일 경우
                if(arr[j] < arr[i]){
                    // 최대값으로 갱신
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
