import java.util.*;
import java.io.*;

public class ex15649 {
	public static int N, M; // 입력받는 값들
	public static int[] arr; // 탐색 과정 중에서의 값을 담기 
	public static boolean[] visited; // 방문 여부 확인 
	public static StringBuilder sb = new StringBuilder(); // 모아서 출력하기 용 
	
	public static void dfs(int level) { 
		// 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력 
		if(level == M) { //깊이가 M과 같다면 더이상 탐색을 할 필요가 없으므로 
			for(int val : arr) { // 배열안에 있는 노드의 값을 모두 출력
				sb.append(val).append(' '); // 스트링빌더에 한칸씩 띄워서 저정하주기
			}
			sb.append('\n'); // 개행해주기
			return;
		}
		
		for(int i=0; i<N; i++) { // N번 노드까지 검사
			if(!visited[i]) { // 방문하지 않은 노드라면
				visited[i] = true; // 방문했다고 바꿔주고 
				arr[level] = i + 1; // 해당 깊이를 index로 하여 i+1 값 저장
				dfs(level +1);  // 다음 자식 노드 방문을 위해서 level 1 증가시키면서 재귀 호출
				// 자식 노드 방문이 끝나고 돌아오면 방문 노드를 방문하지 않은 상태로 변경 
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visited = new boolean[N];
		
		dfs(0);
		System.out.println(sb);
		
	}

}
