import java.util.*;

/** 
 * 영어로 Traveling Salesman problem (TSP)라고 불리는 문제로 가장 중요하게 취급되는 문제 중 하나
 * 1번부터 N번까지 번호가 매겨져있는 도시가 있다.
 * 한 도시에서 시작해 N개의 모든 도시를 거쳐 다시 원래 도시로 돌아오려고 한다.
 * (한번 갔던 도시는 다시 갈 수 없다.)
 * 이 때, 가장 적은 비용을 구하는 문제 
 * **/

/**
 * 순서가 중요한 문제 - 순열로 풀기 
 * N개의 모든 도시를 1번씩 방문
 * N개의 모든 도시를 방문하는 모든 순서를 만들어서 W를 이용하여 값을 계산하면 됨
 * 가장 중요한 것은 N의 제한을 살펴야함 . N이 10!이기 때문에 가능
 * **/

public class ex10971 {
	public static boolean permutation(int[] w) {
		int i = w.length-1;
		
		//1번과정
		while(i>0 && w[i-1]>=w[i]) {
			i-=1;
		}
		
		int j = w.length-1;
		
		//2번 과정 
		while(w[i-1]>=w[j]) {
			j-=1;
		}
		
		//3번 과정 
		swap(w,i-1,j);
		
		//4번과정 
		j = w.length-1;
		
		while(i<j) {
			swap(w,i,j);
			i+=1;
			j-=1;
		}
		return true;
		
	}
	public static void swap(int[] w, int i, int j) {
		int temp;
		temp = w[i];
		w[i] = w[j];
		w[j] = temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); //테스트 개수 입력 받기 
		
		//비용 - 2차원 배열 생성
		int[][] w = new int[t][t];
		
		//비용 입력 
		for(int i=0; i<w.length; i++) {
			for(int j=0; j<w.length; j++) {
				w[i][j]= sc.nextInt();
			}
		}
		
		//노드 생성 ex) 4개의 노드이면 0~3번까지 갈 수 있는 길을 찾는것
		int[] d = new int[t];
		for(int i=0; i<t; i++) {
			d[i] = i;
		}
		int ans = Integer.MAX_VALUE;
		//int ans = 0;
		
		do {
			//노드가 1인것만 고정해서 계산 
			//문제의 조건에서 원래의 도시로 돌아온다고 했기 때문
			//예를 들어, 3412의 경우 1234와 동일한 결과, 2134의 경우 1342와 동일한 결과 등등
			//따라서 첫번째 노드를 1로 고정하고 모든 순열을 계산해도 무방
			
			if(d[0]!=0) break; //시작점이 0이 아니라면 더이상 계산할 필요 없음 
			boolean ok = true; //올바른 경로인지 확인하기 위해서 
			int sum = 0;
			
			//1번째부터 마지막 이전까지의 노드 검사
			for(int i=0; i<t-1; i++) {
				if(w[d[i]][d[i+1]]==0) { 
					ok = false; //비용이 0이라면 갈 수 없음
				}else { //비용이 0이 아니라면
					sum += w[d[i]][d[i+1]]; //비용을 더해줌
					
				}
			}
			//마지막에서 첫번째로 다시 돌아오는 경우 계산
			if(ok && w[d[t-1]][d[0]]!=0) {
				sum += w[d[t-1]][d[0]];
				if (ans > sum) {
					ans = sum;
				}
			}
			
		} while(permutation(d));
		
		System.out.println(ans);

	}

}
