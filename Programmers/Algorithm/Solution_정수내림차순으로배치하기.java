import java.util.*;

class Solution {
    public static long solution(long n) {
        String answer = "";
        String num = String.valueOf(n);
        
        char[] arr = num.toCharArray();
        Arrays.sort(arr);
        
        for(int i = arr.length - 1; i >= 0; i--) {
        	answer += arr[i];
        }
        
        long ans = Long.parseLong(answer);
        
        return ans;
    }
}
