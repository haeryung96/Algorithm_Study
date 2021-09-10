class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String num = String.valueOf(x);
        String[] list = num.split("");

        int sum = 0;
        for(int i=0; i < list.length; i++){
            sum += Integer.parseInt(list[i]);
        }

        if(x % sum == 0){
            answer = true;
        }
        else {
            answer = false;
        }

        return answer;
    }
}
