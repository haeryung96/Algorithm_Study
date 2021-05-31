import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * How 구현?
 * 1. 시뮬레이션
 */

public class ex1063 {
	public static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[8][8]; // 체스 판
		
		String[] input = br.readLine().split(" ");
		String kingPos = input[0]; // 킹의 위치
		String stonePos = input[1]; // 돌의 위치
		int N = Integer.parseInt(input[2]); // 움직이는 횟수 
		
		String[] move = new String[N]; // 킹이 움직이는 방향 
		for(int i=0; i < N; i++) {
			move[i] = br.readLine();
		}
		
		int kingX = kingPos.charAt(0) - 'A'; // 스트링 문자를 숫자로 A : 65 -> 인덱스 0부터
		int kingY = kingPos.charAt(1) - '1'; // 문자인 숫자를 숫자로 0 : 48 -> 인덱스 0부터 나중에 계산할때 +1 해줘야함 체스판은 인덱스 1부터 시작함 
		int stoneX = stonePos.charAt(0) - 'A';
		int stoneY = stonePos.charAt(1) - '1';
		
		for(int i=0; i < N; i++) {
			String str = move[i];
			switch(str) {
			case "R" : // 한칸 오른쪽
				if(kingX < 7) { // 인덱스 7의 위치에 있는 것은 한칸 오른쪽으로 이동할 수 없음 
					kingX++; // 미리 이동시킴
					if(kingX == stoneX && kingY == stoneY) { // 킹이 돌과 같은 곳으로 이동할 때는 돌을 킹이 움직인 방향과 같은 방향으로 한 칸 이동시킴
						if(stoneX < 7) {
							stoneX++;
						}
						else { // 킹이나 돌이 체스판 밖으로 나갈 경우에는 그 이동은 건너뜀  
							kingX--; // 원상복귀 
						}
					}
				}
				break;
				
			case "L": // 한칸 왼쪽으로
				if(kingX > 0) {
					kingX--;
					if(kingX == stoneX && kingY == stoneY) {
						if(stoneX > 0) {
							stoneX--;
						}
						else {
							kingX++;
						}
					}
				}
				break;
				
			case "B": // 한 칸 아래로
				if(kingY > 0) {
					kingY--;
					if(kingX == stoneX && kingY == stoneY) {
						if(stoneY > 0) {
							stoneY--;
						}
						else {
							kingY++;
						}
					}
				}
				break;
				
			case "T": // 한 칸 위로
				if(kingY < 7) {
					kingY++;
					if(kingX == stoneX && kingY == stoneY) {
						if(stoneY < 7) {
							stoneY++;
						}
						else {
							kingY--;
						}
					}
				}				
				break;
				
			case "RT": // 오른쪽 위 대각선으로
				if(kingX < 7 && kingY < 7) {
					kingX++;
					kingY++;
					if(kingX == stoneX && kingY == stoneY) {
						if(stoneX < 7 && stoneY < 7) {
							stoneX++;
							stoneY++;
						}
						else {
							kingX--;
							kingY--;
						}
					}
				}
				break;
				
			case "LT": // 왼쪽 위 대각선으로
				if(kingX > 0 && kingY < 7) {
					kingX--;
					kingY++;
					if(kingX == stoneX && kingY == stoneY) {
						if(stoneX > 0 && stoneY < 7) {
							stoneX--;
							stoneY++;
						}
						else {
							kingX++;
							kingY--;
						}
					}
				}
				break;
				
			case "RB": // 오른쪽 아래 대각선
				if(kingX < 7 && kingY > 0) {
					kingX++;
					kingY--;
					if(kingX == stoneX && kingY == stoneY) {
						if(stoneX < 7 && stoneY > 0) {
							stoneX++;
							stoneY--;
						}
						else {
							kingX--;
							kingY++;
						}
					}
				}
				break;
				
			case "LB": // 왼쪽 아래 대각선으로
				if(kingX > 0 && kingY > 0) {
					kingX--;
					kingY--;
					if(kingX == stoneX && kingY == stoneY) {
						if(stoneX > 0 && stoneY > 0) {
							stoneX--;
							stoneY--;
						}
						else {
							kingX++;
							kingY++;
						}
					}
				}
				break;
				
				
			}
		}
		
		char kxRes = (char)(kingX + 'A');
		char kyRes = (char)(kingY + '1');
		char sxRes = (char)(stoneX + 'A');
		char syRes = (char)(stoneY + '1');
		
		System.out.println(kxRes + "" + kyRes);
		System.out.println(sxRes + "" + syRes);
	}

}
