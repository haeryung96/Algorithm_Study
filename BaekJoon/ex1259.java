import java.util.*;
import java.io.*;

/*
 * How 구현?
 * 1. 먼저 문자의 길이를 구한다 짝수인 경우 홀수인 경우
 * 2. 짝수인 경우 펠린드롬수가 아니라면 체크를 true로 홀수인 경우도 마찬가지 
 */

public class ex1259 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		StringBuilder sb = new StringBuilder();
    
		while(!input.equals("0")) {	
			boolean check = false; // 체크를 먼저 거짓으로 초기화
			if(input.length()%2==0) { // 입력된 숫자의 길이가 짝수인 경우
				for(int i=0; i < input.length()/2; i++) {
					// 펠린드롬 수가 아닌 경우 
					if(input.charAt(i) != input.charAt(input.length()-i-1)){ // 첫 숫자와 마지막 숫자가 다르다면
						check = true;
						break;
					}
				}
			}
			else if(input.length()%2==1) { // 입려된 숫자의 길이가 홀수인 경우 
				for(int i=0; i < input.length()/2; i++) {
					// 펠린드롬 수가 아닌 경우 
					if(input.charAt(i) != input.charAt(input.length()-i-1)) { // 첫 숫자와 마지막 숫자가 다르면 
						check = true;
						break;
					}
				}
			}
      
			if(check == true) sb.append("no\n"); // 펠린드롬 수가 아닌 경우
			else sb.append("yes\n"); // 펠린드롬 수인 경우 
			input = br.readLine(); // 다시 읽을 숫자를 갱신해야함 안그러면 무한루프걸림 
      
		}
		
		System.out.println(sb);
	}
}
