import java.util.*;
import java.io.*;

/*
 * How 구현?
 * 1. 그리디로 구현
 * 2. 먼저 5로 나누는 것이 봉지의 최솟값을 내는데 유리
 * 3. 5로 나눠지지 않는 경우 3을 빼주면서 3의 배수를 검사
 */

public class ex2839 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0; // 봉지수
		
		while(true) {
			// 5의 배수로 나눠지는 경우 cnt
			if(N >= 0) {
				if(N % 5 == 0) {
					cnt += N/5;
					System.out.println(cnt);
					break;
				}
				else {
					N -= 3; // 3의 배수를 이미 검증해주기 때문에 N % 3 == 0을 검사할 필요가 없음 
					cnt ++;
				}
			}								
			if (N < 0) {
				System.out.println("-1");
				break;
			}
		}
	}
}


// 다이나믹으로 푸는 방법

/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<5) {
            if(n==3) System.out.println(1);
            else System.out.println(-1);
            return;
        }
        int dp[] = new int[n+1];
        Arrays.fill(dp, 9999); // 최솟값을 구하기 위해서는 dp를 9999로 채워야 최소값을 구하는데 편리
        dp[3] = 1;
        dp[5] = 1;
        for(int i=6; i<dp.length; i++) {
            dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
        }
        if(dp[n] > 9999) {
            System.out.println(-1);
        }else {
            System.out.println(dp[n]);
        }
    }
}*/

