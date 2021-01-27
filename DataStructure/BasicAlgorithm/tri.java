import java.util.*;

/**
 * 직각 이등변 삼각형을 출력하라.
 * **/

public class tri {
	
	//왼쪽 아래가 직각인 이등변 삼각형
	static void triangleLB(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	//왼쪽 위가 직각인 이등변 삼각형
	static void triangleLU(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n-i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	//오른쪽 위가 직각인 이등변 삼각형
	static void triangleRU(int n) {
		for (int i = 1; i <= n; i++) { 				// i행 (i = 1, 2, … ,n)
			for (int j = 1; j <= i - 1; j++) 		// i-1개의 ' '를 나타냄
				System.out.print(' ');
			for (int j = 1; j <= n - i + 1; j++) 	// n-i+1개의 '*'를 나타냄
				System.out.print('*');
			System.out.println();					// 개행(줄변환)
		}
	}
	
	//오른쪽 아래가 직각인 이등변 삼각형
	static void triangleRB(int n) {
		for (int i = 1; i <= n; i++) { 				// i행 (i = 1, 2, … ,n)
			for (int j = 1; j <= n - i; j++) 		// n-i개의 ' '를 나타냄
				System.out.print(' ');
			for (int j = 1; j <= i; j++) 			// i개의 '*'를 나타냄
				System.out.print('*');
			System.out.println(); 					// 개행(줄변환)
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("단 입력 : ");
		int n = sc.nextInt();
		
		triangleLB(n);
		System.out.println("");
		triangleLU(n);
		System.out.println("");
		triangleRU(n);
		System.out.println("");
		triangleRB(n);


	}

}

/** // 오른쪽 위가 직각인 이등변삼각형 출력
 * for (int i = n; i > 0; i--) { //예를들어 인풋이 5라면 i도 5,
			for (int j = i; j > 0; j--) { //j도 5
				System.out.print("*");//별 5번 찍기 
			}
			System.out.println();// 다 찍고나면 개행해주기 
			int cnt = 0;
			while (cnt <= n - i) { // 0 <= 5-5
				System.out.print(" ");
				cnt++; //1되는 순간 while문 나가야함 
			}
		}
 * **/

/** 
 * //오른쪽 아래가 직각인 이등변삼각형 출력
 * for (int i = n; i > 0; i--) { //예를들어 인풋이 5라면 i도 5,
			for (int j = i-1; j > 0; j--) { //j는 4 
				System.out.print(" ");//공백 4번 찍기  
			}
			int cnt = 0; //다 찍고나면 별 찍기 
			while (cnt <= n - i) { // 0 <= 5-5
				System.out.print("*");
				cnt++; //1되는 순간 while문 나가야함 
			}
			System.out.println();//별 다 찍었으니 개행 
		}
 * **/
