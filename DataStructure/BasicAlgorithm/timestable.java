/** 
 * 위쪽과 왼쪽에 곱하는 수가 있는 곱셈표를 출력하는 프로그램을 작성하라.
 **/

public class timestable {

	public static void main(String[] args) {
		System.out.print("  |");
		
		for(int i=1; i<=9; i++) {
			//System.out.print(" " + i + " ");
			System.out.printf("%3d", i);
		}
		
		System.out.println( '\n' +"--+---------------------------");
		
		for(int i=1; i<=9; i++) {
			//System.out.print(" " + i + "|");
			System.out.printf("%2d |", i);
			for(int j=1; j<=9; j++) {
				//System.out.print(" " + i*j + " ");
				System.out.printf("%3d", i * j);
			}
			System.out.println();
		}

	}

}
