// 원형 이중 연결 리스트 클래스
public class DbLinkedList<E> {

    // 노드 클래스
    class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        Node() {
            data = null;
            prev = next = this;
        }

        Node(E obj, Node<E> prev, Node<E> next) {
            data = obj;
            this.prev = prev;
            this.next = next;
        }
    }

    // 머리(더미) 노드 & 선택 노드
    private Node<E> head;
    private Node<E> crnt;

    // 생성자
    public DbLinkedList() {
        head = crnt = new Node<>();
    }

    // 리스트가 비어 있는가를 조사하는 메서드
    public boolean isEmpty() {
        return head.next == head;
    }

    // 노드를 검색하는 메서드
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head.next;

        while (ptr != head) {
            if (c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    // 선택 노드를 출력하는 메서드
    public void printCurrentNode() {
        if (isEmpty())
            System.out.println("선택 노드는 없습니다.");
        else
            System.out.println(crnt.data);
    }

    // 모든 노드를 출력하는 메서드
    public void dump() {
        Node<E> ptr = head.next;

        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
    
    // 모든 노두를 거꾸로 출력하는 메서드
    public void dumpReverse() {
        Node<E> ptr = head.prev;

        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.prev;
        }
    }

    // 선택 노드를 뒤쪽으로 이동하는 메서드
    public boolean next() {
        if (!isEmpty() && crnt.next != head) {
            crnt = crnt.next;
            return true;
        }
        return false;
    }

    // 선택 노드를 앞쪽으로 이동하는 메서드
    public boolean prev() {
        if (!isEmpty() && crnt.prev != head) {
            crnt = crnt.prev;
            return true;
        }
        return false;
    }

    // 노드를 삽입하는 메서드
    public void add(E obj) {
        Node<E> node = new Node<>(obj, crnt, crnt.next);

        crnt.next = crnt.next.prev = node;
        crnt = node;
    }

    // 머리에 노드를 삽입하는 메서드
    public void addFirst(E obj) {
        crnt = head;
        add(obj);
    }

    // 꼬리에 노드를 삽입하는 메서드
    public void addLast(E obj) {
        crnt = head.prev;
        add(obj);
    }

    // 선택 노드를 삭제하는 메서드
    public void removeCurrentNode() {
        if (!isEmpty()) {
            crnt.prev.next = crnt.next;
            crnt.next.prev = crnt.prev;
            crnt = crnt.prev;
            if (crnt == head) crnt = head.next;
        }
    }

    // 특정 노드를 삭제하는 메서드
    public void remove(Node<E> p) {
        Node<E> ptr = head.next;

        while (ptr != head) {
            if (ptr == p) {
                crnt = p;
                removeCurrentNode();
                break;
            }
            ptr = ptr.next;
        }
    }

    // 머리 노드를 삭제하는 메서드
    public void removeFirst() {
        crnt = head.next;
        removeCurrentNode();
    }

    // 꼬리 노드를 삭제하는 메서드
    public void removeLast() {
        crnt = head.prev;
        removeCurrentNode();
    }

    // 모든 노드를 삭제하는 메서드
    public void clear() {
        while (isEmpty()) {
            removeFirst();
        }
    }
}
