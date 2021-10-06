import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * Key 는 중복 불가능, Value는 중복가능 
 */

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < tc; i++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hm = new HashMap<>();
			
			for(int j=0; j < N; j++) {
				String[] input = br.readLine().split(" ");
				
				if(hm.containsKey(input[1])) { // 이미 종류를 가지고 있다면 
					hm.put(input[1], hm.get(input[1]) + 1); // 종류의 개수를 계속 추가해주는 형태 
				}
				else { // 처음 들어오는 종류라면
					hm.put(input[1], 1);
				}
			}
			
			int res = 1;
			
			for(Integer k : hm.values()) {
				res *= (k+1);
			}
			
			sb.append(res - 1).append('\n');
		}
		
		System.out.println(sb);
	}

}
