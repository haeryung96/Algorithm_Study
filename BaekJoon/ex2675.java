package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex2675 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < TC; i++) {
			String[] input = br.readLine().split(" ");
			int R = Integer.parseInt(input[0]); // 3
			String S = input[1]; //ABC
			String[] sArr = S.split(""); // A B C
			
			for(int j=0; j < sArr.length; j++) {
				sb.append(sArr[j].repeat(R));
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
