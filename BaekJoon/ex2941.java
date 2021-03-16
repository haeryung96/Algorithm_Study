import java.util.*;
import java.io.*;

// 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다 **

/*
 * How 구현?
 * 1. 인덱스의 위치를 늘려가면서 문자를 검사
 * 2. 주의해야할 점은 StringIndexOutOfBoundsException
 * 3. 만약 맨 마지막 문자가 l이라면 if(k == 'l') 조건문에 들어가고 그 다음 문자에 j가 없기때문에
 * 4. 문자열을 찾지 못하고 잘못된 인덱스 반환 
 * 5. 따라서 if(i < str.length()-1) 조건문을 달아서 예외처리
 */

public class ex2941 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine(); // 문자열 입력받기 
		
		int cnt = 0;
		
		for(int i=0; i<str.length(); i++) { // 입력된 문자열 하나씩 검사하기 
			char k  = str.charAt(i); // 입력된 문자의 i번째 해당하는 인덱스 위치의 문자를 k로 설정
			
			if(k == 'c') { // 만약 k의 문자가 c라면
				if(i < str.length()-1) {
					if(str.charAt(i+1) == '=') { // c의 다음 문자가 =이라면
						// 인덱스 하나 늘려주고 다음 문자 검사하기
						i++;
					}
					else if(str.charAt(i+1) == '-') {
						i++;
					}
				}
			}
			
			else if(k == 'd') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == 'z') {
						if(i < str.length() - 2) {
							if(str.charAt(i + 2) == '=') { 
								i += 2;
							}
						}
					}
					else if(str.charAt(i + 1) == '-') { 
						i++;
					}
				}
			}
			
			else if (k == 'l') {
				if(i < str.length() -1) {
					if(str.charAt(i+1) == 'j') {
						i++;
					}
				}
			}
			
			else if(k == 'n') {
				if(i < str.length() -1) {
					if(str.charAt(i+1) == 'j') {
						i++;
					}
				}
			}
			
			else if (k == 's') {
				if(i<str.length()-1) {
					if(str.charAt(i+1) == '=') {
						i++;
					}
				}
			}
			
			else if(k == 'z') {
				if(i < str.length()-1) {
					if(str.charAt(i+1) == '=') {
						i++;
					}
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}

// 참고하면 좋을 간단한 풀이
/*
 * String[] arr= {"c=","c-","dz=","d-","lj","nj","s=","z="};
    int result=0;
    
    for(int i=0;i<arr.length;i++) {
        if(croa.contains(arr[i])) {
            croa=croa.replaceAll(arr[i]," "); // 빈문자열로 치환한다음에 
            }
        }   
    System.out.println(croa.length()); // 문자열의 길이 반환 
 */
 
