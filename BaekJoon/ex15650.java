package baekjoon;
import java.io.*;

public class ex15650 {
	public static int N, M;
	public static int[] list; // 결과 저장할 list 배열 
	public static boolean[] isVisited; // 방문 여부 체크 배열 
	
	public static void DFS(int idx, int digit) { // 반복문의 시작부분을 변경해줘야 하므로 인자를 하나 더 추가함 -> idx 
		if(digit == M) {
			for(int i=0; i < M; i++) {
				System.out.print(list[i] + " ");
			}
			System.out.println();
			return;
		}
    
	  // 반복문의 시작 부분을 변경해줘야함
		// 초기에 시작할 때는 두번째 자리는 1부터 N까지 탐색
		// 2로 시작할 때는 두번째 자리는 3부터 N까지 탐색
		// 위의 과정 계속 반복 
		for(int i = idx+1; i <= N; i++) {
			if(isVisited[i]) continue; // 이미 방문한 경우 넘김
			isVisited[i] = true; // 방문하지 않은 경우는 방문처리
			list[digit] = i; // digit값의 자리는 i로 즉, 초기에는 0번 인덱시(첫번째자리)는 1임
			DFS(i, digit+1); // 현재의 i값보다 큰 경우를 탐색해야 하므로 i를 전달 후 반복문 시작부분에서 +1 해줌
			isVisited[i] = false; // 모두 찾은 후에는 다시 방문 여부를 초기화
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]); // 3
		M = Integer.parseInt(input[1]); // 1
		
		list = new int[M+1]; 
		isVisited = new boolean[N+1];
		
		DFS(0,0); // 초기의 시작은 1부터 N까지 탐색해야 하므로 0을 전달 
	}

}
