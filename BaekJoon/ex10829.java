import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * How 구현 ? 
 * 1. 재귀함수를 사용하여 구현
 * 2. N을 2로 나눈 나머지를 구하고 N을 2로 나눈 몫으로 다시 초기화
 * 3. 2로 나눈 몫을 다시 재귀함수로 호출
 * 4. 마지막으로 호출된 재귀함수를 바탕으로 스트링 빌더에 나눈 나머지가 들어감
 * 주의 : 숫자의 입력값은 int형이 아닌 long 을 써야함 
 * */

public class ex10829 {
	
	public static void recursive(long N) {
		
		StringBuilder sb = new StringBuilder();

		if(N > 0) {
			long remains = N % 2; // 0 과 1
			N /= 2; // 나눈 몫을 다시 N으로 초기화 
			recursive(N); // 재귀 
			sb.append(remains); // System.out.println은 메모리 많이 잡아먹어서 스트링빌더 사용 
		}
		
		System.out.print(sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine()); // 입력값 받아오기 
		
		recursive(N); // 재귀를 사용해서 이진수 구하기 
	}
}
