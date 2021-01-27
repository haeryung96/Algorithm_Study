import java.util.*;

/**
 * 배열 a의 모든 요소의 합계를 구하여 반환하는 메소드를 작성하라.
 * **/

public class sumOfarray {
	static int sumOf(int[] a) {
		int sum = 0;
		
		for(int i=0; i<a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	
	static void print(int[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + "");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기 : ");
		int n = sc.nextInt();  //배열의 크기 입력
		int[] a = new int[n];
		
		for(int i=0; i<a.length; i++) {
			a[i] = sc.nextInt();
		}
		
		//print(a);
		System.out.println(sumOf(a));

	}

}
