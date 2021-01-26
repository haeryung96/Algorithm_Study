import java.util.*;

/**
 * 1+ 2+ 3+ ... + n = sum을 출력하는 프로그램을 작성해라
 * **/

public class sumOf {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		
		for(int i=1; i<=n; i++) {
			if(i<n) {
				System.out.print(i + " + " );
			}else {
				System.out.print(i + " = ");
				}
			sum+=i;
		}
		System.out.print(sum);
	}
}
