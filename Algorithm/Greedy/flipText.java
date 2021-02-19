import java.util.*;
/*
 * 문자열 뒤집기
 * 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 함
 * 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미함
 */

public class flipText {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next(); // 문자열로 받기
		int zero = 0;
		int one = 0;
		
		// 첫번쨰가 0으로 시작하면 zero 그룹 만들기 1이면 one 그룹 만들기
		if(n.charAt(0) == '0') { // 첫번째 문자가 0이라면
			zero++; 
		}else if(n.charAt(0)=='1') {
			one++;
		}

		// 2번째 원소부터 검색 시작
		for(int i=1; i<n.length(); i++) {
			if(n.charAt(i-1)== '1' && n.charAt(i)== '0') { // 앞의 원소가 1이고 뒤의 원소가 0이면
				zero++; // 0인 그룹 생성
			}
			else if(n.charAt(i-1) == '0' && n.charAt(i) == '1') { // 앞의 원소가 0이고 뒤의 원소가 1이면
				one++;
			}
		}
		System.out.println(Math.min(zero, one));

	}

}
