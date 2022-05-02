package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 배(0)와 등(1)
* 도(배 한 개, 등 세 개) 3 A, 개(배 두 개, 등 두 개) 2 B, 걸(배 세 개, 등 한 개) 1 C, 윷(배 네 개) 0 D, 모(등 네 개)4 E
* */
public class ex2490 {
    static int tc;
    static Character res[];
    static int cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = 3; // 테스트 케이스 수

        res = new Character[5];
        res[0] = 'D'; res[1] = 'C'; res[2] = 'B'; res[3] = 'A'; res[4] = 'E';

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tc; i++){
            String[] input = br.readLine().split(" ");

            for(int j = 0; j < tc+1; j++) {
                cnt += Integer.parseInt(input[j]);
            }

            if(cnt == 0){
                sb.append(res[0]).append('\n');
            }else if(cnt == 1){
                sb.append(res[1]).append('\n');
            }else if(cnt == 2){
                sb.append(res[2]).append('\n');
            }else if(cnt == 3){
                sb.append(res[3]).append('\n');
            }else{
                sb.append(res[4]).append('\n');
            }

            cnt = 0;
        }

        System.out.println(sb.toString());
    }
}
