import java.util.*;

/*
 * How 구현?
 * 1. 체육복의 유무에 대한 배열을 만들기 
 * 2. 여분의 체육복을 가지고 있다면 1, 그냥 자기꺼만 가지고 있다면 0, 도난당했다고 하면 -1 을 배열에 넣어주기 
 * 3. 주의해야 할 점은 맨 앞 사람과 맨 뒷 사람이다. 
 */

public class Solution_체육복 {
	
	    public int solution(int n, int[] lost, int[] reserve) {
	    	int[] student = new int[n]; // 학생들의 체육복 여부를 확인하는 배열 
	    	
	    	for(int i : reserve) { // reserve의 모든 배열을 확인해서 -> 여분의 체육복을 가지고 있다면 1
	    		student[i-1]++; // 인덱스는 0부터 시작하니까 
	    	}
	    	
	    	for(int i : lost) { // lost의 모든 배열을 확인하면서 체육복을 도난당했다면 -1
	    		student[i-1]--;
	    	}
	    	
	    	// 모든 배열을 검사하기
	    	for(int i = 0; i < student.length; i++) {
	    		// 체육복을 도난당했다면
	    		if(student[i] < 0) {
	    			if(i != student.length-1 && student[i+1] > 0) { // 마지막 번호의 학생이 아니고 현재 학생의 다음 번호의 학생이 여벌의 체육복을 가지고 있다면 
	    				student[i]++; // 현재 학생의 체육복 수를 늘려주고
	    				student[i+1]--; // 나눠준 다음번의 학생의 체육복 수를 줄여줌
	    			}
	    			else if(i !=0 && student[i-1] > 0) { // 첫번쨰 학생이 아니고 현재 학생의 전 번호의 학생이 여분의 체육복을 가지고 있다면
	    				student[i]++; // 현재 학생의 체육복의 수를 늘려주고
	    				student[i-1]--; // 나눠준 이전 번호의 학생의 체육복 수를 줄여줌
	    			}
	    		}
	    	}
	        int answer = 0;
	        
	        for(int i=0; i < student.length; i++) {
	        	if(!(student[i] < 0)) { // 체육복을 가지고 있는 학생의 수 카운트하기
	        		answer++;
	        	}
	        }
	        return answer;
	    }
	

	public static void main(String[] args) {
	}

}
