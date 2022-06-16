package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* s1 : 샘플 테스트케이스 개수 s2 : 시스템 테스트케이스 개수
* 1~s1 줄 : 샘플 테스트케이스 & 만영이 코드
* 이후 s2 줄 : 시스템 테스트케이스 & 만영이 코드
*
* 올바른 답을 생성했다면 "Accepted"
* 샘플 테스트케이스를 틀렸다면 "Wrong Answer"
* 샘플 테스트케이스는 맞았지만 시스템 테스트케이스를 틀렸을 경우에는 "Why Wrong"
* */
public class ex15820 {
    static int s1, s2;
    static int[][] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        s1 = Integer.parseInt(input[0]);
        s2 = Integer.parseInt(input[1]);
        ans = new int[s1+s2][2];

        for(int i = 0; i < s1 + s2; i++){
            String[] arr = br.readLine().split(" ");
            ans[i][0] = Integer.parseInt(arr[0]);
            ans[i][1] = Integer.parseInt(arr[1]);
            System.out.println(ans[i][0] + " " + ans[i][1]);

            if(ans[i][0] != ans[i][1] && i < s1){
                sb.append("Wrong Answer");
                System.out.println(sb.toString());
                return;
            }else if(ans[i][0] != ans[i][1] && i >= s1 && i < s1 + s2) {
                sb.append("Why Wrong!!!");
                System.out.println(sb.toString());
                return;
            }
        }

        sb.append("Accepted");
        System.out.println(sb.toString());
    }
}
