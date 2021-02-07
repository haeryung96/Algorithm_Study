import java.util.*;
/**
 * 한수 구하기
 * 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 
 * 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
 * N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 
 * **/

/**
 * How 구현?
 * 한 자리 수의 경우 1,2,3 ... 은 따로 비교할 수가 없으므로 한수
 * 2 자리 수의 경우 10, 11, 12,....,99는 구할 수 있는 공차가 1개이므로 한수
 * 3 자리 수부터 값을 구하면 됨
 * 4 자리 수의 경우 1000이상이 되므로 break를 걸어줘서 나오게 하자.
 * **/

public class ex1065 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int cnt = 0; // 한수가 몇개 있는지
		
		// 한자리 수, 두자리 수 인경우 자기 자신만큼 한수를 가짐
		if(t < 100) {
			System.out.println(t);
		}
		
		// 3자리 수 부터는 무조건 99부터 시작
		
		else {
			cnt = 99;
			for(int i=100; i<=t; i++) {
				int th = i/100; // 100의 자리 수
				int two = (i/10) % 10; // 10의 자리 수
				int one = i % 10; // 1의 자리 수
				
				// 등차 수열인지 확인하기 위해서
				if((th - two) == (two -one)) {
					cnt ++;
				}
			}
			// 4자리 수가 되는 경우
			if(t == 1000) {
				//t = 999;
				cnt = 144;
			}
			System.out.println(cnt);	
		}

	}

}
