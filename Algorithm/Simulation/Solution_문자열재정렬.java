package nadongbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_문자열재정렬 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		char[] list = input.toCharArray();
		int sum = 0;
		ArrayList<Character> alpha = new ArrayList<>();
		
		for(int i=0; i < input.length(); i++) {
			if(input.charAt(i) >= 65 && input.charAt(i) <= 90) {
				alpha.add(list[i]);
			}
			else {
				sum += input.charAt(i) - '0';
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Collections.sort(alpha);
		for(int i=0; i < alpha.size(); i++) {
			sb.append(alpha.get(i));
		}
		
		sb.append(sum);
		System.out.println(sb);
	}

}
