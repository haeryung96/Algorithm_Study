import java.util.*;

public class Solution {
    
    public int solution(int n) {
        int answer = 0;
        String num = String.valueOf(n); // 숫자 n을 문자로 변환
        String[] arr = num.split("");
        
        for(int i = 0; i < arr.length; i++){
            answer += Integer.parseInt(arr[i]);
        }
        
        return answer;
    }
}
