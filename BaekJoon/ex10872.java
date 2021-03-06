import java.util.*;
import java.io.*;

/*
How 구현?
1. 팩토리얼-> 재귀함수로 구현
*/

public class ex10872 {
	static int factorial(int x) {
		if(x>0) {
			return x*factorial(x-1);
		}
		else
			return 1;
		}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		System.out.println(factorial(n));
	}
}
