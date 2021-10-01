import java.io.*;

public class ex2954 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < input.length; i++) {
			input[i] = input[i].replaceAll("apa", "a").replaceAll("epe", "e")
					.replaceAll("ipi", "i").replaceAll("opo", "o").replaceAll("upu", "u");
			sb.append(input[i]).append(" ");
		}

		System.out.println(sb);
	}

}
