import java.util.*;

/* How 구현?
 * 1. 입력된 숫자가 0이 아니라면 스택에 넣기
 * 2. 입력된 숫자가 0이라면 마지막에 들어온 원소를 삭지
 * 3. 스택에 들어있는 값을 가지고 와서 합하기
 * */

public class ex10773 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		Stack<Integer> st = new Stack<>();
		
		for(int i=0; i<k; i++) {
			int num = sc.nextInt();
			
			if(num != 0 ) {
				st.add(num); // 입력된 값이 0이 아니라면 stack에 값 넣기 
			}
			else if(num == 0) { // 입력된 값이 0이라면
				st.pop(); // 마지막에 들어온 값 빼내기
			}
		}
		int sum = 0; // 남은 배열의 원소 합
		
		for(int i=0; i<st.size(); i++) {
			sum += st.get(i); // 남은 배열의 원소값을 누적으로 더하기
		}
		System.out.println(sum);
	}
}

/*
 * 주의!
 * 1. LinkedList 사용하니까 오류 뜸
 * 2. 왜?
 * 3. LinkedList에서 remove와 add는 리스트의 처음부터 끝까지 탐색하는 것을 잊지 말자 !!!!
 * 4. O(n)의 시간이 걸림
 * 5. 스택 또는 큐의 시간복잡도는 O(1)로 매우 빠름 !!!
 * */
