import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/*
 * How 구현?
 * 1. ArrayList 쓰면 시간초과 뜸
 * 2. HashSet 사용 -> 데이터 넣고 리스트, 이터레이터 사용해서 정렬하고 값 출력
 */

public class ex7785 {
	public static HashSet<String> map = new HashSet<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			String name = input[0];
			String log = input[1];
			
			if(log.equals("enter")) {
				map.add(name);
			}
			
			else if(log.equals("leave")) {
				map.remove(name);
			}
		}
		
		List<String> list = new ArrayList<>();
		Iterator<String> it = map.iterator();
		
		while(it.hasNext()) {
			list.add(it.next());
		}
		
		Collections.sort(list, Collections.reverseOrder());
		
		for(int i=0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
