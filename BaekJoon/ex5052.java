import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ex5052 {
	static int tc;
	static int n;
	static HashSet<String> hs = new HashSet<>();
	static boolean flag;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < tc; i++) {
			n = Integer.parseInt(br.readLine());
			String phoneNum = "";
			flag = true;
			
			for(int j=0; j < n; j++) {
				phoneNum = br.readLine();
				hs.add(phoneNum);
			}
			
			Iterator<String> iter = hs.iterator();
			while(iter.hasNext()) {
				String s = iter.next();
				for(int k=0; k < s.length(); k++) {
					if(hs.contains(s.substring(0, k))) {
						flag = false;
						break;
					}
				}
			}
			
			hs = new HashSet<>();
			
			if(!flag) sb.append("NO").append('\n');
			else sb.append("YES").append('\n');
		}
		
		System.out.println(sb);
	}

}
