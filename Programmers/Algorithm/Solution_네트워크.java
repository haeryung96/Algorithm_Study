// 네트워크의 개수는 그래프의 개수랑 같다고 생각 
// 모든 노드를 탐색한 후에 그래프 개수를 카운트 

import java.util.*;
class Solution_네트워크 {
    static boolean[] visited; // 방문 배열
    static Queue<Integer> q = new LinkedList<>();
    
    static void bfs(int node, int[][] computers){
        q.add(node); // 큐에 노드를 넣고 
        visited[node] = true; // 노드의 방문처리 
        
        while(!q.isEmpty()){
            int k = q.poll();
            
            for(int i = 0; i < computers.length; i++){
                //연결된 노드가 자기 자신이 아니고 방문하지 않은 노드라면
                if(computers[k][i] == 1 && k != i && !visited[i]){
                    q.add(i); // 노드를 큐에 넣고
                    visited[i] = true; // 방문처리 
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[computers.length];
        for(int i = 0; i < n; i++){
            if(!visited[i]) // 방문하지 않은 노드라면
            {
                // 탐색시작
                bfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
}
