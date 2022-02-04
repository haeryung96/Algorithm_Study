package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex13702 {
    static int N, K; // 주전자의 수, 친구들의 수
    static int[] ml; // 막걸리 용량
    static long max, start, end;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        ml = new int[N];
        max = 0;

        for(int i = 0; i < N; i++){
            ml[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, ml[i]);
        }

        // 이분탐색 시작
        start = 0;
        end = max;

        while(start <= end){
            int cnt = 0; // 몇 병으로 나눌 수 있는지
            long mid = (start + end)/2;

            if(mid == 0){
                //System.out.println(0);
                break;
                //mid = 1;
            }

            for(int num : ml){
                cnt += num / mid;
            }

            // 주전자의 개수가 사람의 수보다 많을 수는 없음
            if (cnt >= K){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        // start가 end를 넘어서는 순간 end값이 최대용량
        System.out.println(end);
    }
}
