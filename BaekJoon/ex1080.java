import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * How 구현?
 * 1. 행렬의 가장 왼쪽 부분 (0,0)부터 차례대로 비교
 * 2. 3*3 부분행렬의 가장 위의 원소가 다르면 부분행렬의 원소를 모두 바꾸기
 * 3. 왜냐면 가장 위 원소를 비교하는 그 순간만 변환할 수 있기 때문
 */

public class ex1080 {
	static int N , M;
	static int arrA[][]; // 행렬 A
	static int arrB[][]; // 행렬 B
	
	// 뒤집기 연산 수행
	public static boolean flip(int start_a, int start_b) {
		// 아래의 조건 추가안해주면 틀림 
		if(start_a + 3 > N || start_b + 3 > M) { // 3*3 행렬의 범위에서 벗어난다면 
			return false; // 수행하지 못하게 함 
		}
		
		// 뒤집기 연산 수행
		for(int i = start_a; i < start_a + 3; i++) {
			for(int j = start_b; j < start_b + 3; j++) {
				arrA[i][j] = 1 - arrA[i][j]; // 어짜피 원소는 1과 0이기 떄문에 1에서 뺸 값이 뒤집기의 형태가 됨 
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arrA = new int[N][M];
		arrB = new int[N][M];
		
		int cnt = 0; // 연산의 횟수 
				
		// 행렬 A 입력받기
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < M; j++) {
				arrA[i][j] = tmp.charAt(j)-'0'; // 숫자로 변환
 			}
		}
		
		// 행렬 B 입력받기
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < M; j++) {
				arrB[i][j] = tmp.charAt(j)-'0'; // 숫자로 변환
		 	}
		}
		
		// 원소 하나하나를 비교해서 다를 때 마다 flip 메소드 호출
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				// 행렬A의 (i,j)가 행렬B (i,j)의 값과 다르다면
				if(arrA[i][j] != arrB[i][j]) {
					if(flip(i,j)) { // 뒤집기 연산수행 
						cnt++;
					}
					else { // 더 이상 부분 행렬을 만들수 없기 때문에 -1 출력 후 비교 중단 
						System.out.println("-1");
						return;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
