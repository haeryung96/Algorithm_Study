import java.io.*;

/*
How 구현?
1. 그리디로 가장 큰 거스름돈으로 나누며 값을 갱신
*/

public class ex5585 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int num = 1000 - N;
		int cnt = 0;
		
		while(num!=0) {
			if(num >= 500) {
				cnt = cnt + (num / 500);
				num = num % 500;
			}
			else if(num >= 100) {
				cnt = cnt + (num / 100);
				num = num % 100;
			}
			else if(num >= 50) {
				cnt = cnt + (num / 50);
				num = num % 50;
			}
			else if(num >= 10) {
				cnt = cnt + (num / 10);
				num = num % 10;
			}
			else if(num >= 5) {
				cnt = cnt + (num / 5);
				num = num % 5;
			}
			else if(num >= 1) {
				cnt = cnt + (num / 1);
				num = num % 1;
			}
		}
		
		System.out.print(cnt);
	}

}
