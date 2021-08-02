package nadongbin;
import java.io.*;
import java.util.*;

public class Solution_럭키스트레이트 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("");
		
		int[] list = new int[input.length];
		
		for(int i=0; i < input.length; i++) {
			list[i] = Integer.parseInt(input[i]);
		}
		
		int sumLeft = 0; // 왼쪽 합
		for(int i=0; i < input.length/2; i++) {
			sumLeft += list[i];
		}
		
		int sumRight = 0; // 오른쪽 합 
		for(int i=input.length/2; i < input.length; i++) {
			sumRight += list[i];
		}
		
		if(sumLeft == sumRight) {
			System.out.println("LUCKY");
		}
		else {
			System.out.println("READY");
		}
	}

}
