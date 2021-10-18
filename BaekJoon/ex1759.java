import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 먼저 L 개를 뽑는다. 
// 사전순으로 정렬하기 위해서는 sort를 해준다.
// 뽑은 L개 중에서 모음과 자음의 개수를 카운트해서 조건에 맞는 문자를 출력한다. 
// 최소 1개의 모음 최소 2개의 자음 

public class ex1759 {
	static int L, C;
	static String[] alpha;
	static boolean[] visited; // 조합 구하기 
	static int vowelCnt; // 자음의 개수 
	static int consonantCnt; // 모음의 개수 
	static StringBuilder sb = new StringBuilder();
	static boolean flag;
	
	// start 기준 변수, r은 몇개 뽑을지
	public static void comb(String[] arr, boolean[] visited, int start, int r) {		
		if(r == 0) {
			count(arr, visited);
			return;
		}
		else {
			for(int i = start; i < C; i++) {
				visited[i] = true;
				comb(arr, visited, i + 1, r - 1);
				visited[i] = false;
			}
		}
	}

	public static void count(String[] arr, boolean[] visited) {
		vowelCnt = 0;
		consonantCnt= 0;

		for(int i=0; i < arr.length; i++) {
			if(visited[i] == true) {
				// 자음의 개수 카운트 
				if(arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o")  || arr[i].equals("u")) {
					vowelCnt++;
				}
				// 모음의 개수 카운트
				else {
					consonantCnt++;
				}
				
				sb.append(arr[i]);
			}
		}
        // 자음과 모음의 개수가 조건에 맞는다면 출력 
		if(vowelCnt >= 1 && consonantCnt >= 2) {
			System.out.println(sb);
		}
		
		sb = new StringBuilder(); // 다시 초기화 
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		L = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		alpha = new String[C];
		visited = new boolean[C + 1];
		
		String[] input2 = br.readLine().split(" ");
		for(int i=0; i < C; i++) {
			alpha[i] = input2[i];
		}
		
		Arrays.sort(alpha);
		
		comb(alpha, visited, 0, L);
	}

}
