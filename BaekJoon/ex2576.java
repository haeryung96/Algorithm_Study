package baekjoon;
import java.io.*;
import java.util.*;

public class ex2576 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[7];
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int even = 0;
		
		for(int i=0; i < num.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken());
			
			if(num[i] % 2 == 1) {
				sum += num[i];
				min = Math.min(min, num[i]);
			}
			else {
				even++;
			}
		}
		
		if(even == 7) {
			System.out.println(-1);
		}
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
