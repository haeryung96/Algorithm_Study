package nadongbin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_고정점찾기 {
	static int N; 
	static int[] arr;
	
	static int binarySearch(int[] arr, int start, int end) {
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] == mid) {
				return mid;
			}
			else if(arr[mid] > mid) {
				end = mid - 1;
			}
			else if(arr[mid] < mid) {
				start = mid + 1;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int res = binarySearch(arr, 0, arr.length -1);

		System.out.println(res);
	}

}
