import java.io.*;
import java.util.*;

/*
 * How 구현?
 * 1. 클래스를 만들고 Comparable 인터페이스 사용해서 값을 비교
 * 2. Collections.sort 를 사용하여 정렬한 뒤에 출력 
 */

public class ex11650 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Location> loc = new ArrayList<Location>();
		
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			loc.add(new Location(Integer.parseInt(input[0]),Integer.parseInt(input[1]))); //데이터 집어넣기
		}
		
		Collections.sort(loc);
		
		for(int i=0; i<loc.size(); i++) {
			System.out.println(loc.get(i).x + " " + loc.get(i).y);
		}
	}
}

class Location implements Comparable<Location>  {
	int x; int y;
	
	Location(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	@Override
	public int compareTo(Location o) {
		if(this.x > o.x ) { // 내가 가지고 있는 x보다 들어온 x의 값이 작다면 
			return 1;
		}
		else if (this.x == o.x) {
			if (this.y > o.y) { // 내가 가지고 있는 y가 들어온 y의 값이 크다면 
				return 1;
			} else if (this.y < o.y) return -1; // 내가 가지고 있는 y보다 들어온 y가 크면 
		}
		return -1;
	}
}
