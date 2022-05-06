package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex9093 {
    static int tc;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String res = "";
        for(int i = 0; i < tc; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < input.length; j++){
                res += sb1.append(input[j]).reverse();
                res += " ";
                sb1.delete(0, input[j].length());
            }
            sb2.append(res).append('\n');
            res = "";
            //res += System.lineSeparator();
        }

        System.out.println(sb2);
    }
}
