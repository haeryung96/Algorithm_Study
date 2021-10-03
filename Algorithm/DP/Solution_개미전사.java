package nadongbin;
import java.io.*;

public class Solution_개미전사 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N+1];
		
		String[] input = br.readLine().split(" ");
		for(int i=0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		
		for(int i=2; i < N; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
		}
		
		System.out.println(dp[N-1]);
	}

}
