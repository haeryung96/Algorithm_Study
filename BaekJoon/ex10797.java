import java.io.*;
import java.util.*;

public class ex10797 {
	public static int date; // 날짜의 일의 자리 숫자
	public static int[] num;
	public static int cnt;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		date = Integer.parseInt(br.readLine());
		
		num = new int[5];
		cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i < 5; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			
			if(date == num[i]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
