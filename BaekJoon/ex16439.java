package baekjoon;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * How 구현?
 * 1. 주어진 치킨의 종류 중에서 3종류만 가능
 * 2. 3종류의 치킨 선호도를 모두 구한다음 max 값을 갱신하면서 합을 구함 
 * 3. 합 역시 구한 값 중 최대값을 출력
 * */

public class ex16439 {
	public static int N;
	public static int M;
	public static int[][] prefer;
	public static int res = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); // 고리 회원의 수
		int M = Integer.parseInt(input[1]); // 치킨 종류의 수 
		
		prefer = new int[N][M];
		for(int i=0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j < M; j++) {
				prefer[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i < M; i++) {
			for(int j=0; j < M; j++) {
				for(int k=0; k < M; k++) {
					int sum = 0;
					// 3종류의 치킨 고를 시, 같은 번호를 고를 수 없기 때문에 미리 조건으로 걸러줌 
					if(i!=j && j!=k && k!=i) {
						for(int p=0; p < N; p++) { // 3명의 경우만 조합이 가능
							sum += Math.max(prefer[p][i], Math.max(prefer[p][j], prefer[p][k]));
						}
						res = Math.max(res, sum);
					}
				}
			}
		}
		System.out.println(res);
	}

}
