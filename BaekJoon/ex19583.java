import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ex19583 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		String S = input[0]; // 개강총회 시작시간
		int startHour = Integer.parseInt(input[0].substring(0, 2));
		int startMin = Integer.parseInt(input[0].substring(3, 5));
		int start = startHour * 100 + startMin;
				
		String E = input[1]; // 개강총회 끝낸시간
		int endHour = Integer.parseInt(input[1].substring(0, 2));
		int endMin = Integer.parseInt(input[1].substring(3, 5));
		int end = endHour * 100 + endMin;
		
		String Q = input[2]; // 개강총회 스트리밍을 끝낸 시간 
		int QHour = Integer.parseInt(input[2].substring(0, 2));
		int QMin = Integer.parseInt(input[2].substring(3, 5));
		int q = QHour * 100 + QMin;
		
		HashSet<String> h = new HashSet<>();
		int cnt = 0;
		
		String str = "";
		while((str = br.readLine()) != null) {

			String[] s = str.split(" "); 
			String t = s[0];
			String name = s[1];
						
			int tHour = Integer.parseInt(t.substring(0, 2));
			int tMin = Integer.parseInt(t.substring(3, 5));
			int time = tHour * 100 + tMin;
			
			if(time <= start) {
				h.add(name);
			}
			
			if(time >= end && time <= q) {
				if(h.contains(name)) {
					h.remove(name);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
