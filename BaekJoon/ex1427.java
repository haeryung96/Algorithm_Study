import java.io.*;
import java.util.*;

/*
 * How 구현?
 * 1. 정렬
 */

public class ex1427 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("");
		
		int[] arr = new int[input.length];
		
		for(int i=0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(arr);
		
		for(int i = arr.length-1; i >=0; i--) {
			System.out.print(arr[i]);
		}
	}

}
