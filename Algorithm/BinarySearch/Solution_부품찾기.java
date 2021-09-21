package ch7;
import java.io.*;
import java.util.*;

/*
 * 부품이 N개 손님이 M개 종류의 부품을 대량으로 구매
 * 손님이 요청한 부품이 있으면 yes, 없으면 no 출력 
 * */
public class Solution_부품찾기 {
	public static int binarySearch(int[] arr, int start, int end, int target) {
		while (start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) return mid;
            // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (arr[mid] > target) end = mid - 1;
            // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else start = mid + 1; 
        }
        return -1;
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 부품의 개수 
		int[] master = new int[N]; // 부품의 번호 
		
		String[] input = br.readLine().split(" ");
		for(int i=0; i < N; i++) {
			master[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(master);
		
		int M = Integer.parseInt(br.readLine()); // 손님 부품 개수 
		int[] customer = new int[M];
		
		String[] tmp = br.readLine().split(" ");
		for(int i=0; i < M; i++) {
			customer[i] = Integer.parseInt(tmp[i]);
		}
		
		Arrays.sort(customer);
		
		for(int i=0; i < M ; i++) {
			int res = binarySearch(master, 0, N-1, customer[i]);
			if(res != -1) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}

}
