package Kakao;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * How 구현?
 * 1. 해쉬맵에 아이디랑 이름 넣고
 * 2. 마지막에 배열에 uid를 이름으로 바꿔치기
 * */

public class Solution_오픈채팅방 {

	public static void main(String[] args) {
		String[] record1 = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(solution(record1));
	}

	public static String[] solution(String[] record) {
        ArrayList<String> uidArr = new ArrayList<>(); // uid 님이 들어가고 나가고 
        HashMap<String, String> nickname = new HashMap<>(); // uid와 이름 

        for(int i=0; i < record.length; i++) {
        	String[] str = record[i].split(" ");
        	if(str[0].equals("Enter")) {
        		uidArr.add(str[1] + "님이 들어왔습니다."); // uid1234님이 들어왔습니다. uid4567
        		nickname.put(str[1], str[2]); // uid1234 Muzi uid4567 Prodo
        	}
        	else if(str[0].equals("Leave")) {
        		uidArr.add(str[1] + "님이 나갔습니다."); // uid1234님이 나갔습니다.
        	}
        	else if(str[0].equals("Change")) {
        		nickname.put(str[1], str[2]); // uid1234 Muzi
        	}
        }
        
        String[] answer = new String[uidArr.size()];
        
        int k = 0;
        for(String str : uidArr) {
        	int endIdx = str.indexOf("님"); 
        	String userId = str.substring(0, endIdx); // uid1234님
        	
        	// 후위연산자 처음에는 k=0으로 넣고 나중에 1 2 3 증가 
        	answer[k++] = str.replace(userId, nickname.get(userId)); // uid1234 -> Muzi
        }
        
        return answer;
    }
}
