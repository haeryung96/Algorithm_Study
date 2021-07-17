package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex15666 {
	public static int N, M;
	public static int[] list;
	public static int[] inputArr;
	public static StringBuilder sb = new StringBuilder();
	
	public static void DFS(int digit,int idx, int input[]) {
		if(digit == M) {
			for(int i=0; i < M; i++) {
				sb.append(list[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		int exNum = 0;
		for(int i=idx; i < N; i++) {
			if(exNum != input[i]) {
				exNum = inputArr[i];
				list[digit] = inputArr[i];
				DFS(digit+1,i,input); 
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		list = new int[M];
		inputArr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i < inputArr.length; i++) {
			inputArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(inputArr);
		
		DFS(0,0, inputArr);
		System.out.println(sb);
	}

}
