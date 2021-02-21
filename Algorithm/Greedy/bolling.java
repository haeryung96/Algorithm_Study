import java.util.*;

public class bolling {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 공의 개수
		int m = sc.nextInt(); // 공의 최대 무게
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			list.add(sc.nextInt()); // 공의 무게 넣기
		}
		
		// 오름차순으로 정렬 
		Collections.sort(list);
		
		int cnt = 0;
		
		for(int i=0; i<=n-1; i++) { // 조합읍 구하려면 입력이 5라면 4만큼 돌리기
			for(int j=i+1; j<n; j++) {
				if(list.get(i)!=list.get(j)) { // 두개의 값이 같지 않다면 다른것이기 때문에 카운트해주기
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

}
