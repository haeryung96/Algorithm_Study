import java.util.*;

/** 
 * N개의 수로 이루어진 수열이 주어진다. 또, 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다.
 * 연산자는 덧셈, 뺄셈, 곱셈, 나눗셈으로 이루어져있다.
 * 우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 만들 수 있따. 이때, 주어진 수의 순서를 바꾸면 안된다. 
 * 수식의 계산은 연산자 우선순위를 무시하고 앞에서부터 진행
 * 수의 순서는 바꿀 수 없다. But 연산자의 순서는 바뀜
 * **/

/** 
 * N<=11이고, 연산자는 최대 10개이기 때문에, N!가지로 모든 경우의 수를 순회
 * **/

public class ex14888 {
	public static boolean permutation(int[] a) {
		int i= a.length-1;
		
		//1번 과정 -i 찾기
		while(i>0 && a[i-1]>=a[i]) {
			i-=1;
		}
		
		if(i <= 0) return false; 
		
		int j = a.length-1;
		
		//2번 과정 - j찾기
		while(a[i-1]>=a[j]) {
			j-=1;
		}
		
		//3번 과정
		swap(a,i-1,j);
		
		j = a.length-1;
		
		//4번 과정
		while(i<j) {
			swap(a,i,j);
			i++;
			j--;
		}
		return true;
	} 
	
	public static void swap(int[] a, int i, int j) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	// + 를 0 -를 1 *를 2 /를 3으로 두고 계산
	//a는 입력받은 숫자배열, b는 입력받은 연산자 배열
	public static int calc(int[]a , int[] b) {
		int n = a.length;
		int ans = a[0];
		for(int i=1; i<n; i++) {
			if(b[i-1]==0) {    // 연산자 더하기
				ans=ans+a[i];
			} else if(b[i-1]==1) {   //연산자 빼기
				ans=ans-a[i];
			} else if(b[i-1]==2) {   //연산자 곱하기
				ans = ans * a[i];
			} else if(b[i-1]==3) {   //연산자 나누기
				ans = ans / a[i];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); //테스트 개수 입력 
		
		//입력받은 숫자
		int[] a = new int[t];
		for(int i=0; i<t; i++) {
			a[i] = sc.nextInt();
		}
		
		//입력받은 연산자의 개수 
		int[] b = new int[t-1]; //연산자는 입력받은 숫자보다 하나 적음
		int m = 0;
		
		//연산자는 4개이므로 4번 돌림
		for(int i=0; i<4; i++) {
			int cnt = sc.nextInt();
			//b 배열에 연산자의 개수 넣기 
			//ex) i=0일때 cnt가 2이면 배열 b[2]=0 즉 덧셈연산자는 2개
			for(int j=0; j<cnt; j++) {
				b[m++] = i; 
			}
		}
		//정렬을 왜 해야하는지 모르겠음
		Arrays.sort(b);
		ArrayList<Integer> result = new ArrayList<>();
		do {
			int temp = calc(a,b);
			result.add(temp);
		}while(permutation(b));
		
		//결과를 오름차순으로 정렬후 맨 왼쪽에 있는 것이 최솟값 맨 오른쪽에 있는 값이 최대값
		//Arrays.sort(result);
		Collections.sort(result);
		//배열의 크기는 m, 원소의 시작은 0부터 최대값은 m-1 의 위치함
		m = result.size();
		System.out.println(result.get(m-1)); //최대값
		System.out.println(result.get(0)); //최솟값


	}

}
