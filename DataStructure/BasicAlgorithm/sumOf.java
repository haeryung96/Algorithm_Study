import java.util.*;

/**
 * 정수 a,b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환하는 메소드 작성해라.
 * **/

public class sumOf {
	public static int sumof(int a, int b) {
		int sum = 0;
		if(a<b) {
		  for(int i=a; i<=b; i++) {
			sum+=i;
		  }
		}
		else if(a>b) {
			for(int i=b; i<=a; i++) {
				sum+=i;
			  }
		}
		else return 0;
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(sumof(a,b));

	}

}
