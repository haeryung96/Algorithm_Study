package baekjoon;
import java.io.*;

// StringBuilder 사용 안하면 시간초과뜸 -> sysout은 메모리 많이 잡아먹음 

public class ex15651 {
	public static int N, M;
	public static int[] list; // 결과 저장할 list 배열 
	public static boolean[] isVisited; // 방문 여부 체크 배열 
	public static StringBuilder sb = new StringBuilder();
	
	public static void DFS(int digit) { // 반복문의 시작부분을 변경해줘야 하므로 인자를 하나 더 추가함 -> idx 
		if(digit == M) {
			for(int i=0; i < M; i++) {
				sb.append(list[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			// 중복이 허용 가능하므로 방문처리 제외
			list[digit] = i; // digit값의 자리는 i로 즉, 초기에는 0번 인덱시(첫번째자리)는 1임
			DFS(digit+1); // 현재의 i값보다 큰 경우를 탐색해야 하므로 i를 전달 후 반복문 시작부분에서 +1 해줌
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]); // 3
		M = Integer.parseInt(input[1]); // 1
		
		list = new int[M+1]; 
		isVisited = new boolean[N+1];
		
		DFS(0); // 초기의 시작은 1부터 N까지 탐색해야 하므로 0을 전달 
		System.out.println(sb);
	}

}
