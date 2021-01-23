import java.util.*;

/** 
 1부터 N까지의 수로 이루어진 순열이 있다. 이때, 사전순으로 바로 이전에 오는 순열을 구하는 프로그램을 작성하시오.
 사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열이고, 가장 마지막에 오는 순열은 내림차순으로 이루어진 순열이다. 
 N = 3인 경우에 사전순으로 순열을 나열하면 다음과 같다.
 1,2,3  1,3,2  2,1,3  2,3,1  3,1,2  3,2,1
**/

/** 
 * 다음 순열의 반대로 구현하면 됨
 * **/

public class ex10973 {
	public static boolean prev_permutation(int[] a) {
		int i = a.length-1; // 배열의 맨 오른쪽부터 검사하기 위해서 배열a의 길이 -1. i는 0부터 시작
		
		//1번 과정
		while(i>0 && a[i]>=a[i-1]) {
			i-=1;
		}
		
		if(i<=0) return false; //마지막 순열 
		
		//2번 과정
		int j = a.length-1;
		while(a[i-1]<=a[j]) {
			j-=1;
		}
		
		//3번 과정 - swap
		int temp;
		temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		j = a.length-1;
		
		//4번 과정
		while(i<j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i+=1;
			j-=1;
		}
		return true;
	} 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); //테스트 케이스 입력
		int[] a = new int[t];
		
		for(int i=0; i<a.length; i++) {
			a[i]=sc.nextInt();
		}
		
		if(prev_permutation(a)) {
			for(int i=0; i<a.length; i++) {
				System.out.print(a[i] + " ");
			}
		}else {
			System.out.print("-1");
		}

	}

}
