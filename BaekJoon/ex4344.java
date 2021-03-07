import java.io.*;
import java.util.*;


public class ex4344 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int c = Integer.parseInt(br.readLine()); // 테스트  개수 
		int[] score ; // 성적 배열 

		for(int i=0; i<c; i++) {
			st = new StringTokenizer(br.readLine()," "); // 학생의 수와 성적 입력받기
			
			int stNum = Integer.parseInt(st.nextToken()); // 학생의 수만 따로 받아오기
			score = new int[stNum]; // 성적 배열의 크기 할당
			
			double sum = 0; // 성적 누적 합 변수 초기화
			
			// 성적 입력 부분
			for(int j=0; j<stNum; j++) {
				int val = Integer.parseInt(st.nextToken()); // 성적 저장
				score[j] = val;
				sum += val;// 성적 누적 합 구하기
			}
			
			double avg = (sum/stNum); // 평균구하기
			double cnt = 0; // 평균이 넘는 학생 수 변수 카운트
			
			for(int j=0; j<stNum; j++) {
				if(score[j] > avg) {
					cnt++;
				}
			}
			
//			System.out.println(); -> 출력 형식이 잘못되었습니다 출력함 
			// 소수점 셋째자리까지 출력하기 위해서 
			System.out.printf("%.3f%%\n", (cnt/stNum)*100 );
		}
	}

}
