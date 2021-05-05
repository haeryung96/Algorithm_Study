import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * How 구현?
 * 1. N개의 문자를 입력받은 후
 * 2. M번의 반복문을 돌리면서 N개의 문자가 들어있는 집합과 입력받은 M개의 문자를 비교하며 카운트 
 */

public class ex14425 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]); // 집합 S에 포함되어 있는 문자열
		int M = Integer.parseInt(input[1]); // 검사해야하는 문자열 
		
		String[] arr = new String[N]; // 입력받을 문자의 배열
		
		StringTokenizer st;
		
		for(int i=0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken();
		}
		
		int cnt = 0;
		for(int i=0; i < M; i++) {
			String str = br.readLine();
			for(int j=0; j < N; j++) {
				if(arr[j].equals(str)) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
