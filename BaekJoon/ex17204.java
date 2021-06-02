import java.io.*;

/*
 * How 구현?
 * 1. Simulation
 * 2. 예제 2
 * 3. 0 -> 1, 1 -> 3, 3 -> 4, 4 -> 0 지목하게 되고 0번은 1번을 지목하게 되므로 보성이 지목 X
 * 4. 예제 1
 * 5. 0 -> 1 1 -> 3 2번만에 보성이 지목 
 * 6. 문제 이해하는데 오래걸림... 
 */

public class ex17204 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); // 게임에 참여하는 사람의 수 
		int K = Integer.parseInt(input[1]); // 보성이의 번호 
		
		int[] arr = new int[N];
		for(int i=0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine()); // 각각의 학생이 지목한 번호 
		}
		
		boolean visited[] = new boolean[N];
		int next = arr[0]; // 0번은 1번 지목 
		int cnt = 1;
		
		while(true) {
			
			if(visited[next] == true) { // 다시 1로 돌아올때 1번 이미 방문
				System.out.println("-1");
				return;
			}
			
			else {
				if(next == K) { // 지목된 사람이 보성이라면 
					System.out.println(cnt); 
					return;
				}
				
				visited[next] = true; // 방문처리 1번 방문 3번 방문 4번 방문 0번 방문 
				next = arr[next]; // 3번 4번 0번 1번 
			}
			
			cnt++;
		}
		
	}

}
