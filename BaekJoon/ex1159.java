import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ASCII 코드 사용법
 * 소문자 a = 97의 값을 가짐 
 * char str = 'c' - 2라고 하면 출력은 a를 출력
 */

public class ex1159 {
	static final int ASCII = 97; // 문자 a는 97
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] alpha = new int[26]; // 알파벳을 비교하기 위해서 
		
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String last_name = st.nextToken();
			char first = last_name.charAt(0); // 첫번째 문자는 입력된 성의 0번째에 위치 
			// 해당문자 - 'a'를 배열의 인덱스로 보고 해당 인덱스의 원소를 카운팅하기
			// 같은 문자가 나오면 계속 카운팅이 되고 5개가 되는지 파악하면 됨
			// 만약 첫문자가 k라면, k - a = 10으로 해당하는 10번째에 계속 카운팅을 올려줌 
			alpha[first - ASCII]++; // 성의 앞 문자에서 소문자 a를 빼면 숫자가 나옴 
		}
		
		StringBuilder sb = new StringBuilder();
		
		// 5개 이상인 경우를 비교
		for(int i=0; i < alpha.length; i++) {
			// 해당 인덱스에 위치한 값이 5개 이상인 경우
			if(alpha[i] >= 5) {
				sb.append((char)(i + ASCII)); // 문자를 구할때는 다시 해당 인덱스에서 97의 값을 더하면 알파벳이 나옴
			}	
		}
		
		// 만약 스트링 빌더에 들어간 값이 0이라면 기권했다는 의미
		if(sb.length() == 0) {
			System.out.println("PREDAJA");
		}
		else 
			System.out.print(sb);
	}

}
