import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * How 구현?
 * 1. 점화식 세우기 - 다이나믹 프로그래밍
 * 2. dp[4]의 경우 dp[3] 의 값들에서 1을 더하면 dp[4] 나오고 dp[2] 의 값들에서 2를 더하면 나오고 dp[1] 의 값들에서 3을 더하면 나옴
 * 3. 따라서, dp[4] 의 경우의 수는 dp[3]의 경우, dp[2]의 경우 , dp[1]의 경우를 더하면 값을 구할 수 있음 
 */

public class ex9095 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[11]; // n은 11보다 작음 10까지 - 문제에서 주어짐
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		// 모든 경우의 수를 구함
		for(int i=4; i < 11; i++) { // 4 ~ 10 만큼 돌기
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3]; // 11까지의 모든 경우의 값을 구함 
		}
		
		while(N-- > 0) { // N은 하나씩 감소시키면서 0보다 클때까지만 돌기 
			int num = Integer.parseInt(br.readLine()); // 값을 입력받고
			
			System.out.println(dp[num]);
		}
	}
}
