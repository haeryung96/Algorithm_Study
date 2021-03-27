import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * How 구현
 * 1. 그룹 단어 체커
 * 2. 입력된 문자열을 하나씩 잘라서 가져온다.
 * 3. 반복문에서 행당 인덱스를 다음 인덱스와 비교한 뒤에 문자가 다르다면 list에 추가 왜냐면 그룹 단어 체커이기 때문에 
 * 4. 위의 과정을 반복
 */
public class ex1316 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] input = new String[N];
		int cnt = N; // 그룹 단어 체커인 경우 최대로 카운트될 수 있는 수는 입력된 문자의 개수와 동일하기 때문에 N으로 설정하고 반복문에서 N의 값을 줄여줌 
		ArrayList<Character> list = new ArrayList<>();
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			input[i] = st.nextToken();

			if(input[i].length()!=1) { // 입력된 문자가 1이 아닌 경우만 생각 1인 경우는 어짜피 원하는 문자임
				input[i] += '.'; // 마지막 문자를 비교하기 위해서 임의의 문자 넣기
				for(int j=0; j < input[i].length()-1; j++) {
					if(input[i].charAt(j) != input[i].charAt(j+1)) { // 해당 문자가 다음 문자와 다르다면
						if(!list.contains(input[i].charAt(j))) { // 검사하는 j번째에 있는 문자가 리스트에 없다면
							list.add(input[i].charAt(j)); // 리스트에 추가 
						}
						else { // 만약 이미 리스트에 있는 문자라고 하면 
							cnt--; // 그룹 단어 체커가 아니기 때문에 줄이기 
							break;
						}
						
					}
				}
				list.clear(); // 한 문자열의 검사가 끝났으면 문자열 리스트를 비워주고 다시 검사
			}
		}
		System.out.println(cnt);
	}
}
