import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 미완성
// 성립안되는 반례

/*
 * 2 3 
 * 1 1000 -> my ans : 1 ans : 2
 */

public class ex1449 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]); // 물이 새는 곳의 개수
		int L = Integer.parseInt(input[1]); // 테이프의 길이 
		int[] arr = new int[N]; // 물이 새는 곳의 위치 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int cnt = 0; // 테이프의 개수
		double startPoint = arr[0] - 0.5; 
		
		for(int point: arr) { // for-each
			if(point < startPoint + L) {
				if(point + 0.5 == startPoint + L) {
					cnt++;
				}
			}
			else {
				startPoint = point;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
