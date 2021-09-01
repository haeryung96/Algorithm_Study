package baekjoon;
import java.io.*;
import java.util.*;

public class ex2161 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i <= N; i++) {
			q.add(i);
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		while(true) {
			if(q.size() == 1) {
				break;
			}
			
			int p = q.poll(); // 1
			arr.add(p);
			
			q.offer(q.poll());
			
		}
		
		for(int i=0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		
		System.out.println(q.element());
	}

}
