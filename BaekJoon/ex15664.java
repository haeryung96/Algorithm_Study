package baekjoon;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex15664 {
	public static int N, M;
	public static int[] inputArr;
	public static int[] list;
	public static boolean[] isVisited;
	public static StringBuilder sb = new StringBuilder();
	
	public static void DFS(int digit,int idx, int[] input) { // digit 깊이 input 입력 숫자배열
		if(digit == M) {
			for(int i=0; i < M; i++) {
				sb.append(list[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		int exNum = 0; // 이전의 숫자 

		for(int i=idx+1; i <= N; i++) {
			if(!isVisited[i]) {
				if(exNum != inputArr[i-1]) {
					isVisited[i] = true;
					exNum = inputArr[i-1];
					list[digit] = inputArr[i-1];
					DFS(digit+1,i,input);
					isVisited[i] = false;
				}
			}
						
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
		
		DFS(0,0, inputArr);
		System.out.println(sb);
	}

}
