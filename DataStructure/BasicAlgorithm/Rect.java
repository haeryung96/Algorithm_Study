import java.util.*;

/**
 * 입력한 수를 한 변으로 하는 정사각형을 * 기호로 출력하는 프로그램을 작성하세요.
 * **/

public class Rect {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("사각형을 출력합니다.");
		System.out.print("단 수 :");
		
		
		int n = sc.nextInt(); //단 입력
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

/** 추가 코드 
 * int input = sc.nextInt();
		int cnt = input;
		while (cnt > 0) {
			for (int i = 1; i <= input; i++) {
				System.out.print("*");
			}
			System.out.println();
			cnt--;
		}
 * **/
