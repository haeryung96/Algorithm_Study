import java.io.*;
import java.util.*;

/*
 * How 구현?
 * 1. 시작점이 하얀색인 체스판을 선언
 * 2. 하얀색 체스판에서 W이면서 F 말이 있는 경우 카운트
 */

public class ex1100 {
	// 흰색이 먼저 시작하는 경우
	static char[][] white = {
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'}
	};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] chess = new String[8]; // 체스판은 8칸씩
		

		for(int i=0; i < 8; i++) {
			chess[i] = br.readLine();
			chess[i].toCharArray(); // string형 배열을 char형으로 변환하기 
		}
		
		int cnt = 0; 
		
		// white 체스판과 비교해가기
		for(int i=0; i < 8; i++) { // 행
			for(int j=0; j < 8; j++) { // 열
				if(chess[i].charAt(j) == 'F' && white[i][j] == 'W') { // 하얀칸에 말이 있다면 ** equals는 String에서만 사용 가능 
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
