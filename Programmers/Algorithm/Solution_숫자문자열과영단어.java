package Level1;

public class Solution_숫자문자열과영단어 {

	public static void main(String[] args) {
		String s1 = "one4seveneight";
		System.out.println(solution(s1));
		
		String s2 = "23four5six7";
		System.out.println(solution(s2));
		
		String s3 = "2three45sixseven";
		System.out.println(solution(s3));
		
		String s4 = "123";
		System.out.println(solution(s4));

	}

	public static int solution(String s) {
        int answer = 0;
        
        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] eng = {"zero", "one", "two" , "three" , "four" , "five" , "six" , "seven" , "eight" , "nine"};
        
        for(int i=0; i < 10; i++) {
        	s = s.replace(eng[i], num[i]);
        }
        
        return Integer.parseInt(s);
    }
}
