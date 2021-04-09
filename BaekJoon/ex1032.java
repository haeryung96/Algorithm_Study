import java.io.*;

/*
 * How 구현?
 * 1. 입력받은 첫번째 문자의 첫번째 알파벳과 두 번째 문자의  1번째 알파벳, 세 번째 문자의 1번째 알파벳을 한 번씩 비교 
 * 2. 예) 1 : c | 2 : c | 3 : c를 비교 
 * 3. 인덱스를 늘려가면서 위의 과정 반복
 * 4. 문자가 같으면 해당 문자를 스트링 빌더에 넣고
 * 5. 문자가 다르면 ? 를 넣음 
 */

public class ex1032 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 파일 이름의 개수 
		
		String[] input = new String[N];
		
		boolean flag = true; // 같은 문자인지 아닌지 확인하기 위해서
		
		for(int i=0; i < N; i++) {
			input[i] = br.readLine(); // 문자를 입력받음
		}
		
		StringBuilder sb = new StringBuilder();
		// 첫 번째 문자와 두번째 세번째 문자를 비교하기
		for(int i=0; i < input[0].length(); i++) {
			for(int j=1; j < N; j++) {
				if(input[0].charAt(i) == input[j].charAt(i)) { // 서로 같은 문자라면
					flag = true;
				}
				else {
					flag = false; // 문자가 같지 않다면 false
					break;
				}
			}
			if (flag == true) {
				sb.append(input[0].charAt(i)); // 일치하는 문자값을 넣기
			}
			else if (flag == false) {
				sb.append('?');
			}
			
		}
		System.out.println(sb);
	}

}
