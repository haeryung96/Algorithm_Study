import java.util.HashMap;

public class Solution_전화번호목록 {

	public static void main(String[] args) {
		String[] str1 = {"119", "97674223", "1195524421"};
		System.out.println(solution(str1));
		
		String[]str2 = {"123","456","789"};
		System.out.println(solution(str2));
		
		String[] str3 = {"12","123","1235","567","88"};
		System.out.println(str3);

	}
	
	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		HashMap<String, String> hm = new HashMap<String, String>();
		
		// 해시맵에 접두사 넣기 
		for(int i=0; i < phone_book.length; i++) {
			hm.put(phone_book[i], "prefix");
		}
		
		for(String str : phone_book) {
			for(int i=0; i < str.length(); i++) {
				if(hm.containsKey(str.substring(0, i))){
					answer = false;
				}
			}
		}
		return answer;
	}

}
