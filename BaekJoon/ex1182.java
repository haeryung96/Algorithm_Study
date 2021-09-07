package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex1182 {
	public static int N, S; // 정수의 개수 
	public static int[] arr;
	public static int cnt = 0;
	
	public static void DFS(int level, int num) {
		if(level == N) {
			if(num == S) {
				cnt++;
			}
			return;
		}
		
		DFS(level + 1, num + arr[level]); // 현재 원소 더하기 - 현재 원소를 포함하는 경우 누적값
		DFS(level + 1, num);
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		S = Integer.parseInt(input[1]);
		
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0,0);
		
		/*
		 * 주의점
		 * S가 0일때 공집합인 경우에도 백트래킹 조건에 맞다고 처리하고 개수를 +1 하므로
		 * S가 0인 경우에 cnt - 1을 해줘야함 
		 * */
		if(S == 0) {
			cnt--;
			System.out.println(cnt);
		} 
		else {
			System.out.println(cnt);
		}
		
	}

}
