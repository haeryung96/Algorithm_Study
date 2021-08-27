import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex15922 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		for(int i=1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			// 만약 좌표가 겹친다면
			if(Math.max(y1, x2) == y1) {
				y1 = Math.max(y1, y2);
			}
			else { // 안겹친다면 
				ans += Math.abs(y1 - x1);
				x1 = x2;
				y1 = y2;
			}
		}
		
		ans += Math.abs(y1 - x1);
		System.out.println(ans);
	}

}
