import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * How 구현?
 * 1. 입력받은 A를 B에 똑같이 복사
 * 2. A는 정렬하고 B는 그대로 둔 다음 A와 B를 비교
 * 3. 값이 같다면 스트링빌더에 A의 인덱스 넣기
 * 4. 주의 : 만약 같은 숫자가 있다면 비내림차순으로 입력할 수 없기 때문에 A배열의 값을 1001로 바꿔치기
 */

public class ex1015 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 배열 A의 크기 N
		
		int[] A = new int[N]; // 배열 A
		int[] B = new int[N]; // 배열 B
		
		String[] input = br.readLine().split(" ");
		// 입력된 값을 넣고 
		for(int i=0; i < N; i++) {
			A[i] = Integer.parseInt(input[i]);
			B[i] = A[i]; // A의 배열을 B의 배열에 복사
		}
		
		Arrays.sort(A); // 정렬하면 1 2 3

		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < N; i++) {
			for(int j=0; j < N; j++) { // 2 3 1
				if(B[i] == A[j]) { // 2 != 1  2 == 2
					sb.append(j + " ");
					A[j] = 1001; // 같은 숫자가 나올 경우를 대비해서 1001로 바꿔치기 
					break;
				}
			}
		}
		
		System.out.println(sb);
	}

}
