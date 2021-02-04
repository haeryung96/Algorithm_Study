import java.util.*;

/**
 * 스택 순열 문제
 * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
 * 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
 * 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 
 * 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 
 * **/

/**
 * How 구현?
 * 오름차순으로 숫자 입력, 입력된 숫자만큼 조건에 따라 pop , push를 수행
 * 스택의 맨위의 요소와 입력된 값이 같지 않다면 진행할 수 없으므로 No
 * **/
 
public class ex1874 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 테스트 개수 입력받기
		
		int[] pm = new int[t];
		Stack<Integer> s = new Stack(); // 스택 생성
		StringBuilder sb = new StringBuilder(); // 출력되는 값을 모으기 위해 

		int start =0 ;//처음 시작하는 값을 0으로 초기화
		
		//push(무조건 오름차순) 와 pop
		for(int i=0; i<t; i++) {
			pm[i] = sc.nextInt(); // 순열 요소 입력
			//push는 무조건 오름차순이여야 하므로 처음 값보다 순열 배열에 입력되는 값이 커야함
			if(pm[i] > start) {
				for(int j=start+1; j<=pm[i]; j++) {
					s.push(j);
					sb.append('+').append('\n');
					//System.out.println("+"); // 값이 push 되는 경우 +출력 -> 이렇게 하면 값을 입력할떄마다 결과값을 출력함 나중에 모아서 출력해야함
				}
				start = pm[i]; // 시작하는 값을 입렫되는 값으로 초기화
			}
			
			else if(s.peek() != pm[i]) {
				System.out.println("NO");
				return; // 리턴을 넣어주지 않으면 No를 출력하고 나서도 계속 수행
			}
			s.pop();
			sb.append('-').append('\n');
		}
		System.out.println(sb);

	}

}
