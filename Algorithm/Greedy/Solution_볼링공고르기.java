package nadongbin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 서로 무게가 다른 볼링공 고르기 

public class Solution_볼링공고르기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]); // 볼링공의 개수 
		int M = Integer.parseInt(input[1]); // 볼링공의 최대 무게 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[N];
		for(int i=0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		
		for(int i=0; i < N - 1; i++) {
			for(int j=i+1; j < N; j++) {
				if(list[i] != list[j]) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}

}
