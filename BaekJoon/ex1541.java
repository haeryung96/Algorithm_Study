import java.io.*;
import java.util.*;

/*
 * How 구현?
 * 1. 최솟값을 만들기 위해서는 최대한 큰 수를 뺴줘야함 
 * 2. 먼저 '-' 마이너스를 기준으로 문자열을 분리
 * 3. 분리된 문자열들 즉 '+'로 이루어진 정수 값들을 모두 더해줌
 * 4. 각각 더해진 값들을 최종적으로 빼기 
 */

public class ex1541 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		int sum = Integer.MAX_VALUE; // 정수의 최대값

		while(st.hasMoreTokens()) { // 토큰이 남아있을때까지 반복
			int tmp = 0;
			
			// 뺄셈으로 나눈 토큰을 다시 덧셈으로 나누기 
			StringTokenizer plus = new StringTokenizer(st.nextToken(), "+");
			
			// 덧셈으로 나뉜 토큰들을 더하기
			while(plus.hasMoreTokens()) {
				tmp += Integer.parseInt(plus.nextToken());
			}
			
			// 숫자 하나인 경우의 sum은 tmp의 값으로 대체
			// 첫 번째 토큰인 경우 temp 값이 첫 번째 수가 됨 
			if(sum == Integer.MAX_VALUE) { 
				sum = tmp;
			} else  {
				sum -= tmp; // 덧셈으로 나뉜 토큰들을 다 빼주기 
			} 
		}
		System.out.println(sum);
	}
}
