package Kakao;

/*
 * How 구현?
 * 1. 일단 정렬해서 일치하지 않은 것을 반환하면 되겠다 라는 생각은 했음
 * 2. 근데 int i의 값을 초기화하지 않아도 return participant[i]가 오류가 안 뜨는 이유를 모르겠음
 * 3. 반복문을 돌릴때 2번까지만 돌리면 이게 어캐 되는거지??? 
 * 4. 문제를 이해하는 건 어렵지 않은데 총체적 난국이다... 
 */

/*
 * 코드 해석
 * 1. 예제 1의 경우
 * 2. for 문은 마지막 i가 2인 상태로 종료됨
 * 3. i++ 이 되고 i의 범위를 확인했을 때 조건에 맞지않아 for문이 중지됨
 * 4. 따라서 i의 선언이 for문 밖에 있으므로 for문 밖으로 쓸 수 있는 i는 2를 가지고 있음
 * 5. 결론적으로 마지막에 있는 return participant[i]는 participant[2]이 됨 
 * */

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_완주하지못한선수 {

	public static void main(String[] args) {
		String[] participant1 = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		String ans1 = solution(participant1, completion);
		System.out.println(ans1);
		
		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
		String ans2 = solution(participant2, completion2);
		System.out.println(ans2);
		
		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
		String[] completion3 = {"stanko", "ana", "mislav"};
		String ans3 = solution(participant3, completion3);
		System.out.println(ans3);
	}
	
	public static String solution(String[] participant, String[] completion) {
//        String[] answer;
        
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i < participant.length; i++) {
            System.out.print(participant[i].toString() + " ");
        }
        
        System.out.println();
        
        for(int i=0; i < completion.length; i++) {
            System.out.print(completion[i].toString() + " ");
        }
        
//        int i;
//        
//        for(String tmp : completion) {
//        	i = 0;
//        	
//        	if(!participant[i].equals(completion[i])) {
////        		ans.add(participant[i]);
//        		return participant[i];
//        	}
//        	
//        	i++;
//        } // 이 풀이는 왜 위에랑 똑같은데 아래에서 return 할때 i의 값을 초기화하라고 할까..? 위에는 안그러는데..
       
        
        System.out.println();
        
        int i; // 전역변수

        for(i=0; i < completion.length; i++) {
        	if(!participant[i].equals(completion[i])) {
        		return participant[i];
        	}
        }
        
        return participant[i];
        
    }

}
