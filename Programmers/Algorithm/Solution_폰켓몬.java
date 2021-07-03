package Level1;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * How 구현?
 * 1. 배열 정렬 후 중복 제거
 * 2. 배열의 길이/2 가 포켓몬의 사이즈보다 작다면 길이 더하기
 * 3. 반대면 포켓몬의 사이즈 더하기 
 * */

public class Solution_폰켓몬 {

	public static void main(String[] args) {
		int[] nums1 = {3,1,2,3};
		System.out.println(solution(nums1));
		
		int[] nums2 = {3,3,3,2,2,4};
		System.out.println(solution(nums2));

		int[] nums3 = {3,3,3,2,2,2};
		System.out.println(solution(nums3));

		
	}
	
	public static int solution(int[] nums) {
        int answer = 0;
        
        Arrays.sort(nums); // 1 2 3 3 
        
        ArrayList<Integer> poketmon = new ArrayList<>(); // 포켓몬 
        
        for(int i=0; i < nums.length; i++) {
        	int n = nums[i];
        	
        	if(!poketmon.contains(n)) {
        		poketmon.add(n);
        	}
        }
        
//      System.out.println(poketmon.toString());
        
        int len = nums.length;
        
        if(len/2 < poketmon.size()) {
        	answer += len/2;
        }
        else if(len/2 == poketmon.size()){
        	answer += poketmon.size();
        }
        else {
        	answer += poketmon.size();
        }
        
        return answer;
    }
}
