import java.io.*;

/*
 * How 구현? 
 * 1. Math 수학적 접근
 * 2. (V/P) * L + (V%P)  
 * 3. -> 위의 식 적용하면 틀림 
 * 4. 반례 2 8 20 -> 답 : 6 틀린답 : 8
 * 5. 왜? 나머지 (V%P) = 4 가 나와서 연속 2일 사용가능하지만 4일 사용하는 것으로 잘못 계산됨 
 * 6. Math.min((V%P), L)) 연속 사용할 수 있는 수와 (V%P)의 최솟값을 사용하는 것이 정답임 
 */

public class ex4796 {
	public static int L, P, V;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int index = 1;
		
		while(true) {
			String[] input = br.readLine().split(" ");
			
			L = Integer.parseInt(input[0]);
			P = Integer.parseInt(input[1]);
			V = Integer.parseInt(input[2]);

			if(L==0 && P==0 && V==0) {
				break;
			}
			
			System.out.println("Case " + index + ": " + ((V/P) * L + Math.min((V%P), L)));
			index++;
		}
	}

}
