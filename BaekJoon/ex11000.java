import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ex11000 {
	static int tc;
	static PriorityQueue<Integer> pq;
	static ArrayList<Lecture> list ;
	
	// 강의 클래스 만들기 
	static class Lecture{
		int start; 
		int end;
		
		Lecture(int start, int end){
			this.start = start;
			this.end = end;
		}
	}

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		pq = new PriorityQueue<>();
		
		// 입력 받기 
		for(int i = 0; i < tc; i++) {
			String[] input = br.readLine().split(" ");
			list.add(new Lecture(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}
		
		// 시작 시간으로 정렬 
		Collections.sort(list, new Comparator<Lecture>() {

			@Override
			public int compare(Lecture o1, Lecture o2) {
				// 시작 시간이 같다면 빨리 끝나는 순으로 정렬
				if(o1.start == o2.start) {
					return o1.end - o2.end;
				}
				
				// 시작 시간으로 정렬 
				return o1.start - o2.start;
			}
		});
		
		int endTime = list.get(0).end;
		pq.add(endTime);
		
		for(int i = 1; i < tc; i++) {
			int st = list.get(i).start; // 시작시간
			int et = list.get(i).end; // 끝나는 시간 
			
			// 이전에 끝나는 시간이랑 현재 들어온 현재 시간을 비교해서 시작 시간이 같거나 크면 기존 강의실 이용 
			if(!pq.isEmpty() && pq.peek() <= st) { 
				pq.poll();
			}
			
			pq.add(et);
		}
		
		System.out.println(pq.size());
	}

}
