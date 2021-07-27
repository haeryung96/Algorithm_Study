package nadongbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// * 혹은 + 연산자를 넣어  만들어진 가장 큰 수 만들기 
// 모든 연산은 왼쪽에서부터 순서대로 진행 

public class Solution_곱하기혹은더하기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("");
		
		int[] num = new int[input.length];
		for(int i=0; i < num.length; i++) {
			num[i] = Integer.parseInt(input[i]);
		}
		
		int firstNum = num[0];
		
		for(int i=1; i < num.length; i++) {
			int n = num[i];
			
			if(firstNum <= 1 || n <= 1) { // 첫 번쨰 숫자가 0과 1 이거나 숫자가 0과 1이면
				firstNum += n; // 더하는 게 최대 숫자
			}
			else { // 0과 1이 아니면 모든 숫자는 곱하는 게 최대숫자
				firstNum *= n;
			}
		}
		
		System.out.println(firstNum);
	}

}
