import java.io.*;
import java.util.*;

public class ex1920 {
	static int N, M;
	static int[] nArr;
	static int[] mArr;
	
	static int BinarySearch(int[] nArr, int start, int end, int target) {
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(nArr[mid] == target) {
				return mid;
			}
			else if(nArr[mid] < target) {
				start = mid + 1;
			} 
			else if(nArr[mid] > target) {
				end = mid - 1;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nArr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i < N; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nArr);
		
		M = Integer.parseInt(br.readLine());
		mArr = new int[M];
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i < M; i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
			
			if(BinarySearch(nArr, 0, N-1, mArr[i]) >= 0) {
				sb.append('1').append('\n');
			}
			else {
				sb.append('0').append('\n');
			}
		}
		
		System.out.println(sb);
		
	}

}
