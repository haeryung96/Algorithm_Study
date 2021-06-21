import java.io.*;
import java.util.*;

/*
 * How 구현?
 * 1. 큐로 하려고 했는데 다시 한 문자씩 다 붙여야 해서 효율 안좋은 것 같음
 * 2. 정렬 
 * */

public class ex11656 {
	public static ArrayList<String> textArr = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] S = br.readLine().split("");
		String txt = "";
		
		StringBuilder sb = new StringBuilder();

		for(int i=0; i < S.length; i++) {
			for(int j=i; j <S.length; j++) {
				txt += S[j];
			}
			textArr.add(txt);
			txt=""; // 다시 빈 칸으로 갱신 
		}

		Collections.sort(textArr);
		
		for(String input : textArr) {
			System.out.println(input);
		}
	}

}
