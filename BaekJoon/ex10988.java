import java.io.*;

/*
 * How 구현?
 * 1. 입력된 문자의 길이가 짝수인지 홀수인지 검사
 * 2. 앞의 단어와 뒤의 단어를 비교한 다음에 
 * 3. 펠린드롬의 문자인 경우 1을 출력
 */

public class ex10988 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		boolean check = false; 

		// 입력된 문자열이 짝수인 경우
		if(str.length() % 2 == 0) {
			for(int i=0; i < str.length()/2; i++) {
				if(str.charAt(i) != str.charAt(str.length()-i-1)) { // 앞의 문자와 뒤의 문자를 하나씩 비교 
					check = true; // 팰린드롬 아님
					break;
				}
			}
		}
		
		// 입력된 문자열이 홀수인 경우
		else if(str.length()%2 == 1) {
			for(int i=0; i < str.length()/2; i++) {
				if(str.charAt(i) != str.charAt(str.length()-i-1)) { // 앞의 문자와 뒤의 문자를 하나씩 비교 
					check = true; // 팰린드롬 아님
					break;
				}
			}
		}
		
		if(check == true) {
			System.out.println(0);
		}
		else if(check == false) System.out.println(1);
	}

}
