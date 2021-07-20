package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Solution_두개뽑아서더하기 {

	public static void main(String[] args) {
		int numbers1[] = {2,1,3,4,1};
		System.out.println(solution(numbers1));
		
		int numbers2[] = {5,0,2,7};
		System.out.println(solution(numbers2));

	}

	public static String solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int num = 0;
        
        for(int i=0; i < numbers.length; i++) { // 0 ~ 4
            for(int j=i+1; j < numbers.length; j++) { // 1 ~ 4
                num = numbers[i] + numbers[j];
                
                if(list.indexOf(num) < 0) { // 해당 값이 리스트에 없다면 -> 값이 리스트에 없다면 -1을 반환함
                	list.add(num);
                }
            }
        }
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        
        int i=0;
        for(int n : list) {
        	answer[i] = list.get(i);
        	i++;
        }
        
        //return answer;
        return Arrays.toString(answer);
    }
}
