import java.util.*;

class Solution {
    public static int min = Integer.MAX_VALUE;
    public int[] solution(int[] arr) {
        
        for(int i=0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i < arr.length; i++){
            if(arr[i] != min){
                list.add(arr[i]);
            }
        }
        
        int[] answer = new int[list.size()];
        int[] ans = new int[1];
        
        if(list.size() == 0){
            ans[0] = -1;
            return ans;
        }
        else {
            for(int i=0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
        }
        
        return answer;
    }
}
