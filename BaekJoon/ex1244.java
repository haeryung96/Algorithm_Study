import java.io.*;
import java.util.StringTokenizer;

/*
 * How 구현?
 * 1. 시뮬레이션 
 */

public class ex1244 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 스위치 개수 
		int[] switchStatus = new int[N]; // 스위치의 상태 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i < N; i++) {
			switchStatus[i] = Integer.parseInt(st.nextToken()); // 스위치 상태 입력
		}
		
		int student = Integer.parseInt(br.readLine()); // 학생수 
		
		int [][] input = new int[student][2]; // 학생의 성별, 학생이 받은 수 
		
		for(int i=0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j < 2; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i < student; i++) {
			if(input[i][0] == 1) { // 남자라면
				// 남학생이 받은 수의 배수의 스위치를 반전시킴
				for(int k=0; k < N; k++) {
					if((k+1) % input[i][1]==0) { // 남학생의 수의 배수라면 
						switchStatus[k] = 1 - switchStatus[k]; // 스위치 반전 
					}
				}
			}
			
			else if(input[i][0] == 2) { // 여자라면 
				// 여자는 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서
				// 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꿈 
				int left = input[i][1] - 1; // 인덱스의 위치 하나 작게 잡음 2
				int right = input[i][1] - 1; // 2
				// 받은 수를 기준으로 좌우의 값이 일치하는지 검사 
				while(true) {
					left--; // 1
					right++; // 3
					
					if (left < 0 || right >= N || switchStatus[left]!=switchStatus[right]) { // 범위에서 벗어난다면
						// 인덱스 다시 원상복귀 
						left++;
						right--;
						break;
					}		
				}
				
				// 검사 후 대칭이라면 스위치 반전시키기
				for(int j=left; j <= right; j++) {
					if(switchStatus[j] == 1) {
						switchStatus[j] = 0;
					}
					else
						switchStatus[j] = 1;
				}
			}
		}
		
		// 출력값
		for(int i=0; i < N; i++) {
			System.out.print(switchStatus[i] + " ");
			if((i+1) % 20 == 0)
				System.out.println();
		}
		
	}

}
