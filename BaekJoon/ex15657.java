package baekjoon;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex15657 {
	public static int N, M;
	public static int inputArr[]; // 입력배열
	public static int[] list; // 결과 담는 배열
	public static boolean[] isVisited; // 방문여부 체크 배열 
	public static StringBuilder sb = new StringBuilder();

	public static void DFS(int digit, int idx, int[] input) { // digit 깊이 input 입력 숫자배열
		if(digit == M) {
			for(int i=0; i < M; i++) {
				sb.append(list[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=idx; i < N; i++) {
				list[digit] = inputArr[i];
				DFS(digit+1,i,input);			
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
		
		DFS(0, 0, inputArr);
		System.out.println(sb);
	}

}
