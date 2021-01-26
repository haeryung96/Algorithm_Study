import java.util.*;

public class returnLength {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n ;
		
		do {
			n = sc.nextInt();
		}while(n<=0);
		
		int l = 0;
		
		while(n>0) {
			n/=10;
			l++;
		}
		
		System.out.println(l);
	}

}
