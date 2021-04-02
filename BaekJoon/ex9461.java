import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * How 구현?
 * 1. DP[i] = DP[i-2] + DP[i-3] 점화식
 * 2. 모든 값의 DP를 구한 다음에 입력값을 받아서 출력하기 
 */

public class ex9461 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long[] dp = new long[101]; // int형으로 선언하면 연산이21억이 넘어가서 안됨
		
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i=4; i < 101; i++) { // 먼저 모든 값을 넣고 
			dp[i] = dp[i-2] + dp[i-3];
		}
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 
		
		StringTokenizer st;
		for(int i=0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(dp[Integer.parseInt(st.nextToken())]).append('\n'); 
		}
		
		System.out.println(sb);
	}

}
