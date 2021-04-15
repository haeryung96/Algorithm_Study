import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * How 구현?
 * 1. 그리디
 * 2. 가장 낮은 가격만 보면 되므로 패키지의 가격가 낱개의 가격을 오름차순으로 정렬 
 * 3. 패키지로만 구매하는 경우, 낱개로만 구매하는 경우, 패키지와 낱개 둘 다 구매하는 경우를 구하고 그 중 최솟값을 구하면 됨 
 */

public class ex1049 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 끊어진 기타줄의 개수 
		int M = Integer.parseInt(st.nextToken()); // 기타줄 브랜드 개수 

		
		int[] pack = new int[M]; // 페키지 가격 배열
		int[] price = new int[M]; // 낱개 가격 배열
		
		for(int i=0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			pack[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		// 가격을 정렬해서 가장 낮은 가격만 계산해보기 
		Arrays.sort(pack);
		Arrays.sort(price);
		
		int minPrice = 0;
		
		// 패키지만을 사용해서 사는 경우  VS 낱개로만 사는 경우  VS  패키지와 낱개를 사용해서 사는 경우  
		minPrice = Math.min(((N/6)+1) * pack[0], Math.min( N * price[0], ((N/6) * pack[0]) + (N%6) * price[0]));
		
		System.out.println(minPrice);
	}

}
