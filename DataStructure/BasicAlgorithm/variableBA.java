import java.util.*;

/**
 * 두 변수 a, b에 정수를 입력하고 b-a를 출력하는 프로그램을 작성하라.
 * **/

public class variableBA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a ;
		int b ;
		int sum;
		
		System.out.print("a의 값:");
		a = sc.nextInt();
		
		while(true) {
			System.out.print("b의 값:");
			b = sc.nextInt();
			if(a>b) {
				System.out.println("a보다 큰 값을 입력하세요!");
				break;
			}
		}
		System.out.println("b-a는 " + (b-a) + "입니다.");
	}
}
