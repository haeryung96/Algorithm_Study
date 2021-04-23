import java.util.*;

/*
 * How 구현?
 * 1. 가장 몸무게가 적은 사람과 가장 높은 몸무게가 높은 사람의 합이 limit보다 큰가 작은가 판단하기
 * 2. 즉, 배열을 정렬해서 가장 오른쪽 원소와 가장 왼쪽 원소의 합을 구해서, 무게 제한보다 크냐 작냐를 나누어 해결
 * 3. 만약 가장 오른쪽 원소와 가장 왼쪽 원소의 합이 limit보다 크다면 각각 따로 보트에 태워보냄
 * 4. 위의 경우와 반대로, 두 원소의 삽이 무게제한보다 작다면 두명은 함꼐 태울 수 있으므로 함꺠 태워보내고 
 * 5. 그 후, 가장 앞 사람은 보트에 태워 보냈으므로, 인덱스++ 헤주기 
 * 주의 *
 * for 문의 조건에서 left 와 right 의 값이 만날때까지 반복해서 보트를 태워보내면 됨 
 */

public class Solution_구명보트 {
	
	public int solution(int[] people, int limit) {
        int left = 0; 
        int right = people.length - 1;
        int answer = 0;
        
        Arrays.sort(people);
        
        for(int i = right; left <= i; i--){
		
            // 두 명의 몸무게가 리미트보다 크면 한 사람만 보트에 태워 보내기
            if(people[i] + people[left] > limit){
                answer++;
            }
            
            // 최소 + 최대 몸무게의 합이 무게제한보다 같거나 작은 경우
            // 두 명을 한보트에 태우기
            // 그 다음으로 몸무게가 작은 인원을 기준으로 삼아야 하기 떄문에 i의 값을 늘려줌 
            else {
                answer++;
                left++;
            }
        }
        
        return answer;
    }
	
	public static void main(String[] args) {

	}

}
