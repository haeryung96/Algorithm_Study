import java.util.*;
/**
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * **/

/**
 * How 구현?
 * 퀵정렬을 사용해서 오름차순으로 정렬함
 * **/

public class ex2750 {
		// 배열의 원소를 해당하는 인덱스의 위치의 값으로 바꿈
		static void swap(int[] a, int i, int j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		
		// 퀵 정렬
		static void quickSort(int[] a, int left, int right) {
			int pl = left;   // 왼쪽 값
			int pr = right;  // 오른쪽 값
			int p = a[(pl + pr) / 2 ];   // 피봇값
			
			do {
				while(a[pl] < p) pl++; // 왼쪽의 값이 피봇의 값보다 작으면 교환할 필요 없으므로 pl의 익덱스 값 증가
				while(a[pr] > p) pr--; // 오른쪽의 값이 피봇보다 값이 크면 교환할 필요 없으므로 pr의 인덱스 값 감소
				if(pl <= pr) // 왼쪽의 값이 오른쪽 값보다 작다면 
					swap(a, pl++, pr--);
			}while(pl <= pr);
			
			if(left < pr) quickSort(a, left, pr);  // 재귀 호출 왼쪽 그룹 다시 나누기
			if(pl < right) quickSort(a, pl, right); // 재귀 호출 오른쪽 그룹 다시 나누기
		}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 테스트 개수 입력받기
		
		int[] a = new int[t]; // 오름차순으로 정렬할 배열 생성
		
		for(int i=0; i<t; i++) {
			//if(a[i])
			a[i] = sc.nextInt(); // 배열의 원소 크기만큼 반복 돌려서 입력받기
		}
		quickSort(a, 0, t-1);
		
		for(int i =0; i<t; i++) {
			System.out.println(a[i]);
		}

	}
}
