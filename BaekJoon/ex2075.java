import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex2075 {
	static int N;
	
	public static class maxHeap {
		static ArrayList<Integer> heap;
		
		// 힙 생성자
		public maxHeap() {
			heap = new ArrayList<>();
			heap.add(0); // 인덱스 0 채우기 (1부터 시작하기 위해서)
		}
		
		// 삽입 연산자
		public void insert(int data) {
			heap.add(data);
			int position = heap.size() - 1; // 힙의 마지막 인덱스에 값을 넣기 위해 위치 데이터 선언 
			
			// 인덱스가 루트까지 다 올라왔거나, 부모 Heap이 자식 Heap보다 작을때까지
			while(position > 1 && heap.get(position / 2) < heap.get(position)) {
				
				// 부모 노드와 자식 노드간의 swap 연산 
				int parentNode = heap.get(position / 2); // 부모 노드의 인덱스  
				int childNode = heap.get(position);
				
				heap.set(position / 2, childNode); // 부모 노드의 인덱스 위치에
				heap.set(position, parentNode); // 자식 노드의 인덱스 위치에 부모 노드를 
				
				position /= 2; // 그래프 위로 올라가도록 인덱스의 위치를 옮김
			}
		}
		
		public int remove() {
			// 힙의 사이즈가 아무것도 없으면 0번째 인덱스에 있는 값인 0 하나만 남게 되므로, 힙의 사이즈가 0이 된다면 리턴 0
			if(heap.size() - 1 == 0) {
				return 0;
			}
			
			int deleteData = heap.get(1); // 부모 노드 삭제 
			heap.set(1, heap.get(heap.size() - 1)); //루트 노드 자리에 마지막 노드의 data로 치환
			heap.remove(heap.size() - 1);
			
			int position = 1;
			
			while((position * 2) < heap.size()) { // 힙의 크기보다 작을때 까지 
				int leftNode = heap.get(position * 2); // 현재 노드의 왼쪽 자식 노드의 값 
				int leftPos = position * 2; // 왼쪽 자식 노드의 인덱스 값 
								
				// 오른쪽 자식 노드와 왼쪽 자식 노드 중 더 큰 노드의 값과 비교,교환하기 떄문에
				// 왼쪽 자식노드와 오른쪽 자식 노드의 값을 비교하는 과정 
				// rightNode < heap.size() 은 값이 범위를 벗어나지 않도록 하기 위해서 
				if( ((position * 2 + 1) < heap.size()) && leftNode < heap.get(position * 2 + 1)) {
					leftNode = heap.get(position * 2 + 1); // 왼쪽 자식 노드를 오른쪽 자식 노드로 치환 
					leftPos = position * 2 + 1;
				}
				 
				// 현재의 노드보다 자식 노드가 작으면 힙이 완정되었기 때문에 종료 
				if(heap.get(position) > leftNode) break; 
				
				// 자식 노드와 부모 노드 swap
				int tmp = heap.get(position);
				heap.set(position, heap.get(leftPos));
				heap.set(leftPos, tmp);
				position = leftPos;
			}
			
			return deleteData;
		}
		
		public void print(int num) {
			System.out.println(heap.get(1));
		}
	}
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		maxHeap heap = new maxHeap();
		
		StringTokenizer st;
		for(int i=0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				heap.insert(num);
			}
		}
		
		for(int i = 1; i < N; i++) {
			heap.remove();
		}
		
		heap.print(1);
	}

}
