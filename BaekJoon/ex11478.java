import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
 * HashSet 중복된 객체를 허용하지 안함
 */
public class ex11478 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		HashSet<String> hs = new HashSet<>();
		
		String s;
		for(int i=0; i < str.length(); i++) {
			s = "";
			
			for(int j=i; j < str.length(); j++) {
				s += str.substring(j, j+1);
				hs.add(s);
			}
		}
		
		System.out.println(hs.size());
	}

}
