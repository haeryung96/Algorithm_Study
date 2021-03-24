import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * How 구현?
 * 1. 로프가 한개일 때 로프가 버틸 수 있는 한계가 최대 중량
 * 2. 로프의 최대중량이 작은 로프의 힘 * 2
 * 3. 이런식으로 계속 구해나가면 됨
 * 4. 제일 큰 수 * 1 그 다음 큰수 * 2 ... 가장 작은 수 * N 을 하면 값이 나옴 
 * */

public class ex2217 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];

		for(int i=0; i<N; i++) {		
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr); // 오름차순 정렬

		int max = 0;
		
		for(int i= N-1; i>=0; i--) {
			// 제일 큰수부터 시작해서 개수를 곱해나아가는 형태 
			max = Math.max(max, arr[i] * (N-i));
		}
		
		System.out.println(max);
	}
}
