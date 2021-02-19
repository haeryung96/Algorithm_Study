package nadongbin;
import java.util.*;

/*
 * 1이 될때까지
 * 어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다.
 * 단, 두 번째 연산은 N이 k로 나누어 떨어질때만 선택할 수 있다.
 * 1. N에서 1을 뺸다.
 * 2. N을 K로 나눈다.
 * */

public class ex03_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int cnt = 0; //횟수
		
		while(n!=1) { // n이 1이 될때까지 반복
			if(n%k == 0) { // 입력된 수 n이 k로 나눠 떨어진다면
				n /= k;
				cnt++;
			}
			else {
				n -= 1;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
