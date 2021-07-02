package Kakao;

import java.util.Stack;

/*
 * How 구현?
 * 1. 보드의 y축만 검사하니까 x는 고정하고 반복문 돌리기
 * 2. 바구니에 있는 인형과 보드에 있는 인형을 비교
 * 3. 같은 인형이면 없애고 +2, 다른 인형이면 바구니에 넣기 
 * 4. 바구니에 넣었으면 보드의 인형은 0으로 대체
 * */

public class Solution_크레인인형뽑기게임 {

	public static void main(String[] args) {
		int[][] board1 = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] mv1 = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board1,mv1));
	}
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<Integer>(); // 바구니 
        
        for(int mv : moves) {
        	for(int i=0; i < board.length; i++) {
        		if(board[i][mv-1] !=0) {  // 뺼 인형이 있다면 
        			// 바구니 안에 있는 인형과 보드의 인형이 같다면 
        			if(!basket.isEmpty() && basket.peek() == board[i][mv-1]) { // 스택이 0인경우 에러뜨니까 예외처리해야함
        				basket.pop(); // 인형을 빼고
        				answer += 2; // 인형 2개가 동시에 터짐 
        			}
        			else { // 바구니 안에 있는 인형과 보드의 인형이 다르다면
        				basket.add(board[i][mv-1]);
        			}
        			board[i][mv-1] = 0; // 이미 보드안에서 인형을 뺐으니까 보드에 인형의 개수를 0으로 만들기 
        			break; // 빠져나오기 
        		}
        	}
        }
        return answer;
    }
}
