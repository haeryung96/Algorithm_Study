package baekjoon;
import java.io.*;
import java.util.*;

public class ex18310 {
	public static int N; // 집의 수 
	public static int[] home;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		home = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(home);
		
		System.out.println(home[(N - 1)/2]);
	}

}
