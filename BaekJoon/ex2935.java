import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ex2935 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BigInteger a = new BigInteger(br.readLine());
        String ops = br.readLine();
        BigInteger b = new BigInteger(br.readLine());

        if(ops.equals("*")){
            sb.append(a.multiply(b));
        }else {
            sb.append(a.add(b));
        }

        System.out.println(sb.toString());
    }
}
