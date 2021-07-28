package nadongbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_문자열뒤집기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("");
		
		int[] num = new int[input.length];
		for(int i=0; i < input.length; i++) {
			num[i] = Integer.parseInt(input[i]);
		}
		
		int zeroCnt = 0;
		int oneCnt = 0;
		
		if(num[0] == 0) {
			zeroCnt++; 
		}
		else {
			oneCnt++;
		}
		
		int answer = 0;
		for(int i=1; i < input.length; i++) {
			if(num[i-1] == 1 && num[i] == 0) {
				zeroCnt++;
			}
			else if(num[i-1] == 0 && num[i] == 1) {
				oneCnt++;
			}
		}
		
		answer = Math.min(zeroCnt, oneCnt); 
		
		System.out.println(answer); 
	}

}
