import java.io.*;

/*
 * How 구현?
 * 1. dp[N][K] : N의 자리 숫자의 마지막 자리에 올 숫자를 K로 설정
 * 2. 마지막 자리수가 1인 경우 앞에 올 수 있는 숫자는 0과 1 
 * 3. 1) 2인 경우 앞에올 수 있는 숫자는 0과 1,2 .... 2) 9인 경우 앞에 올 수 있는 숫자는 0,1,2...,9
 * 4. 위의 과정처럼 하나씩 증가하는 규칙을 알 수 있음
 * 5. 결론적으로 마지막 자리수에 들어올 수 있는 숫자의 경우의 수는 0부터 마지막 자리수를 포함한 숫자까지
 * 6. 내가 틀린 이유 -> 모듈러 연산을 해줘야하는 이유는 원래 값이 너무 커서 오버플로우가 나기 때문
 *    오버플로우가 나지 않는 범위 내에서느 ㄴ모듈러 연산없이 진행하고 중간 결과값에만 모듈러 연산을 취해줘도 되지만, 귀찮기 때문에 연산을 할때마다 모듈러 연산하기 
 */

public class ex11057 {
	static int dp[][];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1][10]; // N -> 자릿수 10 -> 마지막 숫자자리에 올 수 있는 수의 가짓수
		
		// dp의 첫번째 자릿수에서 마지막 숫자자리에 올 수 있는 경우의 수를 채우기 
		for(int i=0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		// 모든 dp의 값을 구하기
		for(int i=2; i <= N; i++) { // N의 값 -> 자릿수에 대한 반복문
			for(int j=0; j < 10; j++) { // 마지막 자리에 올 수 있는 수에 대한 반복문 
				for(int k=0; k <= j; k++) { // k의 값은 j를 포함한 수까지 가능     
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 10007;
				}
			}
		}
		
		int sum = 0;
		
		for(int i=0; i < 10; i++) {
			sum += dp[N][i];
		}
		
		System.out.println(sum%10007);
	}
}
