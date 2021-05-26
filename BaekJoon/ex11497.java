package baekjoon;
import java.io.*;
import java.util.*;

// 최소 난이도 배열을 만들어라 

/*
 * How 구현?
 * 1. 정렬 사용 
 * 2. 문제에서 높이가 2인것과 높이가 5인것도 서로 인접해있다 -> deque 사용
 * 3. 통나무 높이를 정렬한 배열을 기준으로 높이가 큰 순서대로 번갈아가며 앞뒤로 집어넣음
 * 4. 가장 작은 차이가 생기는 덱이 생성됨
 * 5. 덱에 들어있는 값을 배열로 옮겨서 인접한 요소끼리의 차이가 가장 큰 값을 난이도로 출력
 * */

public class ex11497 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for(int i=0; i < T; i++) {
			int N = Integer.parseInt(br.readLine()); // 통나무의 개수 
			int[] tong = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j < N; j++) {
				tong[j] = Integer.parseInt(st.nextToken()); // 통나무의 높이 입력 
			}
			
			Arrays.sort(tong); 

			Deque<Integer> dq = new ArrayDeque<>();

			
			for(int j = N-1; j >= 0; j--) {
				if(j%2 == 0) { // 인덱스의 위치가 짝수라면
					dq.addFirst(tong[j]);
				}
				else if(j%2 == 1) { // 인덱스의 위치가 홀수라면
					dq.addLast(tong[j]);
				}
			}
			
			int min = Math.abs(dq.getFirst() - dq.getLast()); // 맨 처음꺼와 맨 뒤의 꺼의 값도 포함시켜서 계산
			Integer[] ansTong = dq.toArray(new Integer[dq.size()]); // 덱을 인트형 배열로 다시 바꿈 
			
			for(int j=1; j < N; j++) {
				min = Math.max(min, Math.abs(ansTong[j] - ansTong[j-1])); // 배열 안의 원소들의 각각의 값의 차이를 구한 뒤 갱신 
			}
			
			System.out.println(min);
		}
		
	}

}
