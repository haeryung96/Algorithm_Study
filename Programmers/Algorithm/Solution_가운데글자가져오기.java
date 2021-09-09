class Solution {
    public String solution(String s) { // s.chartAt(s.length / 2)
        String answer = "";
        int odd = s.length() / 2; // 홀수 
        int even = (s.length() /2) -1; // 짝수 
        
        if(s.length() % 2 == 1) { // 홀수라면
            answer += s.charAt(odd);
        }
        else {
            answer += s.charAt(even);
            answer += s.charAt(odd);
        }
        
        return answer;
    }
}
