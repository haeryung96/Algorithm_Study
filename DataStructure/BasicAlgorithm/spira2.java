import java.util.*;

public class spira2 {
	static void npira(int n) {
		for (int i = 1; i <= n; i++) { 					// i행 (i = 1, 2, … ,n)
			for (int j = 1; j <= n - i + 1; j++) 		// n-i+1개의 ' '를 나타냄
				System.out.print(' ');
			for (int j = 1; j <= (i - 1) * 2 + 1; j++) 	// (i-1)*2+1개의 '*'를 나타냄
				System.out.print(i);
			System.out.println(); 						// 개행(줄변환)
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		npira(n);

	}

}
