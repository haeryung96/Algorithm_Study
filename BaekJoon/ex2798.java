import java.io.*;
import java.util.*;

/*
 * How 구현?
 * 1. 모든 경우 탐색 -> 브루트포스
 * 2. 조합을 사용해서 카드를 뽑고 최대합을 게속 갱신
 * 3. 최종적으로 남은 합을 출력 
 * */

public class ex2798 {
	
	// 탐색
	static int search(int[] num, int n, int m) {
		int res = 0;
		
		// 3개를 고르기 때문에 첫번째 카드는 n-2까지만 순회
		for(int i=0; i<n-2; i++) {
			
			// 첫번째 카드가 m보다 크다면 skip 더해줄 필요가 없기 때문에 
			if(num[i] > m) continue;
			
			// 두번째 카드는 첫번째 카드 다음부터 n-1까지만 순회
			for(int j=i+1; j<n-1; j++) {
				
				// 첫번째 두번째 카드의 합이 m보다 크면 skip
				if(num[i]+num[j] > m) continue;
				
				// 세번쨰 카드는 두번쨰 카드 다음부터 n까지 순회
				for(int k=j+1; k<n; k++) {
					
					// 3개의 값의 합
					int temp = num[i] + num[j] + num[k];
					
					// M과 세 카드의 합이 같다면 세 수의 합을 return하고 출력
					if(m == temp) return temp;
					
					// 세 카드의 합이 이전 합보다 크면서 M보다 작을 경우 res값 갱신 
					if(res < temp && temp < m) 
						res = temp;
				}
			}
		}
		return res;
	}
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken()); // 카드의 개수
		int m = Integer.parseInt(st.nextToken()); // 최대 합
		
		int[] num = new int[n]; // 카드에 쓰여 있는 수 
		
		st = new StringTokenizer(br.readLine(), " "); // 왜 한번 더 해줘야 하는지 모르겠음
		
		// 배열에 입력된 숫자 넣기 
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(search(num,n,m));

	}

}
