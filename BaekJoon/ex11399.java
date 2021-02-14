import java.util.*;

/*
 * How 구현?
 * 1. 시간에 대한 arrayList를 선언
 * 2. 가장 짧은 시간으로 하기 위해서는 시간에 대해서 오름차순으로 정렬한 뒤,
 * 3. 계속 값을 누적해서 더하기
 * */

public class ex11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 사람의 수
		ArrayList<Integer> p = new ArrayList<>(); // 돈을 인출하는데 걸리는 시간
//		int[] p = new int[n];
		
		for(int i=0; i<n; i++) {
//			p[i] = sc.nextInt();
			p.add(sc.nextInt()); // 시간 입력
		}
		
		p.sort(null); // 오름차순으로 정렬 
//		System.out.println(p.toString());
		
		int result = 0;
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			result+=p.get(i); // 결과에 배열의 i의 값을 누적으로 더하기
			sum+=result; // 결과를 다시 합에 더하기 
		}
		System.out.println(sum);

	}

}
