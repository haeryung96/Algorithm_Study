import java.io.*;
import java.util.*;

/*
 * How 구현?
 * 1. 배수 판정법 사용
 * 2. 30의 배수는 3의 배수이면서 10의 배수
 * 3. 30의 배수는 3의 배수이면서 일의 자리가 0인 수
 * 4. 3의 배수는 각 자리 숫자의 합이 3인 배수 
 */ 

public class ex10610 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		ArrayList<Integer> list = new ArrayList<>();
		int sum = 0;
		
		// 잘라진 값을 배열에 하나하나 넣기 
		for(int i=0; i<input.length(); i++) {
			list.add(input.charAt(i)-'0'); // 리스트에 각 자리 수 넣기
			sum += input.charAt(i)-'0'; // 각 자리숫자의 합을 구해서 3의 배수인지 확인하기 위해서 사용 
		}
		
		// 30의 배수는 3의 배수이면서 10의 배수 
		// 오름차순으로 정렬 - 0 1 2
		Collections.sort(list); // 1의 자리수가 0인 것을 구하기 위해서 오름차순으로 정렬 
		
		if(sum%3==0 && list.get(0) == 0) { // 각 자리수의 합이 3의 배수이면서 일의 자리수가 0이라면
			for(int i=list.size()-1; i>=0; i--) { // 최대값을 구하기 위해서 제일 큰 값부터 출력
				System.out.print(list.get(i));
			}
		}
		// 30의 배수가 아니라면
		else System.out.println("-1");
	}

}
