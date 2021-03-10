import java.util.*;
import java.io.*;

/*
 * How 구현?
 * 1. nQueen 문제는 전형적인 백트래킹 문제
 * 2. 서로 공격하지 않으려면 같은 행과 열 그리고 대각선에 위치하면 안됨
 * 3. 체스판을 2차원 배열이 아닌 1차원 배열로도 사용 가능 
 * 4. -> 각 원소의 인덱스를 열이라고 가정하고 원소 값을 행이라고 생각하면 됨. 
 * 5. 첫번째 열부터 한개씩 채워나가면서 놓을 수 있는 위치라면 재귀호출을 하면서 채워나가면 됨 
 * 6. 재귀 호출하면서 조건문을 사용해 놓을 위치가 다른 퀸으로부터 위협받는지 검사
 */

public class ex9663 {
	public static int[] arr; // 퀸의 위치에 대한 정보를 저장하는 배열 
	public static int n; // 체스판의 크기 
	public static int cnt = 0; // 퀸이 서로 공격할 수 없게 놓는 경우의 수 
	
	public static void nQueen(int level) {
		// 모든 원소를 다 채운 상태면 cnt 증가 및 return
		if(level == n) { // 모든 퀸을 다 채웠다면
			cnt++; // 서로 공격할 수 없다는 의미이니까 카운트해줌 
			return;
		}
		
		for(int i=0; i<n; i++) { 
			arr[level] = i; 
			//놓을 수 있는 위치일 경우 재귀호출
			if (Possibility(level)) {
				nQueen(level+1); // 재귀 호출 
			}
		}
	}
	
	// 퀸을 놓을 수 있는 위치인지 아닌지를 확인하기 위한 메소드 
	public static boolean Possibility(int col) {
		
		for(int i=0; i<col; i++) {
			// 해당 열의 행과 i열의 행이 일치하는 경우 (같은 행에 존재할 경우)
			if(arr[col] == arr[i]) {
				return false;
			}
			
			/*
			 * 대각선상에 놓여있는 경우
			 * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우)
			 * 만약 3,3에 퀸이 위치해있다면 대각선의 x,y좌표 빼기 퀸의 x,y 좌표의 값을 빼면 두 값은 항상 같은 값이 나옴
			 */
			
			else if (Math.abs(col-i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		nQueen(0); // 0부터 호출
		
		System.out.println(cnt);
	}

}
