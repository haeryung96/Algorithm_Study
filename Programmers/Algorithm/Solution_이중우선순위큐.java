import java.util.*;

public class Solution {
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소힙
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙
	
	public static void main(String[] args) {
		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        solution(operations);

	}
	
	public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        for(String op : operations) {
        	String[] input = op.split(" ");
        	String command = input[0]; // 명령어 입력
        	int number = Integer.parseInt(input[1]); // 뒤에 숫자 입력 
        	
        	// 우선순위큐의 사이즈가 0이고 D연산자가 들어오면 해당 연산 무시 
        	if(minHeap.size() == 0 && maxHeap.size() == 0 && command.equals("D")) {
        		continue;
        	}
        	
        	// 삽입 연산자가 들어오면
        	if(command.equals("I")) {
        		minHeap.add(number);
        		maxHeap.add(number);
        	}
        	// 삭제 연산자가 들어오면 
        	else if (command.equals("D")) {
        		// 최대값을 삭제 : 최대 힙에서 루트 노드 삭제 
        		if(number == 1) {
        			int max = maxHeap.poll();
        			minHeap.remove(max);
        		}
        		// 최소값을 삭제 : 최소힙에서 루트 노드 삭제 
        		else {
        			int min = minHeap.poll();
        			maxHeap.remove(min);
        		}
        	}
        	
        }
        
        if(minHeap.size() == 0 && maxHeap.size() == 0) {
        	answer[0] = 0;
        	answer[1] = 0;
        }
        else {
        	answer[0] = maxHeap.peek(); // 최대값
        	answer[1] = minHeap.peek(); // 최소값
        }
        
        return answer;
    }

}
