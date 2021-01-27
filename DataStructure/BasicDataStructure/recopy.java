import java.util.*;

/**
 * 배열 b의 모든 요소를 배열 a에 역순으로 복사하는 메소드 rcopy를 작성하라.
 * **/

public class recopy {
	static void rcopy(int[] a, int[] b){
		for(int i=0; i<a.length; i++) {
			b[i] = a[b.length-i-1];
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기 : ");
		int n = sc.nextInt();
		
		int[] a = new int[n];
		int[] b = new int[n];
		
		for(int i=0; i<a.length; i++) {
			a[i] = sc.nextInt();
		}
		
		rcopy(a,b);
		
		for(int i=0; i<b.length; i++) {
		   System.out.print(b[i] + " ");
		}
	}

}
