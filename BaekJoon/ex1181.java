import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * How 구현?
 * 1. 입력된 문자를 길이순으로 정렬
 * 2. 길이가 같다면 사전순으로 정렬
 */

public class ex1181 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Alphabet> alpha = new ArrayList<Alphabet>();
		StringTokenizer st;
		String[] input = new String[N];
		
		for(int i=0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			input[i] = st.nextToken();
			alpha.add(new Alphabet(input[i]));
		}
		
		Collections.sort(alpha);
		
		// 중복값 제거
		// 기본 자료형이 아닌 경우 get(i)로 주소값을 가지고 온 후, 다시 원하는 자료를 가지고 와야함
		for(int i=0; i<alpha.size()-1; i++) {
			// 문자열 비교시 equals 사용
			if(!(alpha.get(i).str).equals(alpha.get(i+1).str)) { // 해당 문자와 다음 문자가 같지 않다면 
				System.out.println(alpha.get(i).str); // 중복되는 값이 아니기 때문에 출력 
//				alpha.remove(i); 
			}
		}
		
		System.out.println(alpha.get(alpha.size()-1).str); // 위의 반복문에서 마지막 문자는 출력이 안되므로 마지막에 다시 출력시켜주기 
		
//		for(int i=0; i<alpha.size(); i++) { 왜 오류인지 모르겠음 
//			System.out.println(alpha.get(i));
//		}
	}
}

class Alphabet implements Comparable<Alphabet> {
	String str;
	
	@Override
	public String toString() { // 문자열을 출력하기 위해서 
		return str;
	}
	
	Alphabet(String str) {
		this.str = str;
	}
	
	// 길이가 짧은 것 부터 
	// 길이가 같으면 사전 순으로 
	@Override
	public int compareTo(Alphabet o) {
		if(this.str.length() > o.str.length()) { // 내가 가지고 있는 문자열보다 들어온 문자열이 작다면
			return 1;
		}
		else if(this.str.length() == o.str.length()) { // 내가 가지고 있는 문자열과 들어온 문자열의 길이가 같다면 
			if((this.str).compareTo(o.str) > 0) // 사전순으로 
			     return 1;
		}
		return -1;
	}
}
