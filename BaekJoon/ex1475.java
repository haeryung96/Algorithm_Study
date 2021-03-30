import java.io.*;

/*
 * How 구현?
 * 1. 0 ~ 9까지가 한 세트
 * 2. 각 자릿수에 해당하는 인덱스의 위치에 값을 더해줌
 * 3. 6과 9의 경우는 서로 대체 가능하기 때문에 arr[9]에 넣고 홀수인 경우와 짝수인 경우를 나눔 
 * 4. 배열안에 있는 값의 최대값이 정답이 됨 
 */

public class ex1475 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine(); // 다솜이의 방 번호
		int[] arr = new int[10]; 
		int num = 0;
		
		// 9999
		for(int i=0; i < N.length(); i++) {
			num = N.charAt(i) - '0'; // 숫자의 형태로 저장 
			if(num == 6) { // 6인 경우도
				arr[9]++;  // 9의 배열에 넣고 함께 생각함 
			}
			else {
				arr[num]++;
			}
		}
				
		// 9의 개수에 따라 최솟값이 달라짐
		if(arr[9] % 2 == 1) { // 9의 개수가 홀수개라면
			arr[9] = arr[9]/2 + 1;// 사용할 수 있는 세트는 홀수개
		}
		else if(arr[9] % 2 == 0) {
			arr[9] = arr[9]/2; // 사용할 수 있는 세트는 짝수개 
		}
		
		int max = 0;
		
		for(int i : arr) {
			max = Math.max(i, max);
		}

		System.out.println(max);
	}

}
