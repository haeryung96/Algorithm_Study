import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

// 입력이 데드라인과 컵라면의 수가 주어짐 
// 데드라인이 작은 문제들부터 푸는 것이 좋고 
// 데드라인이 길더라도 컵라면의 개수가 많으면 좋음 

public class ex1781 {
	static int tc; // 숙제의 개수 
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static ArrayList<Ramen> list = new ArrayList<>();
	
	static class Ramen implements Comparable<Ramen>{
		int deadLine = 0;
		int count = 0;
		
		Ramen(int deadLine, int count){
			this.deadLine = deadLine;
			this.count = count;
		}
		
		@Override
		public int compareTo(Ramen r) {
			if(this.deadLine == r.deadLine) { // 만약 데드라인이 같다면 라면의 개수가 큰 순으로 
				return r.count - this.count;
			}
			return this.deadLine - r.deadLine; // 데드라인 순으로 정렬 
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < tc; i++) {
			String[] input = br.readLine().split(" ");
			int deadLine = Integer.parseInt(input[0]);
			int ramen = Integer.parseInt(input[1]);
			
			list.add(new Ramen(deadLine, ramen));
		}
		
		Collections.sort(list);
				
		for(int i = 0; i < tc; i++) {
			int day = list.get(i).deadLine; // 기한
			int cnt = list.get(i).count; // 라면의 개수 
			
			pq.add(cnt); // 라면의 개수를 넣음 
			
			// pq.size = 전체 푼 문제의 개수 
			if(day < pq.size()) { // 전체 푼 문제의 개수보다 day가 작으면 
				pq.poll();
			}
		}
		
		int sum = 0;

		for(int num : pq) {
			sum += num;
		}
		
		System.out.println(sum);
	}

}
