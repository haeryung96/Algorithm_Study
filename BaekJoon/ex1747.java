import java.io.*;

// 문제조건 : N보다 크거나 같고, 소수이면서 팰린드롬인 수 중에서 가장 작은 수를 구해라 

/*
 * How 구현?
 * 1. 입력된 수부터 하나하나 소수이면서 펠린드롬인 수를 찾음
 * 2. 펠린드롬은 문자열의 길이를 기준으로 첫번째 문자와 마지막 문자를 비교
 * 3. 소수 구하기 -> 에라토스테네스의 체 사용 가장 빠른 소수 구하는 알고리즘 
 */

public class ex1747 {
	
	// 소수 판별
	public static boolean isPrime(int num) {
		
		if (num == 0) { // 0은 소수 아님 
			return false;
		}
		
		if(num == 1) { // 1은 소수 아님
			return false;
		}
		
		for(int i=2; i <= Math.sqrt(num); i++) {
			// 소수가 아닌 경우
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	// 팰린드롬 수 인지 확인
	public static boolean isPelin(String str) {
		
		if(str.length()%2 == 0) { // 입력된 숫자의 길이가 짝수인 경우
			for(int i=0; i < str.length()/2; i++) {
				if(str.charAt(i) != str.charAt(str.length()-i-1)) { // 팰린드롬이 아닌 경우
					return false;
				}
			}
		}
		
		else if(str.length()%2 == 1) { // 입력된 숫자의 길이가 홀수인 경우 
			for(int i=0; i < str.length()/2; i++) {
				if(str.charAt(i) != str.charAt(str.length()-i-1)) { // 팰린드롬이 아닌 경우
					return false;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int N = Integer.parseInt(br.readLine());
		
		while(true) {
			
			if(isPelin(Integer.toString(N)) && isPrime(N)) {
				System.out.println(N);
				return;
			}
      
			N++;
		}
	}

}
