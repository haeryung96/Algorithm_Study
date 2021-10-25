import java.io.*;

// 피보나치 수 -> 피사노 주기를 가짐 
// 피보나치 수를 나눈 나머지들은 반드시 주기를 가지며 이걸 피사노 주기라고 함 
// 피보나치 수를 나눌 수를 K라고 할 떄, k = 10^n이면, 피사노 주기는 15 * 10^n-1
// 문제에서 10^6으로 나눈 나머지를 구하라고 했으므로 주기는 1,500,000임 
// 최대 1,500,000번쨰 까지만 10^6로 나눈 나머지 값들을 알면 그 이후의 위치는 따로 계산할 필요 없음 

public class ex2749 {
	static int pisano = 1500000;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		long[] fibo = new long[pisano + 1];
		fibo[0] = 0;
		fibo[1] = 1;
		
		N %= pisano;
		
		for(int i=2; i < pisano + 1; i++) {
			fibo[i] = ( fibo[i-1] + fibo[i-2] ) % 1000000;
		}
		
		System.out.println(fibo[(int)N]);
		
	}

}
