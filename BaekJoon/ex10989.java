import java.io.*;
import java.util.*;

/*
 * How 구현?
 * 1. 정렬 -> 시간제한 3초
 * 2. 그냥 정렬해서 풀면 시간초과
 * 3. stringBuilder 쓰면 간신히 통과 ...
 * */

public class ex10989 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			sb.append(arr[i]).append('\n');
//			System.out.println(arr[i]);
		}
		
		System.out.println(sb);
	}

}

