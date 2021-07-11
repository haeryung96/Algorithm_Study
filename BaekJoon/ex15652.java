package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 됨
 * 고른 수열은 비내림차순 -> 중복허용, 방문 배열 사용안해!!
 * */
public class ex15652 {
	public static int N, M;
	public static int[] list;
	public static StringBuilder sb = new StringBuilder();
	
	public static void DFS(int idx, int digit) {
		if(digit == M) {
			for(int i=0; i < M; i++) { 
				sb.append(list[i]).append(' '); // 1 1 2
			}
			sb.append('\n');
			return;
		}
		
		for(int i = idx; i<=N; i++) { // 1~3
			list[digit] = i; // list[0] = 1, 2
			DFS(i, digit+1); // DFS(1,1) DFS(2,1)
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]); // 3
		M = Integer.parseInt(input[1]); // 1
		
		list = new int[M+1]; 
		
		DFS(1,0);
		System.out.println(sb);
	}

}
