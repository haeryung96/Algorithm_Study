package Level2;

public class Solution_카펫 {
	// 가로 * 세로 크기 brown + yellow
	// 행 - 가로 열 - 세로 

	public static void main(String[] args) {
		int brown1 = 10;
		int yellow1 = 2;
		System.out.println(solution(brown1, yellow1));
		
		int brown2 = 8;
		int yellow2 = 1;
		System.out.println(solution(brown2, yellow2));
		
		int brown3 = 24;
		int yellow3 = 24;
		System.out.println(solution(brown3, yellow3));
	}

	public static int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        
        int size = brown + yellow;
        
        for(int i=1; i <= yellow; i++) {
        	int yRow = i; // 가로 길이
        	int yCol = yellow / i;
        	
        	if(yellow % i != 0) { // 노란타일 10개일 경우 (1, 10) (2, 5)만 가능함 -> 예로 3을 걸러낼 수 있음
        		continue;
        	}
        	
        	int bSize = ((yRow + 1) * 2) + ((yCol + 1) * 2);
        	if(bSize == brown) {
        		answer[0] = yRow + 2;
        		answer[1] = yCol + 2;
        	}
        }
        
        return answer;
    }
}
