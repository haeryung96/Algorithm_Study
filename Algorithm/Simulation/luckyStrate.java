import java.util.*;

public class luckyStrate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		
		int result1 = 0;
		int result2 = 0;
		
		// 왼쪽의 수들의 합 구하기
		for(int i=0; i<n.length()/2; i++) {
			result1 +=n.charAt(i)-'0';
		}
    
		// 오른쪽의 수들의 합 구하기
		for(int i=n.length()/2; i<n.length(); i++) {
			result2 += n.charAt(i)-'0';
		}
		
		if(result1 == result2) System.out.println("LUCKY");
		else System.out.println("READY");
	}

}
