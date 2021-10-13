import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1593 {
	static int tc;
	
	static int calc(int first, int sec) {
		int sum = 0;
		
		if (first == 1) {
			sum += 5000000;
        } else if (2 <= first && first <= 3) {
        	sum += 3000000;
        } else if (4 <= first && first <= 6) {
        	sum += 2000000;
        } else if (7 <= first && first <= 10) {
        	sum += 500000;
        } else if (11 <= first && first <= 15) {
        	sum += 300000;
        } else if (16 <= first && first <= 21) {
        	sum += 100000;
        }
		
		if (sec == 1) {
			sum += 5120000;
        } else if (2 <= sec && sec <= 3) {
        	sum += 2560000;
        } else if (4 <= sec && sec <= 7) {
        	sum += 1280000;
        } else if (8 <= sec && sec <= 15) {
        	sum += 640000;
        } else if (16 <= sec && sec <= 31) {
        	sum += 320000;
        }
		
		return sum;
	}
  
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < tc; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			sb.append(calc(a,b)).append('\n');
		}
		
		System.out.println(sb);
	}

}
