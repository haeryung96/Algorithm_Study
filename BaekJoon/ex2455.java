package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ex2455 {
    static ArrayList<Integer> list = new ArrayList<>(); // 각 역의 총 승객의 수

    static int ans ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ans = 0;

        for(int i = 0; i < 4; i++){
            String[] input = br.readLine().split(" ");
            ans += (Integer.parseInt(input[1]) - Integer.parseInt(input[0]));
            list.add(ans);
        }

        Collections.sort(list);

        System.out.println(list.get(3));
    }
}
