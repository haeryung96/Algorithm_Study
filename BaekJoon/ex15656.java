package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * N개의 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 수열은 사전 순으로 증가하는 순서로 출력
 * */
public class ex15656 {
	public static int N, M;
	public static int inputArr[]; // 입력배열
	public static int[] list; // 결과 담는 배열
	public static boolean[] isVisited; // 방문여부 체크 배열 
	public static StringBuilder sb = new StringBuilder();
	
	public static void DFS(int digit, int[] input) {
		if(digit == M) {
			for(int i=0; i < M; i++) {
				sb.append(list[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=1; i <= N; i++) {
			list[digit] = inputArr[i-1];
			DFS(digit+1, input);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		list = new int[M];
		isVisited = new boolean[N+1];
		
		inputArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i < N; i++) {
			inputArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(inputArr);
		
		DFS(0, inputArr);
		System.out.println(sb);
	}

}
