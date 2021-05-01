import java.io.*;

/*
 * How 구현?
 * 1. Greedy로 풀기
 * 2. A의 기준이 아닌 B의 기준으로 생각하기
 * 3. B가 2로 나눠떨어지거나 끝의 자리수가 1인 경우 연산 수행 
 * 4. 연산이 불가한 조건고려하기 !!!
 */

public class ex16953 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		long A = Long.parseLong(input[0]);
		long B = Long.parseLong(input[1]);
		
		int cnt = 0; // 연산 횟수
		
		while(A != B) {

			String str = String.valueOf(B); // B를 문자열로 변환
			
			// 연산을 계속 하다 B의 값이 A의 값보다 작은 경우 -> 더이상 원하는 수로 만들 수 없다는 의미
			// B의 맨 뒷자리가 1이 아니고 2로 나누어 떨어지지 않는다면 -> 애초에 연산이 불가능한 경우
			if(A > B || B % 2 !=0 && str.charAt(str.length()-1) != '1') { 
				System.out.println("-1");
				return; // break 걸면 -1 두번 출력됨 
			}
			
			if(B %2 == 0) {
				B /= 2;
			}
			else {
				str = str.substring(0, str.length()-1); // 마지막 문자 빼기 -> 1
				B = Long.parseLong(str); // 마지막 1 빼고 다시 문자열을 long형으로 변환
			}
			
			cnt++;
		}
		
		System.out.println(cnt+1);
	}

}
