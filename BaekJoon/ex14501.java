import java.io.*;

// 최대한 많은 상담을 잡아야하며,하루에 하나씩 서로 다른 상담을 잡아놓음 
// N+1 일에 퇴사, N일에 최대한 많은 상담해야함 
// 14퍼센트에서 자꾸 틀림 왜? -> 반례 고쳐야함 

public class ex14501 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 테스트 케이스 
		
		int[][] arr = new int[N+1][N+1];
		
		// 날짜와 비용 입력받기
		for(int i = 1; i <= N; i++) {
			String[] input = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(input[0]); // 시간 - 날짜 
			arr[i][1] = Integer.parseInt(input[1]); // 비용
		}
				
		int[] dp = new int[N+2];
		
//		if(N >= 1) dp[1] = arr[0][1];
//		if(N >= 2) {
//			if(arr[0][0] == arr[1][0]) {
//				dp[2] = arr[0][1] + arr[1][1];
//			}
//			else {
//				dp[2] = Math.max(arr[0][1], arr[1][1]);
//			}
//		}
		
		// dp 구하기 
		for(int i = N; i > 0; i--) {
			int nextDay = i + arr[i][0]; // i는 날짜 arr[i][0]은 상담이 걸리는 날짜 
			
			// 만약 상담기간이 주어진 날짜보다 더 커진다면
			if(nextDay > N + 1) {
//				dp[i] = dp[i+1];
				continue;
			}
			else { // 돈을 더 많이 버는 경우 계산 
				dp[i] = Math.max(dp[i+1], dp[nextDay] + arr[i][1]);
			}
			
		}
		
		System.out.println(dp[1]);
	}

}

/*
 * 2

3 100

1 10

정답 : 10

코드 결과 : 0
 * */
 
