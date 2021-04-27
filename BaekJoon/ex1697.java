import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * How 구현?
 * 1. 최단거리 -> BFS
 * 2. 모든 케이스의 이동시 걸리는 시간은 1초
 * 3. 시작점을 기준으로 한 칸 앞으로, 한 칸 뒤로, *2칸의 경우를 모두 탐색한 후
 * 4. 동생의 위치와 옮겨진 좌표가 동일하다면 값을 출력
 */

public class ex1697 {
	static int N;
	static int K;
	static int[] visited = new int[100001]; // 방문 여부 + 움직인 횟수를 저장해놓은 배열 
	
	public static void bfs(int Node) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(Node); // 수빈이가 있는 위치의 노드를 큐에 삽입
		visited[Node] = 1; // 수빈이가 있는 위치의 노드를 방문처리, 방문 배열을 1로 채움 
		
		while(!q.isEmpty()) { // 큐가 비기전까지 반복
			int tmp = q.poll(); // 탐색을 시작할 부모노드
			
			for(int i=0; i < 3; i++) {
				int next; // 부모노드의 자식노드가 될 노드들
				
				if(i == 0) { // 첫번째 케이스 
					next = tmp + 1; // 한 칸 앞으로
				}
				else if(i == 1) {
					next = tmp - 1; // 한 칸 뒤로
				}
				else {
					next = tmp * 2; // 두 배로 뛰기
				}
				
				if(next == K) { // 옮겨진 좌표가 동생의 좌표라면
					System.out.println(visited[tmp]);
					return; // 반복문 밖을 나가는 것이 아니라 호출된 함수의 밖으로 나감 
				}
				
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]); // 수빈이가 있는 위치
		K = Integer.parseInt(input[1]); // 동생이 있는 위치 
		
		if(N == K) { // 수빈이와 동생의 위치가 같다면
			System.out.println(0);
		}
		else { // 같지 않다면
			bfs(N); // bfs 탐색 시작 
		}
	}

}
