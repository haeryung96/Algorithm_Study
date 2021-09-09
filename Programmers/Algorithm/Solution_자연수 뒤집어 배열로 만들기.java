import java.util.*;

class Solution {
    public int[] solution(long n) {
        String num = String.valueOf(n); // 문자열로 바꾼다음 
        String[] list = num.split("");
        
        int[] answer = new int[num.length()];
        int idx = 0;
        
        for(int i = answer.length - 1; i >= 0; i--){
            answer[i] = Integer.parseInt(list[idx]);
            idx++;
        }        
        
        return answer;
    }
}
