import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시작점은 동규 

public class ex12761 {
	public static int A, B, N, M; // 스카이 콩콩 힘 A, B 그리고 동규의 위치 N 주미의 위치 M
	public static Queue<Integer> q = new LinkedList<>();
	
	public static void BFS(int dong) {
		int[] stones = new int[100001];
		q.offer(dong);
		stones[dong] = 1; // 방문처리
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			if(x == M) { // 주미에게 도착했다면
				break;
			}
			
			int[] tmp = move(x);
			
			for(int k = 0; k < 8; k++) {
				int next = tmp[k];
				
				if(0 <= next && next <= 100000 && stones[next] == 0) { // 범위에 있고 방문하지 않았다면
					stones[next] = stones[x] + 1;
					q.offer(next);
				}
			}
		}
		
		System.out.println(stones[M] - 1);
	}
	
	public static int[] move(int x){ // 방향 
		int[] tmp = new int[8];
		
		tmp[0] = x + 1;
		tmp[1] = x - 1;
		tmp[2] = x + A;
		tmp[3] = x - A;
		tmp[4] = x + B;
		tmp[5] = x - B;
		tmp[6] = x * A;
		tmp[7] = x * B;
		
		return tmp;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		BFS(N);
	}

}
