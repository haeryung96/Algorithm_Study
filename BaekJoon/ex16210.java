import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ex16210 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine(); // 입력 받기 
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			st.add(ch); // 값을 계속 넣음
			
			// elementAt 문자열의 인덱스 가져오기 
			if(st.size() >= 4 && st.elementAt(st.size() - 4) == 'P' && st.elementAt(st.size() - 3) == 'P' && st.elementAt(st.size() - 2) == 'A' && st.elementAt(st.size() - 1) == 'P') {
				for(int j = 0; j < 3; j++) { // 연속 3개 뽑기 
					st.pop();
				}
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		if(st.peek() == 'P' && st.size() == 1) { // P 한개만 남을 경우 
			sb.append("PPAP");
		}
		else {
			sb.append("NP");
		}
		
		System.out.println(sb);
	}

}
