import java.util.*;
import java.io.*;

/*
 * How 구현?
 * 이전의 선택 결과가 이후의 결과에 영향을 미치지 않으려면 먼지 이전 선택의 종료 시간과
 * 이후 선택의 시작 시간이 겹치지 않으면 됨
 * 최대한 많은 활동을 선택하려면 종료시간이 빨라야 할 수 밖에 없음
 * 따라서, 서로 겹치지 않는 활동에 대해 종료시간이 빠르면 더 많은 활동을 선택할 수 있는 시간이 많아짐 !! -> sort compare 사용해서 풀이 
 * */

public class ex1931 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); 
		
		int[][] time = new int[n][2]; // 시작지점은 time[][0] 종료지점은 time[][1]로 지정
		
		StringTokenizer st;
		
		// 회의 시작시간와 끝나는 시간 입력받기 
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
			time[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
		}
		
		// 끝나는 시간을 기준으로 정렬하기 위해 compare 재정의
		Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// 종료시간이 같을 경우 시작시간이 빠른순으로 정렬 
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
			
		});
		
		int cnt = 0; // 최대 회의 개수 몇개인지 카운트하기 위해 선언
		int prev_end_time = 0;
		
		for(int i=0; i<n; i++) {
			
			// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
			if(prev_end_time <= time[i][0]) { 
				prev_end_time = time[i][1]; // 직전종료 시간을 종료시간으로 다시 갱신 
				cnt ++; // 회의실 카운트
			}
		}
		System.out.print(cnt);

	}

}
