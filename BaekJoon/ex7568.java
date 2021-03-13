import java.util.*;
import java.io.*;

/*
 * How 구현?
 * 1. 모든 키와 몸무게의 값을 받음
 * 2. 등수는 1부터 시작해서 i의 값이 j의 값보다 작은 경우 등수를 갱신해줌
 * */

public class ex7568 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 5
		int[][] arr = new int[N][N];
		String[] input;
		
		for(int i=0; i< N; i++) {
			input = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(input[0]);
			arr[i][1] = Integer.parseInt(input[1]);
		}

		int rank; // 등수 
		for(int i=0; i<N; i++) {
			// 등수는 1부터 시작해서 갱신해주기
			rank = 1;
			for(int j = 0; j < N; j++) {
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) { // i의 값이 j보다 크다면
					rank ++; // 등수를 증가시킴 
				}
			}
			System.out.print(rank + " ");
		}
	}

}
