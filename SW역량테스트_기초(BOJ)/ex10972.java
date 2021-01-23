import java.util.*;

/** 1부터 N까지의 수로 이루어진 순열이 있다. 이때, 사전순으로 다음에 오는 순열을 구하는 프로그램을 작성하시오.
         사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열이고, 가장 마지막에 오는 순열은  내림차순으로 이루어진 순열이다.
    N = 3인 경우에 사전순으로 순열을 나열하면 다음과 같다.
    1,2,3  1,3,2  2,1,3  2,3,1  3,1,2  3,2,1
 **/

public class ex10972 {
	public static boolean next_permutation(int[] a) {
		int i = a.length-1; // 배열의 크기를 a라고 하면 i는 0부터 시작이므로 크기에서 1을 빼줌
		
		//1번 과정 
		// i가 0보다 크고 배열 a에 들어있는 i-1이 i보다 큰 경우 오름차순이 아닌 경우 i의 값을 감소 
		while(i>0 && a[i-1]>=a[i]) {
			i-=1;
		} 
		
		// i의 값이 0과 같거나 작은 경우 마지막 순열 
		if(i<=0) return false; 
		
		int j = a.length-1;
		
		//2번 과정 
		//j를 찾기 위해서 i-1보다 큰 값 중에서 가장 큰 값이 j의 값이므로 역으로 계산함.ㅏ 
		while(a[j]<=a[i-1]) {
			j-=1;
		}
		
		//3번 과정
		//java의 경우 swap 함수가 없어서 따로 구현해줘야 함
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		//계속 a.lenght-1의 값으로 갱신하는 이유를 모르겠음 ...
		j =a.length-1;
		
		//4번 과정 
		//i와 j의 위치를 변경했으므로 a[i]부터 순열을 뒤집어줌.
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
		int t = sc.nextInt(); //테스트 개수 입력 
		int[] a = new int[t];
		
		//순열을 입력받음
		for(int i=0; i<a.length; i++) {
			a[i] = sc.nextInt();
		}
		
		if(next_permutation(a)) {
			for(int i=0; i<t; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		} else {
			System.out.println("-1");
		}
	}

}
