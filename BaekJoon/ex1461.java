import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 로직
 * 음수와 양수를 나워서 연결리스트에 넣기 
 * 가장 큰 값은 마지막에 가는것이 좋음 -> 다시 원점으로 돌아오지 않아도 되기 때문 
 */

public class ex1461 {
	static int N, M;
	static LinkedList<Integer> plus = new LinkedList<>(); // 양수 위치에 있는 책 
	static LinkedList<Integer> minus = new LinkedList<>(); // 음수 위치에 있는 책

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]); // 책의 개수 
		M = Integer.parseInt(input[1]); // 한 번에 들 수 있는 책의 개수 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int location = Integer.parseInt(st.nextToken());
			
			if(location > 0) {
				plus.add(location);
			}
			else {
				minus.add(Math.abs(location)); // 절대값으로 값 추가 
			}
		}
		
		Collections.sort(plus, Collections.reverseOrder()); // 내림차순으로 정렬
		Collections.sort(minus, Collections.reverseOrder()); // 내림차순으로 정렬 
		
		int res = 0; // 결과값
		int max = 0;
		
		// 한번만 방문해도 되는 양수 음수 리스트 중 최대값 구하기 
		if(!plus.isEmpty() && !minus.isEmpty()) { 
			if(plus.peek() > minus.peek()) { 
				max = plus.peek();
			}
			else { // 음수의 최대값이 더 크다면
				max = minus.peek();
			}
		}
		else if (!plus.isEmpty() && minus.isEmpty()) {
			max = plus.peek();
		}
		else if(plus.isEmpty() && !minus.isEmpty()) {
			max = minus.peek();
		}
		
		while(!plus.isEmpty()) {
			int tmp = plus.poll(); // 이미 한개 뽑았으니까 
			
			for(int i=0; i < M - 1; i++) {
				plus.poll();
				
				if(plus.isEmpty()) {
					break;
				}
			}
			
			res += tmp * 2;
		}
		
		while(!minus.isEmpty()) {
			int tmp = minus.poll();
			
			for(int i = 0; i < M - 1; i++) {
				minus.poll();
				
				if(minus.isEmpty()) {
					break;
				}
			}
			
			res += tmp * 2;
		}
		
		// 최대값은 한번 더 더해지기 때문에 빼기 
		System.out.println(res - max);
	}

}

/*
 * 7 2
 * -39 -37 -29 -28 -6 2 11
 * 
 * */
 
