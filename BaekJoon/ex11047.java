import java.util.*;

/*
 * How 구현?
 * 1. 동전의 가치 배열을 만들기
 * 2. 가장 큰 값부터 제외하기 위해서 for문을 마지막 인덱스부터 돌리기
 * 3. 입력된 동전의 합보다 배열에 있는 값이 작으면 나눌 수 있다는 의미이므로
 * 4. 나눈 다음에, 나눈 몫과 나머지를 가지고 다시 for문 돌리기
 * */

public class ex11047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 동전의 종류 
		int k = sc.nextInt(); // 동전의 각각의 합 
		ArrayList<Integer> list = new ArrayList<>(); // 동전의 가치 
		
		for(int i=0; i<n; i++) {
			list.add(sc.nextInt()); // 입력된 값을 list에 넣기
		}
		
		// 이미 값이 오름차순으로 주어짐 - 정렬할 필요 없어 !!
		
		int cnt = 0; // 몇번 교체했는지 카운트 하기 위해서 사용 
		
		// 맨 마지막 값부터 검사하면서 반복문 돌리기 위해서 i를 n-1로 시작
		for(int i=n-1; i>=0; i--) {
			if(list.get(i) <= k) {
				cnt += (k/list.get(i)); // 4200/1000 = 4 를 cnt에 넣기
				k = (k%list.get(i)); // k의 값을 다시 나머지 값으로 갱신
			}
		}
		System.out.println(cnt);
	}
}
