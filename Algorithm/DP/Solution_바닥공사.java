package nadongbin;
import java.io.*;

public class Solution_바닥공사 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		// 1*2 를 채울 수 있는 경우의 수 
		dp[1] = 1;
		// 2*2 를 채울 수 있는 경우의 수 -> 1*2 2개, 2*1 2개, 2*2 1개
		dp[2] = 3;
		// 3*2를 채울 수 있는 경우의 수 -> 1*2 3개, (2*1 2개 1*2 1개 ) 2개, (2*2 1개 1*2 1개) 2개
		dp[3] = 5;
		
		for(int i=4; i <= N; i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2]) % 796796;
		}
		
		System.out.println(dp[N]);
	}

}
