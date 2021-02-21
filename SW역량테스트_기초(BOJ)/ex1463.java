import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
 * How 구현?
 * 1. 6으로 나눠지는 경우는 3으로 나누는 경우와 2로 나누는 경우, 1을 빼는 경우 모두 재귀호출하여 최솟값으로 갱신
 * 2. 3으로만 나눠지는 경우는 3으로 나누는 경우와 1을 빼는 경우를 재취호줄
 * 3. 2로만 나눠지는 경우는 2로 나누는 경우와 1을 빼는 경우를 재귀호출
 * 4. 그외에는 1을 빼는 경우만 재귀호출 해주면 됨 
 * */

public class ex1463 {
	
	public static int recur(int n) { // 재귀함수로 구현
		if(memo[n] == null) { //최소 연산의 값을 아직 구하지 않았다면 시작
			// 6으로 나눠지는 경우
			if(n % 6 == 0) {
				memo[n] =  Math.min(recur(n - 1), Math.min(recur(n / 3), recur(n / 2))) + 1;
			}
			// 3으로만 나눠지는 경우 
			else if (n % 3 == 0) {
				memo[n] = Math.min(recur(n / 3), recur(n - 1)) + 1;
			}
			// 2로만 나눠지는 경우 
			else if (n % 2 == 0) {
				memo[n] = Math.min(recur(n / 2), recur(n - 1)) + 1;
			}
			// 2와 3으로 나누어지지 않는 경우
			else {
				memo[n] = recur(n - 1) + 1;
			}
		}
		return memo[n];
	}
	
	static Integer[] memo; // n을 1로 만드는 최소연산의 배열

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 정수 n 입력
		
		memo = new Integer[n+1];
		memo[0] = memo[1] = 0; // 0과 1을 1로 만드는 최소 연산은 0번
		
		System.out.println(recur(n));
	}

}
