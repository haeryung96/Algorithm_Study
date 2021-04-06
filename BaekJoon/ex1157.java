import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * How 구현?
 * 1. 입력받은 문자열을 대문자 소문자로 나눠서 검사하기
 * 2. 해당 알파벳에서 아스키코드를 사용해 반환한 숫자를 배열의 인덱스로 설정
 * 3. 배열의 값이 최대값이라면 대문자 출력
 */
public class ex1157 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int[] alpha = new int[26];

		for(int i=0; i < input.length(); i++) {
			// 해당 문자가 소문자인 경우
			if('a' <= input.charAt(i) && input.charAt(i) <= 'z') {
				alpha[input.charAt(i) - 97]++; // 소문자 a의 10진수 97 을 뺴면 알파벳 자신이 위치한 인덱스 반환
			}
			else if ('A' <= input.charAt(i) && input.charAt(i) <= 'Z') {
				alpha[input.charAt(i) - 65]++; // 대문자 A의 10진수 65를 빼면 알파벳 자신이 위치한 인덱스 반환
			}		
		}
		
		int max = 0;
		char ch = 0;
		
		for(int i=0; i < 26; i++) {
			if(alpha[i] > max) {
				max = alpha[i]; 
				ch = (char) (i+65); // 대문자 출력을 위해서 65릏 더하기 
			}
			// max가 계속 동일한 값이 나온다면
			else if(alpha[i] == max) {
				ch = '?';
			}
		}
		
		System.out.println(ch);
	}

}
