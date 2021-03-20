import java.util.*;
import java.io.*;

/*
 * How 구현?
 * 1. ( 다음에 ) 오면 레이저 그외의 경우는 쇠막대기인 경우
 * 2. ( 스택에 넣고 ) 스택에서 빼기
 * 3. ) 바로 전 문자가 ( 라면, 레이저를 의미하므로 cnt에 stack의 사이즈 만큼 더하기 - 잘라진 쇠막대기를 더하는 의미
 * 4. ) 바로 전 문자가 ) 라면, 하나의 막대조각을 의미하므로 cnt ++ 해줌 
 */

public class ex10799 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		Stack<String> vps = new Stack<>();
		
		int cnt = 0;
		
		for(int i=0; i < input.length(); i++) {
			if(input.charAt(i) == '(') { // 열린 괄호인 경우
				vps.push("("); // 스택에 괄호를 넣어줌 
				continue;
			}
			if (input.charAt(i) == ')') { // 닫힌 괄호인 경우
				vps.pop(); // 스택에 괄호를 빼줌 
				if(input.charAt(i-1) == '(') { //레이저인 경우 
					cnt += vps.size(); // 막대기가 잘린 갯수는 스텍에 쌓인 ( 의 개수와 동일 따라서 스택의 크기만큼 더해주면 잘린 막대의 수 구하기 가능 
				}
				else { // 레이저가 아닌 경우 
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}




