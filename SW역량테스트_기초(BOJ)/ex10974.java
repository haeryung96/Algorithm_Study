import java.util.*;

/** 
 * N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하라.
 * 첫째 줄에는 N(1<=N<=8)이 주어진다.
 * 과정 : 첫순열을 만들고 계속 다음 순열을 만들다가 다음 순열이 존재하지 않는 순간까지 반복
 * **/

/** 
 * 다음 순열과 똑같이 구현 후, do-while문 사용하여 while문 안의 조건문이 true가 될 때 까지 반복
 * **/

public class ex10974 {
	public static boolean permutation(int[] a) {
		int i = a.length-1;
		
		//1번 과정
		while(i>0 && a[i-1] >= a[i]) {
			i-=1;
		}
		
		if(i<=0) return false; //마지막 순열일때 
		
		int j = a.length-1;
		
		//2번 과정
		while(a[i-1] >= a[j]) {
			j-=1;
		}
		
		//3번 과정
		int temp;
		temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		//4번 과정 
		j = a.length-1;
		while(i<j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); //테스트 개수 
		int[] a= new int[t];
		
		// t가 3이라면 배열 a에 들어있는 원소는 1 2 3
		//a[0] = 1 a[1] =2 a[2] =3
		for(int i=0; i<t; i++) {
			a[i] = i+1;
		}
		
		//do-while 문 사용 - while 조건식이 true가 된다면 false가 될때까지 계속해서 코드 반복 
		do {
			for(int i=0; i<a.length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}while(permutation(a));

	}

}
