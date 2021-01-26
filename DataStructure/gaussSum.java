import java.util.*;

/**
 * 1부터 n까지의 정수 합을 구하는 프로그램을 작성하시오.
 * 단, 가우스의 덧셈이라는 방법을 이용하라.
 * **/

public class gaussSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = (n+1)*(n/2)+(n%2==1?(n+1)/2:0);
		
		System.out.println(sum);
	}
}
