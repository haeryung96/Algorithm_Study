import java.util.*;

/*
 * 알파벳 따로 숫자 따로 배열을 만들어서 저장
 * 숫자는 해당 인덱스에서 가지고 와서 더하기
 * 나머지를 출력하기
 * */

public class textResort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine(); // 문자열 입력
		
		ArrayList<Character> alpha = new ArrayList<>(); //String을 안쓰는 이유는 isLetter을 쓸 수 없기 떄문
		int sum = 0;
		
		// 숫자인지 알파벳인지 확인하기
		for(int i=0; i<text.length(); i++) {
			// 알파벳인 경우 따로 정렬해주기 위해서 다른 배열에 저장
			if(Character.isLetter(text.charAt(i))) { // 알파벳인경우
				alpha.add(text.charAt(i));
			}
			else { // 숫자인 경우
				sum+= text.charAt(i) -'0';
			} 
		}
		
		//알파벳 오름차순으로 정렬하기
		Collections.sort(alpha);
		StringBuilder sb = new StringBuilder();
		
		//정렬한 알파벳 출력하기
		for(int i=0; i<alpha.size(); i++) {
			sb.append(alpha.get(i));
		}
		
		sb.append(sum);
		System.out.println(sb);

	}

}
