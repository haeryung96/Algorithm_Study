import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * How 구현?
 * 1. 시뮬레이션
 * 2. 입력된 배열의 인덱스를 기준으로 앞에 있는 값이 뒤의 값보다 크면 swap 실행
 * 3. 만약 같지 않다면 swap을 다시 해줘야하기 떄문에 check 메소드로 맞는 배열인지 확인 
 */

public class ex2947 {
	public static int[] arr;
	public static int tmp;
	
	public static void swap(int[] a, int i, int j) {
		tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
		
		for(int k=0; k < arr.length; k++) {
			System.out.print(arr[k] + " ");
		}
		System.out.println();
	}
	
	public static boolean check(int[] b) {
		boolean flag = true;
		int[] copyArr = {1,2,3,4,5};
		
		for(int i=0; i < arr.length; i++) {
			if(arr[i] == copyArr[i]) {
				return flag;
			}
		}
		return !flag;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		arr = new int[input.length];
		
		for(int i=0; i < input.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		while(check(arr)) {
			for(int i=0; i < input.length-1; i++) {
				if(arr[i] > arr[i+1]) {
					swap(arr, i, i+1);
				}
				else continue;
			}
		}
	}

}
