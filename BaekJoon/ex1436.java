import java.util.*;
import java.io.*;

/*
 * How 구현?
 * 1. 브루트포스
 * 2. int를 String으로 형변환해서 666이 들어있는 경우 N을 감소시키며 반복문 돌기
 */

public class ex1436 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int num = 665; // 0부터 665는 검사할 필요가 없기 때문에 666으로 초기화 - 메모리 아주 약간 줄어듬 
		
		while(N > 0) {
			num ++; 
			String str = Integer.toString(num); // int를 String형으로 형 변환
			
			if(str.contains("666")) {
				N--;
			}
		}
		System.out.println(num);
	}
}
