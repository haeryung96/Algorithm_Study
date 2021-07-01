package Kakao;

public class Solution_다트게임 {

	public static void main(String[] args) {
		String dartResult1 = "1S2D*3T";
		System.out.println(solution(dartResult1));
		
		String dartResult2 = "1D2S#10S";
		System.out.println(solution(dartResult2));
		
		String dartResult3 = "1D2S0T";
		System.out.println(solution(dartResult3));
		
		String dartResult4 = "1S*2T*3S";
		System.out.println(solution(dartResult4));
		
		String dartResult5 = "1D#2S*3S";
		System.out.println(solution(dartResult5));
		
		String dartResult6 = "1T2D3D#";
		System.out.println(solution(dartResult6));
		
		String dartResult7 = "1D2S3T*";
		System.out.println(solution(dartResult7));
	}

	public static int solution(String dartResult) {
        int answer = 0;
        
        int[] pointArr = new int[3]; // 점수배열 
        int tmp = 0;
        String str = "";
        
        for(int i=0; i < dartResult.length(); i++) {
        	char idx = dartResult.charAt(i);
        	
        	if(idx >= '0' && idx <= '9') {
        		str += idx;
//        		System.out.println(str);
        	}
        	else if (idx == 'S' || idx == 'D' || idx == 'T') {
        		int bonus = Integer.parseInt(str);
        		
        		if(idx == 'S') bonus = (int) Math.pow(bonus, 1);
        		else if(idx == 'D') bonus = (int) Math.pow(bonus, 2);
        		else if(idx == 'T') bonus = (int) Math.pow(bonus, 3);
        		
        		str = ""; // 문자열 다시 초기화 
        		pointArr[tmp++] = bonus; 
//        		System.out.print(tmp);
        	}
        	else {
        		if(idx == '#') { // 아차상
        			pointArr[tmp-1] *= -1;
        		}
        		else {
        			pointArr[tmp-1] *= 2;
        			if(tmp-2 >=0) pointArr[tmp-2] *= 2;
        		}
        	}
        }
        
        for(int num : pointArr) {
        	answer += num;
        }
        return answer;
    }
}
