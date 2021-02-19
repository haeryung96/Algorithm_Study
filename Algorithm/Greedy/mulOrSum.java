package nadongbin;

import java.util.*;

/*
 * 숫자 사이에 * 또는 + 연산자를 넣어
 * 결과적으로 만들어질 수 있는 가장 큰 수를 구하는 프로그램을 작성하시오.
 * */

public class mulOrSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next(); // 여러개의 숫자로 구성된 하나의 문자열
		
		int res = n.charAt(0) - '0'; // 첫번째 문자를 숫자로 변경 
		
		for(int i =1; i<n.length(); i++) {
			int num = n.charAt(i) - '0';
			// 입력된 값이 0,1면 무조건 곱하기 하는 것이 최대값 구할 수 있음
			// 0을 곱하면 0이 되고 1을 곱하면 그대로이기 때문에 더하는것이 최대값 구할 수 있음
			if(res <=1 || num <=1) {
				res += num;
			}else { // 0과 1을 제외한 나머지 숫자는 곱하는 것이 최대값 구할 수 있음 
				res *= num;
			}
		}
		System.out.println(res);
	}
}
