package baekjoon;
import java.io.*;
import java.util.*;

public class ex2170 {
	public static class Line{
		long x;
		long y;
		
		Line(long x, long y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Line> arr = new ArrayList<>();
		for(int i=0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			long x = Integer.parseInt(input[0]);
			long y = Integer.parseInt(input[1]);
			
			arr.add(new Line(x,y));
		}
		
		Collections.sort(arr, new Comparator<Line>() {

			@Override
			public int compare(Line o1, Line o2) {
				if(o1.x > o2.x) {
					return 1;
				}
				else if(o1.x == o2.x) {
					if(o1.y > o2.y) {
						return 1;
					}
				}
				return -1;
			}
			
		});
		
		long xx = arr.get(0).x; 
		long yy = arr.get(0).y; 
		long sum = yy - xx;
		
		for(int i=1; i < arr.size(); i++) {
			long nx = arr.get(i).x; 
			long ny = arr.get(i).y; 
			
			if((xx <= nx) && (ny <= yy)) { // 선분이 포함된다면 
				continue;
			}
			else if(nx < yy){ // 선분이 겹친다면 
				sum += (ny - yy);
			}
			else { // 겹치지 않는 경우 
				sum += ny - nx;
			}
			
			xx = nx;
			yy = ny;
		}
		
		System.out.println(sum);
	}

}
