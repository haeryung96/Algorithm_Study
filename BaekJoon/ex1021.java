import java.util.*;

/*
 * How 구현?
 * 1. 계산해 본 결과 2번과 3번 연산이 수행된 경우를 카운트 해서 출력값을 나오게 하면 됨 
 * 2. 오른쪽 연산을 할지 왼쪽 연산을 할지를 구하는 기준은
 * 3. 큐의 사이즈를 반으로 줄인 다음 구하는 값의 해당 인덱스가 사이즈/2보다 작으면 왼쪽으로 연산
 * 4. 구하는 값의 해당 인덱스가 사이즈/2보다 크면 오른쪽으로 연산
 * 5. 주의 ! 인덱스 구할때는 iterator 사용하자.
 * 6. 주의 ! 사이즈가 홀수인 경우도 생각해줘야 함 (등호 = 넣기)
 * */

public class ex1021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 큐의 크기
		int m = sc.nextInt(); // 뽑아내려고 하는 수의 개수 

	    int cnt = 0 ; // 연산이 몇번 수행되는지 카운트하기 위해
		
		// 데크 사용 - 큐의 양쪽 끝에서 삽입과 삭제가 모두 발생할 수 있는 큐
		Deque dq = new LinkedList<>();
		
		//큐에 수를 넣기
		for(int i=1; i<=n; i++) {
			dq.add(i);
		}
		
		// 빼기를 원하는 값을 입력받기
		for(int i=1; i<=m; i++) {
			int num = sc.nextInt();
			
			// 연산 수행
			while(true) {
				int index = 0; // 몇번째 인덱스
				Iterator it = dq.iterator();
				
				while(it.hasNext()) { // 인덱스를 구하기 위해서 사용 
					if(Integer.parseInt(it.next().toString()) == num) 
						break;
					index ++;
				}
				// num 과 맨 앞의 수가 같다고 한다면 뺴기 
				if(Integer.parseInt(dq.peek().toString()) == num) {
					 dq.pollFirst();
					 break;
				}
				// 만약 찾는 수가 첫번째 원소가 아니라고 한다면
				else {
					// 왼쪽으로 움직이는 연산 수행 
					if(index <= dq.size()/2) { 
						dq.addLast(dq.removeFirst()); // 앞에 있는 원소를 뒤에 넣기 
						cnt ++;
					}
					//오른쪽으로 움직이는 연산 수행
					else {
						dq.addFirst(dq.removeLast()); // 마지막으로 뺀 값을 처음으로 넣기 
						cnt ++;
					}
				}
			}
		}
		System.out.print(cnt);
	}

}
