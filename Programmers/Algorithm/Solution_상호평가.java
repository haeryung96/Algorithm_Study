import java.util.*;

class Solution {
    
    public static String getScore(int sc){
        String score = "";
        
        if(sc >= 90){
            score = "A";
        }
        else if(80 <= sc && sc < 90){
            score = "B";
        }
        else if(70 <= sc && sc < 80){
            score = "C";
        }
        else if(50 <= sc && sc < 70){
            score = "D";
        }
        else{
            score = "F";
        }
        
        return score;
        
    }
    public String solution(int[][] scores) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i < scores.length; i++){
            int MAX = Integer.MIN_VALUE;
            int MIN = Integer.MAX_VALUE;
            int selfScore = scores[i][i];
            boolean isUnique = true;
            int sum = 0;
            int size = scores.length;
            
            for(int j=0; j < scores[i].length; j++){
                
                // 열을 기준으로 계산 
                MAX = Math.max(MAX, scores[j][i]); // 100 100 100 100 100
                MIN = Math.min(MIN, scores[j][i]); // 100 50  47 61 24
                
                if(i != j && selfScore == scores[j][i]){ // 유일한 점수가 아니라면 
                    isUnique = false;
                }
                
                sum += scores[j][i]; // 100 150 197 258 282
             }
            
             if(MAX == selfScore && isUnique){ // 값이 하나이면서 max이면
                size--;
                sum -= selfScore;
             }
            
             else if(MIN == selfScore && isUnique){
                size--;
                sum -= selfScore; 
             }
            
             answer = getScore(sum / size);
             sb.append(answer);
        }
        
        return sb.toString();
    }
}
