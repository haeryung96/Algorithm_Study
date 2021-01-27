import java.util.*;

/**
 * 배열 요소를 역순으로 정렬하는 과정을 하나하나 나타내는 프로그램을 작성하라.
 * **/

public class swapNreverse {
	
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	//배열 a의 요소를 역순으로 정렬 
	static void reverse(int[] a) {
		for(int i=0; i<a.length/2; i++) {
			System.out.println("a["+i+"]과(와) a["+((a.length-i)-1)+"]를 교한합니다.");
			swap(a, i, a.length-i-1);
			print(a);
		}
	}
	
	static void print(int[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+ " ");
		}
		System.out.println("");   //개행
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기 : ");
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0; i<a.length; i++) {
			a[i] = sc.nextInt();
		}
		
		print(a);
		
		reverse(a);
		
		System.out.println("역순 정렬을 마쳤습니다.");

	}

}
