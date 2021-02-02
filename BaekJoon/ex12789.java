import java.util.*;

/**
 * 도키도키 간식드리미
 **/

/**
 * How 구현?
 * Stack으로 구현
 * 입력된 값을 stack에 넣음
 * 계속 넣다가 stack에 1이 들어가는 순간 pop하고 cnt 증가
 * 스택이 비어지는 순간 -> nice 나머지 -> sad
 * **/

public class ex12789 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 테스트 개수 입력
		
		int[] people = new int[t]; // 사람 배열 생성
		Stack<Integer> p = new Stack(); // 스택 생성
		
		for(int i=0; i<t; i++) {
			people[i] = sc.nextInt(); // 번호표 입력
		}
		
		int cnt = 1; // 가장 먼저 pop이 되는 원소를 cnt라고 설정 
		
		for(int i=0; i<t; i++) {
			p.push(people[i]);  // 입력된 값을 넣는다.
			while(!p.isEmpty()&&p.peek()==cnt) { // 스택의 배열이 비어있지 않고 맨 위의 값이 1이라면
				p.pop(); //값을 빼고
				cnt++;
			}
		}
		
		if(p.isEmpty()) System.out.println("Nice");
		else System.out.println("Sad");

	}

}
