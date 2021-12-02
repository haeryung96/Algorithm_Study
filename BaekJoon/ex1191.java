package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 전위순회 (preorder traversal) : 루트 -> 왼쪽자식 -> 오른쪽 자식
// 중위순회 (inorder traversal) : 왼쪽자식 -> 루트 -> 오른쪽 자식
// 후위순회 (postorder traversal) : 왼쪽자식 -> 오른쪽 자식 -> 루트

public class ex1191 {
    public static class Node {
        char data; // 노드 값
        Node left; // 왼쪽 자식노드 참조 값
        Node right; // 오른쪽 자식노드 참조 값

        // 추가할 때 참조되는 왼쪽, 오른쪽 자식의 값을 모르기 때문에 data값을 기반으로 Node 객체 생성
        Node(char data){
            this.data = data;
        }
    }

    public static class Tree{
        public Node root; // 초기 루트 노드는 null

        // 노드 추가
        public void createNode(char data, char left, char right){
            if(root == null){ // 초기 상태일 경우에는 루트 노드 null
                root = new Node(data);

                // 왼쪽 노드 값이 있다면
                if(left != '.'){
                    root.left = new Node(left); // 왼쪽 자식 노드를 가지는 Node 인스턴스 생성
                }

                // 오른쪽 노드 값이 있다면
                if(right != '.'){
                    root.right = new Node(right); // 오른쪽 자식 노드를 가지는 Node 인스턴스 생성
                }
            }
            // 초기 트리 상태가 아니라면
            else{
                searchNode(root, data, left, right);
            }
        }

        // 매개변수로 들어온 root 노드를 시작으로 data와 같은 값을 가진 노드를 찾음
        // 찾을 떄 까지 루트노드에서부터 왼쪽 오른쪽으로 내려감
        public void searchNode(Node node, char data, char left, char right){
            if(node == null){ // Node의 값이 null 이라면 더이상 삽입할 노드가 없음
                return;
            }
            else if(node.data == data){ // 들어갈 위치를 찾았다면
                if(left != '.'){ // 추가할 노드가 있다면 노드 생성
                    node.left = new Node(left);
                }
                if(right != '.'){
                    node.right = new Node(right);
                }
            }
            else { // 아직 들어갈 노드를 찾지 못했다면 재귀로 들어갈 노드 찾기
                searchNode(node.left, data, left, right); // 왼쪽 탐색
                searchNode(node.right, data, left, right); // 오른쪽 탐색
            }
        }

        // 전위순회 : 루트 - 왼쪽 - 오른쪽
        public void preOrder(Node node){
            if(node != null){
                System.out.print(node.data);
                if(node.left != null) preOrder(node.left); // 재귀를 호출하면서 왼쪽 노드 출력
                if(node.right != null) preOrder(node.right);
            }
        }

        // 중위순회 : 왼쪽 - 루트 - 오른쪽
        public void inOrder(Node node){
            if(node != null){
                if(node.left != null) inOrder(node.left);
                System.out.print(node.data);
                if(node.right != null) inOrder(node.right);
            }
        }

        // 후위순회 : 왼쪽 - 오른쪽 - 루트
        public void postOrder(Node node){
            if(node.left != null) postOrder(node.left);
            if(node.right != null) postOrder(node.right);
            System.out.print(node.data);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        StringTokenizer st ;
        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());

            tree.createNode(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}
