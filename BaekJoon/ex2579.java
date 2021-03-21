import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * How 구현?
 * 1. 2가지의 경우의 수 
 * 2. N번째 계단은 무조건 밟아야하기 때문에 N번째 1번 연속인 경우와 
 * 3. N번째 계단이 2번 연속인 경우가 존재함
 * 4. 예를 들어, 3번째 계단에 서있다고 하면 3 -> 4 인 경우와 3 -> 5 로 가는 경우임
 * 
 * 주의 *
 * 계단은 한번에 한계단씩 또는 두계단 씩 오를 수 있다. 즉, 한계단을 오르면 다음 계단으로 가거나 한계단을 오르면 다다음 계단을 올라야한다.
 * */

public class ex2579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1]; // 계단 값
		int[] dp = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 0;
		dp[1] = arr[1];
		if(N >=2) dp[2] = arr[1] + arr[2]; // 계단의 수가 2 이상인 경우만 가능하기 때문에 조건문을 달아줘야함 안달아주면 ArraysOutOfIndex 에러뜸 
				
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]); // 점화식 
		}
		
		System.out.println(dp[N]);
	}
}
