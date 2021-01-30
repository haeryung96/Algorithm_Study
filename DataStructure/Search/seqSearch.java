import java.util.*;

/**
 * 순차 검색 알고리즘을 작성하라.
 * **/

public class seqSearch {
	static int seqSearchSen(int[] a, int n, int key) {
		int i = 0;
		
		a[n] = key;         //보초를 추가
		
		for(i=0; i<n; i++) {
			if(a[i] == key) {
				break;
			}
			i++;
		}
		return i == n? -1 : i;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = sc.nextInt();
		int[] x = new int[num+1];
		
		for(int i = 0; i<num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int ky = sc.nextInt();
		
		int idx = seqSearchSen(x, num, ky);
		
		if(idx == -1) {
			System.out.println("그 값의 요소가 없습니다.");
		}else
			System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");

	}

}
