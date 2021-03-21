import java.io.*;

/*
 * How 구현?
 * 1. 맨 앞은 0으로 시작할 수 없기 떄문에 1로 고정이며, 1이 연속으로 나올 수 없기 때문에 그 다음은 0으로 고정되어 10 다음에 오는 수를 찾으면 됨 
 * 2. N = 2 -> 10  N = 3 -> 100 101
 * 3. N = 4 -> 10 _ _  이 뒤에 올 숫자는 N = 2에서 10 N = 3에서 1(00) 1(01) 이 가능함
 * 4. 점화식 dp[N] = dp[N-1] + dp [N-2] 도출 
 * */

public class ex2193 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] dp = new long[N+1]; // int 형이 아니라 long형으로 해야 자료형 범위에서 벗어나지 않음 
		
		dp[0] = 0;
		dp[1] = 1;
//		dp[2] = 1;
//		dp[3] = 2;
		
		// 2번부터 돌아야하는 이유는 
		// 논리 오류가 생김 - 만약에 3부터 돌리고 N이 2가 들어오면 for문에서 논리 오류 발생 i는 3인데 i의 범위는 2이하이기 때문 
		for(int i=2; i <= N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[N]);
	}
}
