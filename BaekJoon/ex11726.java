import java.io.*;

/*
 * How 구현?
 * 1. DP 사용
 * 2. 점화식 DP[N] = DP[N-1] + DP[N-2]
 */ 

public class ex11726 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		if(N >= 1) dp[1] = 1;
		if(N >= 2) dp[2] = 2;
		
		for(int i=3; i<=N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= 10007; // 
		}
		
//		int res = 0;
//		res = dp[N] % 10007;
		
		System.out.println(dp[N]);
	}
}

/*
 * 주의 
 * % 10007 연산을 마지막에만 해주는 것이 아니라 dp[N]을 구할 때마다 해주어야 함
 * 이유?
 * 나머지 연산 공식 (A + B) % C = (A%C) + (B%C)
 * 위 공식에 따라 dp[n]을 구할때 마다 연산을 해줘야 오버플로우가 나지 않음
 * 마지막에만 해줄 시 중간에 저장되는 값들이 int값을 넘어서기 때문에 오버플로우 발생 
 */
