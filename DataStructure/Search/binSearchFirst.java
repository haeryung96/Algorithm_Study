import java.util.*;

/**
 * 이진 검색 알고리즘 프로그램은 검색할 값과 같은 값을 갖는 요소가 하나 이상일 경우 그 요소 중에서 맨 앞의 요소를 찾지 못함.
 * 맨 앞의 요소를 찾는 binSearchX 메소드를 작성해라.
 * **/

public class binSearchFirst {
	
	static int binSearch(int[] a, int n, int key) {
		int pl = 0; //맨 앞의 값
		int pr = n-1;
		
		do {
			int pc = (pl + pr) /2;
			if(a[pc] == key) {    //가운데의 요소값이 키값인 경우
				//pc의 값을 감소시킨 다음에 키의 값보다 작으면 무한루프 멈춤
				while(true) {
					pc--;
					if(a[pc-1] < key)
						break;
					return pc-1;
				}	
			}
			else if(a[pc] < key) {
				pl = pc+1;
			}
			else
				pr = pc-1;
		} while(pl<=pr);
		
		return -1; //검색 실패
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int t = sc.nextInt();
		int[] x = new int[t];
		
		System.out.print("x[0]："); // 맨 앞 요소를 읽어 들임
		x[0] = sc.nextInt();
		
		for (int i = 1; i < t; i++) {
			do {
				System.out.print("x[" + i + "]：");
				x[i] = sc.nextInt();
			} while (x[i] < x[i - 1]);		// 바로 앞의 요소보다 작으면 다시 입력
		}

		System.out.print("찾는 값：");		// 키값을 입력
		int ky = sc.nextInt();
		
		int idx = binSearch(x, t, ky);
		
		if (idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(ky+"은(는) x[" + idx + "]에 있습니다.");
	}

}
