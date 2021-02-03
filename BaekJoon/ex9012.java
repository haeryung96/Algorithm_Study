import java.util.*;

/**
 * 괄호 문자열 
 * 문자 ( 인 경우 push 하고
 * 문자 ) 인 경우 pop을 하고 난 후,
 * 스택에 모든 문자가 사라지게 되면 vps가 true 이고 스택에 모든 문자가 사라지지 많은다면 vps가 false가 됨 
 * 예외) 만약 닫는 괄호가 입력이 되었지만 여는 괄호가 없으면 이 또한 false이므로 주의해야함 
 **/

/**
 * 주의해야 할 점 (내가 실수한 부분)
 * stack 선언을 반복문이 아닌 main에 선언함
 * Why? 각각의 케이스에 대한 스택을 초기화 한 뒤에 사용해야함 
 * 메인에 작성하면 stack 클래스가 모든 케이스에 공유되고 있기 때문에 
 * 만약에 이전 케이스에서 여는 괄호가 많아 No를 출력했을 경우 
 * 다음 케이스에서는 여는 괄호가 스택에 그대로 남게 되어 제대로 값을 내지 못함
 * 만약 밖에 선언하고 싶다면 
 * for문 안에서 stack.clear()를 사용해서 스텍을 비워주자
 * **/
 

public class ex9012 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt(); //테스트 개수 입력받기
		
		//Stack<Character> vps = new Stack<>(); //스택 생성
		
		String[] string = new String[t] ;
		
		for(int i = 0; i < t; i++) {
			Stack<Character> vps = new Stack<>(); //스택 생성
			string[i] = sc.next(); // 문자열 입력받기 - 괄호 입력
			
			// 입력받은 문자열의 길이만큼 반복
			for(int j=0; j<string[i].length(); j++) {
				char c = string[i].charAt(j); // 인덱스에 있는 문자반환
				// 해당 인덱스에 위치한 문자가 "("일 경우 push
				if(c == '(') {
					vps.push(c);
				}
				//만약 닫는 괄호를 입력받았지만 여는 괄호가 없어서 pop을 할 수 없는 경우
				else if(vps.isEmpty()) {
					vps.push(c);
					break;
				}
				else
					vps.pop();  // "("을 pop시킴
			}
			if(vps.isEmpty()) {
				System.out.println("YES");    // 배열이 비어있다면 
				}else 
					System.out.println("NO");  // 배열이 안비어있다면 
	         }
		}
}

/**
 * 실수한 부분
 * else if(vps.isEmpty()) {
					System.out.println("No");
					break;
				}
 * 이 부분이 오류인 이유는 ? 			
 * 배열이 비어있다면 
 * No를 출력하고 밖에 나와서 if(vps.isEmpty)부분에서 Yes를 만나니까 둘다 출력하게 됨 -> 출력초과
 * 그 경우를 방지하기 위해서 else if문에 임의로 아무 값을 넣은 다음에 
 * 반복문을 나가서 vps가 비어있다면 yes를 출력하고 vps가 비어있지 않다면 No를 출력하게 함
 * **/
 
