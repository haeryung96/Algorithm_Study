import java.io.*;

/*
 * How 구현?
 * 1. 짝수와 홀수인 경우 규칙이 생김
 * 2. 규칙 : N = N/2 + N%2
 * 3. 예를 들어서 입력 16 8 9라고 하면
 * 4. 4 = 8/2 + 8%2  5 = 9/2 + 9%2
 */

public class ex1057 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int kim = Integer.parseInt(input[1]);
		int lim = Integer.parseInt(input[2]);
		
		int round = 0; // 라운드 수 
		
		while(kim != lim) {
			kim = kim/2 + kim%2;
			lim = lim/2 + lim%2;
			round++;
		}
		System.out.println(round);
	}

}
