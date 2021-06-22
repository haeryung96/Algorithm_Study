package baekjoon;
import java.io.*;
import java.util.*;

/*
 * How 구현?
 * 1. 정렬 -> Comperator 사용 방법 익히자 !!
 * */

public class ex10814 {
	
	public static class Person {
		public int age;
		public String name;
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Person> list = new ArrayList<>();
		StringTokenizer st;

		for(int i=0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			String n = st.nextToken();
			
			list.add(new Person(a, n));
		}
		
		Comparator<Person> comparator = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.age - o2.age;
			}
			
		};
		
		Collections.sort(list, comparator);
		
		for(Person data : list) {
			System.out.println(data.age + " " + data.name);
		}
		
		//System.out.println(list);
	}

}
