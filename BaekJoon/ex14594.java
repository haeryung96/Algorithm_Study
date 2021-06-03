import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * How 구현?
 * 1. Simulation
 */

public class ex14594 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 동이라방의 개수
		int M = Integer.parseInt(br.readLine()); // 빅-종빈빌런의 행동 횟수 
		
		int[][] arr = new int[M][2];
		boolean [] chk = new boolean[N];
		
		StringTokenizer st;
		for(int i=0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken()); // x번 방 1
			int y = Integer.parseInt(st.nextToken()); // y번 방 2
			for(int j = x-1; j < y-1; j++) { // 인덱스의 시작은 0부터 했으니까 1씩 빼줌
				chk[j] = true; // 1 2 true 2 3 4 true
			}
		}
		
		int cnt = 0;
		
		for(int i=0; i < N; i++) {
			if(chk[i] == false) cnt++;
		}
		
		System.out.println(cnt);
	}

}
