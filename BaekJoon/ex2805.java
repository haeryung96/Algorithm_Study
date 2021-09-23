package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ex2805 {
	static int N, M; // 나무의 수, 나무의 길이 
	static int[] height;
	
	public static void binarySearch(int[] arr, int start, int end) {
		int ans = 0;
		
		while(start <= end) {
			int mid = (start + end)/2;
			long sum = 0;
			
			for(int i=0; i < N; i++) {
				if(arr[i] > mid) {
					sum += arr[i] - mid;
				}
			}
			
			if(sum >= M) { // 오른쪽 탐색 
				start = mid + 1;
				ans = mid;
			}
			else { // 왼쪽 탐색 
				end = mid - 1;
			}
		}
		
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		height = new int[N];
		String[] tmp = br.readLine().split(" ");
		for(int i=0; i < tmp.length; i++) {
			height[i] = Integer.parseInt(tmp[i]);
		}
		
		Arrays.sort(height);
		
		binarySearch(height, 0, height[height.length - 1]);
	}

}
