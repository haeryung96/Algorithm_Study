package baekjoon;
import java.io.*;
import java.util.*;

public class ex3009 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			String[] input = br.readLine().split(" ");
			int xx = Integer.parseInt(input[0]);
			int yy = Integer.parseInt(input[1]);
				
			x.add(xx);
			y.add(yy);
		}
		
		Collections.sort(x);
		Collections.sort(y);
		
		for(int i=1; i < 3; i++) {
			if(x.get(i).equals(x.get(i-1))) {
				x.remove(i);
				x.remove(i-1);
			}
			
			if(x.size() == 1) {
				break;
			}
		}
		
		for(int i=1; i < 3; i++) {
			if(y.get(i).equals(y.get(i-1))) {
				y.remove(i);
				y.remove(i-1);
			}
			
			if(y.size() == 1) {
				break;
			}
		}
		
		System.out.print(x.get(0) + " ");
		System.out.print(y.get(0));
	}

}
