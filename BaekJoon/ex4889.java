package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * How 구현?
 * 1. 괄호 { }의 짝을 맞춰준다.
 * 2. 짝을 맞춘 후 바꿔야할 괄호는 사이즈의 반을 더해주면 됨 
 * * 스택에는 { 만 들어있음 
 * */

public class ex4889 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = 1; // 출력 앞에 번호 
		
		while(true) {
			String str = br.readLine();
			
			if(str.contains("-")) {
				break;
			}
			
			Stack<Character> stack = new Stack<>();
			int cnt = 0;
			
			for(int j=0; j < str.length(); j++) {
				char ch = str.charAt(j);
				
				if(ch == '{') {
					stack.push('{');
				}
				else if (ch == '}') {
					if(!stack.isEmpty()) {
						stack.pop();
					}
					else {
						stack.push('{');
						cnt++;
					}
				}
			}
			
			cnt += stack.size()/2;
			System.out.println(num + ". " + cnt);
			num++;
		}
		
		
	}

}
