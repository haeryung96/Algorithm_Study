import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex3896 {
    static boolean prime[] = new boolean[1299709]; // 소수인지 아닌지
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 소수이면 false 소수가 아니면 true
        prime[0] = prime[1] = true; // 0과 1은 소수가 아니므로 제외

        //2. 2부터 시작해서 특정 수의 배수에 해당하는 수를 모두 지움
        // (지울 때 자기자신은 지우지 않고, 이미 지워진 수는 건너뜀
        for(int i=2; i*i <= prime.length; i++){
            // prime[i]가 소수라면
            if(!prime[i]){
                // prime[j] 소수가 아닌 표시
                for(int j=i*i; j<= prime.length; j+=i) prime[j]=true;
            }
        }

        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-- > 0){
            int num = Integer.parseInt(br.readLine());
            int start = num;
            int end = num;

            if(num == 1){
                sb.append("0").append("\n");
            }else if(num == 1299709){
                sb.append("0").append("\n");
            }else {
                while(prime[start]){
                    start++;
                }
                while(prime[end]){
                    end--;
                }
                sb.append(start-end).append("\n");

            }
        }

        System.out.println(sb.toString());
    }
}
