package Level1;

import java.util.Arrays;

/*
 * How 구현?
 * 1. 0의 개수가 최저 순위, 0의 개수와 맞는 숫자개수의 합이 최고순위 
 * */

public class Solution_로또의최고순위와최저순위 {

	public static void main(String[] args) {
		int[] lottos1 = {44, 1, 0, 0, 31, 25};
		int[] win_nums1 = {31, 10, 45, 1, 6, 19};
		System.out.println(solution(lottos1, win_nums1));
		
		int[] lottos2 = {0, 0, 0, 0, 0, 0};
		int[] win_nums2 = {38, 19, 20, 40, 15, 25};
		System.out.println(solution(lottos2, win_nums2));
		
		int[] lottos3 = {45, 4, 35, 20, 3, 9};
		int[] win_nums3 = {20, 9, 3, 45, 4, 35};
		System.out.println(solution(lottos3, win_nums3));
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {1, 2, 3, 4, 5, 6}; // 1등-6 2등-5 3등-4 4등-3 5등-2 6등-그이외
        int[] answer = new int[2];
        
        int zeroCnt = 0; // 0이 몇개 있는지 카운트하기 
        Arrays.sort(lottos);
        for(int i=0; i < lottos.length; i++) {
        	if(lottos[i] == 0) zeroCnt++;
        }
        
        int winCnt = 0; // 맞는 번호가 몇개 있는지 카운트하기 
        Arrays.sort(win_nums);
        for(int i=0; i < lottos.length; i++) {
        	for(int j=0; j < win_nums.length; j++) {
        		if(lottos[i] == win_nums[j]) {
        			winCnt++;
        		}
        	}
        }
        
        System.out.println(zeroCnt); // 6
        System.out.println(winCnt); // 0

        answer[0] = zeroCnt + winCnt; //4 6
        answer[1] = winCnt; //2 6
        
        
        for(int i=0; i < 2; i++) {
        	if(answer[i] == 6) answer[i] = 1; // 6개 다 맞으면 1등
        	else if(answer[i] == 5) answer[i] = 2;
        	else if(answer[i] == 4) answer[i] = 3;
        	else if(answer[i] == 3) answer[i] = 4;
        	else if(answer[i] == 2) answer[i] = 5;
        	else answer[i] = 6;
        }
        
        return answer;
    }
}
