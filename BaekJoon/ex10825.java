import java.io.*;
import java.util.*;

/*
 * How 구현? 
 * 1. comparable 인터페이스 사용
 * 2. 인터페이스를 기준으로 정렬
 * 3. 문자열 대소비교
 */

class ScoreMap implements Comparable<ScoreMap> {
	String name;
	int kr;
	int eng;
	int math;

	ScoreMap(String name, int kr, int eng, int math) {
		this.name = name;
		this.kr = kr;
		this.eng = eng;
		this.math = math;
	}

	@Override
	public int compareTo(ScoreMap o) { // 먼저와야하는 값을 리턴 1
		// 1. 국어 점수가 감소하는 순서로 
		if (this.kr < o.kr) { // 나의 국어 점수가 들어온 국어 점수 값이 작다면
			return 1;
		}
		// 2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
		else if (this.kr == o.kr) {
			if(this.eng > o.eng) {
				return 1;
			}
			// 3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로 
			else if(this.eng == o.eng) {
					if(this.math < o.math) {
						return 1;
				}
				else if(this.math == o.math) {
					// 4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 
					if ((this.name).compareTo(o.name) > 0) { // 문자열 대소비교**
						return 1;
					}
					else return -1;
				}
			}
		}
		return -1;
	}
}

public class ex10825 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		ArrayList<ScoreMap> scm = new ArrayList<ScoreMap>();

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			scm.add(new ScoreMap(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3])));
		}
		
		Collections.sort(scm); // compareTo 메소드를 기준으로 scm을 정렬 
		
		for(int i=0; i<scm.size(); i++) {
			System.out.println(scm.get(i).name);
		}
	}
}
