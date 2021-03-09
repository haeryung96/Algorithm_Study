import java.io.*;
import java.util.*;

/*
 * How 구현?
 * 1. 최단 거리 -> BFS 사용
 * 2. 그래프의 최단 거리 테이블을 먼저 -1로 초기화하고 시작
 * 3. 왜냐면 나중에 거리 계산할때 편리하니까.
 * 4. 큐에 시작노드를 넣고 뺀 다음 방문하지 않은 노드인 경우 거리의 값을 갱신
 * 5. 거리의 누적 값을 구한 다음 k에 해당하는 값을 가진 노드의 번호를 반환
 * */

public class ex18352 {
	public static int n,m,k,x;
	// 이중 배열 리스트 정의 가능 - 노드의 연결을 표현하기 위해서 사용
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); 
	// 모든 도시에 대한 최단 거리 초기화
	public static int[] d = new int[300001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 도시의 개수
		m = Integer.parseInt(st.nextToken()); // 도로의 개수
		k = Integer.parseInt(st.nextToken()); // 거리 정보
		x = Integer.parseInt(st.nextToken()); // 출발 도시 번호 
		
		// 그래프 거리 및 최단 거리 테이블 초기화 - -1로 초기화 해야지 나중에 거리 계산할때 편리함
		for(int i=0; i<=n; i++) { // m개의 도로 
			graph.add(new ArrayList<Integer>());
			d[i] = -1; // 거리를 -1로 초기화
		}
		
		// 모든 도로 정보 입력 받기 
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()); 
			graph.get(a).add(b); // a = 1, b = 2 라면 1번 노드에 2번 노드가 연결되어있음을 표시함  인덱스 1에 값 2를 넣음
		}

		// 출발 도시까지의 거리는 0으로 설정 - 출발 도시에서 출발 도시의 거리는 0
		d[x] = 0;
		
		// 너비 우선 탐색(BFS) 수행 - 최단 거리 구하기
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(x); // 먼저 시작 노드를 넣고 시작 
		// 큐가 비기 전까지 반복
		while(!q.isEmpty()) {
			int now = q.poll(); // 현재 노드를 큐에서 빼고 시작
			// 현재 도시에서 이동할 수 있는 모든 도시를 확인 - 즉 노드에서 연결된 노드들을 검사함
			for(int i=0; i<graph.get(now).size(); i++) {
				int nextNode = graph.get(now).get(i); // 현재 노드에서 i번째 인덱스에 해당하는 노드 반환
				// 아직 방문하지 않은 도시라면
				if (d[nextNode] == -1) {
					// 최단 거리 갱신
					d[nextNode] = d[now] + 1; // 현재 노드의 거리에서 1씩 더해서 최단 거리 k 구하기 
					q.offer(nextNode); // 다음 노드를 큐에 삽입 - 나중에 현재 노드로 사용하기 위해서 
				}
			}	
		}
		
		// 최단 거리가 k인 모든 도시의 번호를 오름차순으로 출력
		boolean check = false;
		for(int i=1; i<=n; i++) { // 도시의 번호가 1부터 시작해서 n까지이기 때문에 1~n만큼 반복문 돌리기
			if(d[i] == k) { //최단 거리가 k인 경우
				System.out.println(i); // 도시의 번호를 출력해야하므로 i
				check = true; 
			}
		}
		// 만약 최단 거리가 K인 도시가 없다면 -1을 출력
		if(!check) System.out.println(-1);
	}
}
