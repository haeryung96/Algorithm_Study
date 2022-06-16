package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex14910 {
    static int[] num;
    static boolean flag = true;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        num = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            num[i] = Integer.parseInt(arr[i]);
        }

        for(int i = 0; i < arr.length -1 ; i++){
            if(num.length == 0){
                break;
            }else{
                if(num[i] <= num[i+1]){
                    continue;
                }else {
                    flag = false;
                    break;
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        String ans = "Good";
        if(!flag){
            ans = "Bad";
            sb.append(ans);
        }else{
            sb.append(ans);
        }

        System.out.println(sb.toString());
    }
}
