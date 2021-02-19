import java.util.*;

/*
 * How 구현?
 * 1. 첫번째 원소가 1인 경우 1그룹에 0인 경우 0그룹에 넣기
 * 2. 두번째 원소부터 검사 시작
 * 3. i-1번째 원소가 1이고 i번째 원소가 0이면 0그룹의 시작을 의미하므로 zer0++하기
 * 4. i-1번째 원소가 0이고 i번째 원소가 1이면 1그룹의 시작을 의미하므로 one++
 * 5. zero와 one 중에서 최소값을 출력 
 * */

public class ex1439 {

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
