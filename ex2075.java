import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ex2075 {
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				pq.add(num);
			}
		}
		
		int ans = 0;
		for(int i=0; i < N; i++) {
			ans = pq.peek();
			pq.remove(pq.peek());
		}
		
		System.out.println(ans);
	}

}
