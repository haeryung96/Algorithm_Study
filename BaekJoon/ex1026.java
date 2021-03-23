import java.io.*;
import java.util.*;

/*
 * How 구현?
 * 1. 배열 A와 배열 B를 정렬
 * 2. 정렬된 배열 A의 값과 배열B의 값을 역으로 곱해줌
 */

public class ex1026 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arrA = new int[N];
		int[] arrB = new int[N];
		
		st = new StringTokenizer(br.readLine()); // 새로운 배열의 입력을 받을때마다 갱신 
		for(int i=0; i <N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
 		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i <N; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
 		}
		
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		
		int sum = 0;
		for(int i=0; i < N; i++) {
			sum += arrA[i] * arrB[N-i-1];
		}
		
		System.out.println(sum);
	}

}
