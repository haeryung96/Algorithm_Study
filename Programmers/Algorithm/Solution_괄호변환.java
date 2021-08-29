import java.util.*;

class Solution_괄호변환 {
    
    // 균형잡힌 문자열 
    public static int balanced_string(String str) {
        int cnt = 0;
        
        for(int i=0; i < str.length(); i++) {
            if(str.charAt(i) == '('){
                cnt++;
            }
            else if(str.charAt(i) == ')') {
                cnt--;
            }
            
            if(cnt == 0) { // 균형잡힌 문자열 
                return i;
            }
        }
        
        return -1; // 균형잡힌 문자열 아님 
    }
    
    // 올바른 괄호 문자열
    public static boolean proper_string(String str){
        int cnt = 0;
        
        for(int i=0; i < str.length(); i++) {
            if(str.charAt(i) == '('){
                cnt++;
            }
            else {
                if (cnt == 0) 
                    return false; // 올바른 문자열 아님 
                cnt--;
            }
        }
        
        return true;
    }
    
    public static String solution(String p) {
        String answer = "";

        // 빈 문자열인 경우 빈문자열 반환
        if(p.isEmpty()) {
            return answer;
        }
        
        int idx = balanced_string(p);
        String u = p.substring(0, idx+1);
        String v = p.substring(idx+1, p.length());
        
        // 3. 문자열 u가 올바른 괄호 문자열이라면
        if(proper_string(u)) {
            answer = u + solution(v); // 3-1
        }
        else { // 문자열 u가 올바른 괄호 문자열이 아니라면
            answer += "("; // 4-1
            answer += solution(v); // 4-2
            answer += ")"; // 4-3
            u = u.substring(1, u.length() - 1); // 4-4
            String a = "";
            for(int i=0; i < u.length(); i++) { // 4-4
                if(u.charAt(i) == '(') {
                    a += ")";
                }
                else {
                    a += "(";
                }
            }
            answer += a;
        }
        
        return answer;
    }
}
