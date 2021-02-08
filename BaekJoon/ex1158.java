import java.util.*;

/**
 * 요세푸스 문제
 **/

/*
 * How 구현?
 * 1. n명의 사람 입력받고 k번째 사람 입력 받기
 * 2. 입력받은 수 만큼 큐에 넣기
 * 3. k번째 사람부터 빼내는 것이기 떄문에 k-1까지의 수를 다시 빼서 넣기 
 * 4. 스트링 빌더에 결과값 넣은 다음 한꺼번에 출력
 * */

public class ex1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // n명의 사람
		int k = sc.nextInt(); // k번째 사람
		
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder(); // 출력되는 값을 모으기 위해
		
		for(int i=1; i<=n; i++) {
			queue.add(i); // 큐에 차례대로 값을 추가 
		}
		
		sb.append('<'); //먼저 괄호 넣고
		
		// 큐의 사이즈가 0이 될 때까지 반복
		while(queue.size()!= 0) {
			// k-1번째까지의 값을 다시 뒤로 넣기
			for(int i=0; i<k-1; i++) {
				queue.add(queue.poll()); //먼저 값을 뺀 후에 동시에 다시 큐에 넣기
			}
			// 다시 값을 빼기
			if(queue.size()>1) sb.append(queue.poll()).append(',').append(' ');
			else if(queue.size()==1) sb.append(queue.poll());
		}
		sb.append('>');
		System.out.println(sb);

	}

}
