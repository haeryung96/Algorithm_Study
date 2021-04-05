import java.io.*;

/*
 * How 구현?
 * 1. 다이나믹 프로그래밍
 * 2. dp[n] = dp[n-1] + dp[n-2]
 */

public class ex1904 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1000001];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for(int i=4; i < 1000001; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 15746;
		}
		
		System.out.println(dp[N]);
 	}

}
