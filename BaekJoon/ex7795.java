package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ex7795 {
    static int tc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(tc-- > 0){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            int[] aArr = new int[a];
            int[] bArr = new int[b];

            input = br.readLine().split(" ");
            for(int i = 0; i < a; i++){
                aArr[i] = Integer.parseInt(input[i]);
            }

            input = br.readLine().split(" ");
            for(int i = 0; i < b; i++){
                bArr[i] = Integer.parseInt(input[i]);
            }

            Arrays.sort(aArr);
            Arrays.sort(bArr);

            int ans = 0;
            for(int i = 0; i < a; i++){
                for(int j = 0; j < b; j++){
                    if(aArr[i] <= bArr[j]) break; // 시간초과나서 추가 -> 정렬해놓았기 때문에 같거나 작으면 검사할 필요 없음
                    else if(aArr[i] > bArr[j]){
                        ans++;
                    }
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }
}
