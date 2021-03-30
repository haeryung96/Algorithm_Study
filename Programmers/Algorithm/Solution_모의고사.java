import java.util.ArrayList;
import java.util.Arrays;

/*
 * How 구현?
 * 1. answers에 들어오는 값과 각 사람이 가지고 있는 값을 비교
 * 2. 가장 많이 맞은 사람이 여러명일 경우
 * 3. Arraylist에 넣고 그 값을 출력
 */

public class Solution_모의고사 {
	
	public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        
        // 누가 정답을 많이 맞았는가를 카운트함 
        for(int i = 0; i < answers.length; i++) {
        	// 이동해가면서 배열의 값을 하나하나 비교함 
        	if(p1[i%p1.length] == answers[i]) cnt1++; 
        	if(p2[i%p2.length] == answers[i]) cnt2++;
        	if(p3[i%p3.length] == answers[i]) cnt3++;
        }
        
        int max = Math.max(Math.max(cnt1, cnt2), cnt3);
        
        ArrayList<Integer> list = new ArrayList<>();
        if(max == cnt1) list.add(1); // 1번사람
        if(max == cnt2) list.add(2); // 2번사람
        if(max == cnt3) list.add(3); // 3번사람 
        
        answer = new int[list.size()];
        
        for(int i=0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;   
    }

	public static void main(String[] args) {
		int[] sol = {1,2,3,4,5};
		int[] sol1 = {1,3,2,4,2};
		System.out.println(Arrays.toString(solution(sol)));
		System.out.println(Arrays.toString(solution(sol1)));

	}

}
