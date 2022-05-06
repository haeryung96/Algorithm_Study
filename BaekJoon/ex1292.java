package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*1 2 2 3 3 3 4 4 4 4 5 ..
* 0 1 2 3 4 5 6 7 8 9 10
* 1 2 3 4 5 6 7 8 9 10 11
* 3~7*/
public class ex1292 {
    static int a,b;
    static ArrayList<Integer> list = new ArrayList<>();
    static int ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);
        ans = 0;

        for(int i = 0; i < 1000; i++){
            for(int j = 0; j <= i; j++){
                list.add(i+1);
            }
        }

        for(int i = a-1; i <= b-1; i++){
            ans += list.get(i);
        }

        System.out.println(ans);
    }
}
