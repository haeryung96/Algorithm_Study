import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * How 구현?
 * 1. 다른방향으로 움직이는 개미들을 한곳에 모아둠
 * 2. 각 개미들의 방향을 설정해서 서로 다른 방향의 개미들을 swap 해줌
 * 3. swap 메소드를 따로 구현하려고 했으나 잘 안되어서..
 * 4. Collections.swap 사용 -> 처음 써봤는데 좋은 것 같다 애용하자!
 * */

public class ex3048 {
	public static ArrayList<position> list = new ArrayList<>();
	public static class position{
		String ant;
		String tmp;
    
		public position(String ant, String tmp) {
			this.ant = ant;
			this.tmp = tmp;
		}
	
	}
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N1 = Integer.parseInt(input[0]); // 첫 번째 그룹의 개미의 수 
		int N2 = Integer.parseInt(input[1]); // 두 번쨰 그룹의 개미의 수 
		
		String gaeme1[] = br.readLine().split("");
		String ant1[] = new String[N1];
		for(int i=N1 - 1; i >=0; i--) {
			ant1[i] = gaeme1[i];
			list.add(new position(ant1[i], "RIGHT"));
		}
		
		String gaeme2[] = br.readLine().split("");
		String ant2[] = new String[N2];
		for(int i=0; i < N2; i++) {
			ant2[i] = gaeme2[i];
			list.add(new position(ant2[i], "LEFT"));
		}
		
		int tc = Integer.parseInt(br.readLine());

		while(tc-- > 0) {
			for(int i=0; i < list.size() - 1; i++) {
				// 오른쪽 방향으로 움직이는 개미들을 기준으로 서로 방향이 같지 않다면 방향을 바꿔줌 
				if(list.get(i).tmp == "RIGHT" && list.get(i).tmp != list.get(i+1).tmp) {
					Collections.swap(list, i, i+1);
					i++;
				}
			}
		}
		
		for(int i=0; i < list.size(); i++) {
			System.out.print(list.get(i).ant);
		}
	}

}
