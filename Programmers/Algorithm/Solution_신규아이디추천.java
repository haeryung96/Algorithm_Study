package Kakao;

/*
 * How 구현?
 * 1. 문자열
 * 2. 5단계에서 미친듯이 헤맴
 * 3. 주의 ** 
 * 4. 처음에는 equals 대신 == 시용
 * 5. 문제점 : equals는 값 자체를 비교하지만 ==은 주소값을 비교해서 같은 문자열이여도 주소값이 다름 유의하자 !!!!!
 * 6. 값을 비교할때는 무조건 equals !!
 * */

public class Solution_신규아이디추천 {

	public static void main(String[] args) {
		String new_id1 = "...!@BaT#*..y.abcdefghijklm";
		String ans = solution(new_id1);
		System.out.println(ans);
		
		String new_id2 = "z-+.^.";
		String ans2 = solution(new_id2);
		System.out.println(ans2);
		
		String new_id3 = "=.=";
		String ans3 = solution(new_id3);
		System.out.println(ans3);
		
		String new_id4 = "123_.def";
		String ans4 = solution(new_id4);
		System.out.println(ans4);
		
		String new_id5 = "abcdefghijklmn.p";
		String ans5 = solution(new_id5);
		System.out.println(ans5);
		
		String new_id6 = "b......@";
		String ans6 = solution(new_id6);
		System.out.println(ans6);
	}

	
	 public static String solution(String new_id) {	 
		  String answer;
		  
		  new_id = new_id.toLowerCase(); // 1단계 : 모든 대문자를 대응되는 소문자로 치환
 		  //System.out.println(new_id + " 1");

	      StringBuilder sb = new StringBuilder();
	      for(int i=0; i < new_id.length(); i++) { // 2단계 : 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
	    	 char c = new_id.charAt(i);
	    	 if((c >= 'a' && c <='z') || (c >= '0' && c <= '9') || (c == '-' || c == '_' || c == '.')) {
	    		 sb.append(c);
	    	 }
	      }
	      
 		  //System.out.println(sb + " 2");

	      new_id = sb.toString(); // 아이디 다시 갱신 
	      
	      // 3단계 : 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
	      while(new_id.contains("..")) {
	    	  new_id = new_id.replace("..", ".");
	      }
	      
	      char[] arrChar = new_id.toCharArray();
	      StringBuilder sb2 = new StringBuilder();
	      for(int i=0; i < arrChar.length; i++) {
			    sb2.append(arrChar[i]);
	      }
	      
  		  //System.out.println(sb2 + " 3");

	      new_id = sb2.toString();
	      
	      // 4단계 : 마침표(.)가 처음이나 끝에 위치한다면 제거
	      if(new_id.length()> 0 &&  new_id.startsWith(".")) {
	    	  new_id = new_id.substring(1, new_id.length());
	    	  //System.out.println(new_id + " 4");
	      }
	      if(new_id.length()> 0 && new_id.endsWith(".")) {
	    	  new_id = new_id.substring(0, new_id.length()-1);
	    	  //System.out.println(new_id + " 4");
	      }
	      
	      // 5단계 : new_id가 빈 문자열이라면, new_id에 "a"를 대입
	      if(new_id.equals("")) {
	    	  new_id = "a";
	      }
	      
	      //System.out.println(new_id + " 5");
	      
	      // 6단계 : new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
	      // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
	      if(new_id.length() >= 16) {
	    	  new_id = new_id.substring(0, 15);
	    	  //System.out.println(new_id + " 6");

	    	  if(new_id.endsWith(".")) {
	    		  new_id = new_id.substring(0, new_id.length()-1);
		    	  //System.out.println(new_id+ " 6");

	    	  }
	      }
	      
	      // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙임
	      if(new_id.length() <= 2) {
	    	  while(new_id.length() < 3) {
	    		  new_id += new_id.charAt(new_id.length()-1);
	    	  }
	      }
	      
	      //System.out.println(new_id + " 7");

	      return new_id;
	 }
	
}
