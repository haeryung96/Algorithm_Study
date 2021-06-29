package Kakao;

import java.util.Arrays;

/*
 * How 구현?
 * 1. 형변환때문에 시간 오래 잡아먹었다... Character.toString() 사용
 * 2. 나머지는 문제대로 구현하면 됨
 * */

public class Solution_비밀지도 {

	public static void main(String[] args) {
		int n1 = 5;
		int[] arr11 = {9, 20, 28, 18, 11};
		int[] arr21 = {30, 1, 21, 17, 28};
		System.out.println(Arrays.toString(solution(n1, arr11, arr21)));

	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String answer = "";
        
        String map1[][] = new String[n][n]; // 첫번째 지도
        String map2[][] = new String[n][n]; // 두번쨰 지도 
        String ansMap[] = new String[n]; // 정답 지도
        
        for(int i=0; i < n; i++) {
            // 첫번째 맵에 해당되는 수 이진수로 변환
            String tmp1 = Integer.toBinaryString(arr1[i]); // 1001
            tmp1 = String.format("%"+n+"s", tmp1); // 01001
            
            char[] tmpTochar1 = tmp1.toCharArray();
            
            for(int j=0; j < n; j++) {
                map1[i][j] = Character.toString(tmpTochar1[j]);
            }
        }
        
        for(int i=0; i < n; i++) {
            // 두번째 맵에 해당되는 수 이진수로 변환
            String tmp2 = Integer.toBinaryString(arr2[i]); // 1001
            tmp2 = String.format("%"+n+"s", tmp2); // 01001
            
            char[] tmpTochar2 = tmp2.toCharArray();
            
            for(int j=0; j < n; j++) {
                map2[i][j] = Character.toString(tmpTochar2[j]);
            }
        }
        
        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                //1번째 맵의 경우 
                if(map1[i][j].equals("1")) {
                    map1[i][j] = "#";
                }
                else map1[i][j] = "" ;
            }
        }
        
        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                //2번째 맵의 경우 
                if(map2[i][j].equals("1")) {
                    map2[i][j] = "#";
                }
                else map2[i][j] = "" ;
            }
        }
        
        for(int i=0; i < n; i++) {
            answer = "";
            for(int j=0; j < n; j++) {
                if(map1[i][j] == "#" || map2[i][j] == "#") {
                    answer += "#";
                }
                else {
                    answer += " ";
                }
            }
            ansMap[i] = answer;
            // answer = "";
        }
        return ansMap;
    }

}
