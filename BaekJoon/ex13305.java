import java.io.*;
import java.util.*;

/*
 * How 구현?
 * 1. 최소 비용은 리터당 가격이 가장 낮은 곳에서 기름을 최대한 많이 넣어야 함
 * 2. 도시의 리터당 가격만 놓고 비교하기
 * 3. 현재 도시의 가격이 다음 도시의 가격보다 크면 다음 도시의 가격으로 가격을 갱신
 * 4. 현재 도시의 가격이 다음 도시의 가격보다 작다면 현재 도시의 가격을 계속 사용 
 */

public class ex13305 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine()); // 도시의 개수
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long[] road = new long[(int) (N-1)]; // 도로의 개수 
		for(int i=0; i < N-1; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		long[] price = new long[(int) N]; // 1리터당 가격
		for(int i=0; i < N; i++) {
			price[i] = Long.parseLong(st.nextToken());
		}
		
		long cost = price[0] * road[0]; // 처음 시작 도시에서는 무조건 기름을 넣어야하기 떄문에 이미 주유했다고 가정 
		int nowCity = 0; // 현재도시
		int nextCity = nowCity + 1; // 다음 도시

		while(nextCity < N - 1) { 
			if(price[nowCity] < price[nextCity]) { // 현재 도시의 가격이 다음 도시의 가격보다 작다면
				cost += price[nowCity] * road[nextCity]; // 현재 도시의 가격 * 다음 도시의 거리
			}
			else if (price[nowCity] >= price[nextCity]) { // 현재 도시의 가격이 다음 도시의 가격보다 크거나 같다면 
				cost += price[nextCity] * road[nextCity]; // 다음 도시의 가격 * 다음 도시의 거리
				nowCity = nextCity; // 도시의 번호를 갱신했으므로 현재 도시를 다음 도시로 다시 갱신
			}
			
			nextCity++;
		}
		
		System.out.println(cost);
	}

}
