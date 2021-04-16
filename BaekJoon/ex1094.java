import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * How 구현?
 * 1. 초기 막대기의 길이는 64 
 * 2. 계속 자르면서 자른 조각이 X의 길이보다 작다고 하면 카운트하고 X의 값에 자른 막대기의 길이 빼서 초기화
 * 3. 답이 나올때까지 위의 과정 반복 
 */

public class ex1094 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine()); // 길이가 X인 막대기 
		
		int max = 64; // 초기의 막대기 길이 
		int cnt = 0;
		
		
		while(X > 0) {
			
			if(max > X) {
				max /= 2;
			}
			
			else {
				X -= max;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
