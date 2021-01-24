import java.util.*;

/** 
 *  N개의 정수로 이루어진 배열A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서
 *  다음 식의 최댓값을 구하는 프로그램을 작성하시오.
 *  |A[0]-A[1]| + |A[1]-A[2]| + ... + |A[N-2] + A[N-1]|
 * **/

/**
 * 순열로 푸는 이유는 정수의 순서를 적절히 바꿔서 즉, 순서를 중요시하기 때문
 * **/

public class ex10819 {
	public static boolean permutation(int[] a) {
		int i = a.length-1;
		
		while(i>0 && a[i-1]>=a[i]) {
			i-=1;
		}
		
		if(i<=0) return false;
		
		int j = a.length-1;
		
		while(a[i-1] >= a[j]) {
			j-=1;
		}
		
		swap(a,i-1,j);
		
		j = a.length-1;
		
		while(i<j) {
			swap(a,i,j);
			i++;
			j--;
		}
		return true;
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static int calc(int[] a) {
		int sum = 0;
		for(int i=1; i<a.length; i++) {
			sum += Math.abs(a[i]-a[i-1]); //Math.abs는 값을 양수로 반환하는 함수 
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt(); //테스트 개수 입력
		int[] a = new int[t];
		
		for(int i=0; i<a.length; i++) {
			a[i] = sc.nextInt();
		}
		//정렬을 해줘야하는 이유는 첫순열은 사전순으로 오름차순임
		//순열의 경우 이미 정렬이 되어있지만 여기서는 랜덤으로 값을 입력받고 있기 때문에 정렬을 한 후에 값을 구해야함
		Arrays.sort(a); 
		int ans = 0;
		do {
			int s = calc(a);
			ans = Math.max(ans, s); // ans와 s의 값중에서 큰값을 반환
		}while(permutation(a));
		
	    System.out.println(ans);

	}

}
