package ch7;
import java.io.*;
import java.util.*;

/*
 * 손님이 왓을 때 요청한 총 길이가 M일 때 적어도 M 만큼의 떡을 얻기 위해서 절단기의 최대 높이 
 * */
public class Solution_떡볶이떡만들기 {
	static int N, M;
	static int[] height;
	
	static void binarySearch(int[] arr, long start, long end) {
		long ans = 0;
		
		while(start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			
			for(int i=0; i < N; i++) {
				if(arr[i] > mid) { // 절단기로 잘랐을 때 중간값보다 크면 떡의 길이 구하기 
					sum += arr[i] - mid;
				}
			}
			
			if(sum >= M) { // 구한 떡의 길이가 원하는 떡의 길이보다 길면 -> 오른쪽 탐색 (떡의 길이 줄이기)
				start = mid + 1;
				ans = mid;
			}
			else { // 구한 떡의 길이가 원하는 떡의 길이보다 작다면 -> 왼쪽 탐색 
				end = mid - 1;
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]); // 떡의 개수
		M = Integer.parseInt(input[1]); // 떡의 길이 

		height = new int[N];
		String[] tmp = br.readLine().split(" ");
		for(int i=0; i < N; i++) {
			height[i] = Integer.parseInt(tmp[i]);
		}
		
		Arrays.sort(height);

		binarySearch(height, 0, height[height.length - 1]);
	}

}
