class Solution_내적 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int sum;
        
        for(int i=0; i < a.length; i++) {
            sum = a[i] * b[i];
            answer += sum;
        }
        
        return answer;
    }
}
