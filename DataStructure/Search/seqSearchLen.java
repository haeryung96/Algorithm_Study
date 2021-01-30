import java.util.*;

/**
 * 요솟수가 n인 배열 a에서 key와 일치하는 모든 요소의 인덱스를 배열 idx의 맨 앞부터 순서대로 저장하고,
 * 일치한 요솟수를 반환하는 메소드를 작성하라.
 * 예를 들어 요솟수가 8인 배열 a의 요소가 {1, 9, 2, 9,4, 6, 7, 9}이고 key가 9인 배열 idx에 {1, 3, 7}을 저장하고 3을 반환
 * **/

/**
 * 순차 검색을 이용하라.
 * **/

/**
 * How 구현?
 * 1. 먼저 key값이 있는 인덱스를 구한다.
 * 2. 인덱스를 새로운 배열에 넣는다.
 * 3. 새로운 배열의 길이를 반환한다.
 * **/

public class seqSearchLen {
	
	// 배열 a에서 값이 key인 값을 구함
	static int seqSearchSen(int[] a, int n, int key) {
		int i = 0;
		int cnt = 0;
		
		for(i=0; i<n; i++) {
			if(a[i] == key) {
				cnt++;
			}
		}
		return cnt;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		
		int t = sc.nextInt();
		int[] x = new int[t];
		
		// 요소값 입력받기
		for(int i=0; i<t; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int ky = sc.nextInt();
		
		seqSearchSen(x, t, ky);
		
		System.out.println(seqSearchSen(x, t, ky));
		
	}

}
