import java.util.*;

/**
 * N장의 카드가 있다.
 * 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여있다. -> 큐로 구현
 * 예를 들어 N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다. 
 * 1을 버리면 234가 남는다. 여기서 2를 제일 아래로 옮기면 342가 된다. 
 * 3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다. 
 * 마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.
 * **/

public class ex2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt(); // 테스트 케이스 입력
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=t; i++) {
			q.add(i);    // 큐에 차례대로 값을 추가
		}
		
		while(q.size() > 1) { // 큐의 크기가 1보다 크면 반복
			q.poll(); // 맨 앞의 값을 꺼냄 
			q.add(q.poll()); // 꺼낸 값을 다시 뒤에 넣기
		}
		
		System.out.println(q.peek());	// 마지막으로 남은 원소 출력 - 맨 앞 원소 빼기
	}

}
