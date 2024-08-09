package java_algorithm.doit_begin.chapter8;

import java.util.Comparator;

public class Q9_Q10_DoubleLinkedList<E> {

    /*--- 노드 ---*/
    class Node<E> {
        private E data;
        private Node<E> prev;   // 앞쪽 포인터
        private Node<E> next;   // 뒤쪽 포인터

        /*--- 생성자 ---*/
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

    private Node<E> head;   // 머리 포인터(더미 노드 참조)
    private Node<E> crnt;   // 선택 포인터

    /*--- 생성자 ---*/
    public Q9_Q10_DoubleLinkedList() {
        head = crnt = new Node<E>();
    }

    /*--- 리스트가 비어 있는지 확인 ---*/
    public boolean isEmpty() {
//      즉, 더미 노드만 존재하는가?
        return head.next == head;
    }

    /*--- 노드 검색 ---*/
    public E search(E obj, Comparator<? super E> c) {
//      1. head는 더미이므로 head.next부터 시작한다.
        Node<E> ptr = head.next;

        while (ptr != head) {
//          2. 검색에 성공하면 데이터 반환
            if (c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
//      검색 실패 시 null 반환
        return null;
    }

    /*--- 선택 노드 출력 ---*/
    public void printCurrentNode() {
        if (isEmpty())
            System.out.println("선택한 노드가 없습니다.");
        else
            System.out.println(crnt.data);
    }

    /*--- 모든 노드 출력 ---*/
    public void dump() {
        Node<E> ptr = head.next;

//      리스트를 돌며 노드 출력
        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

    /*--- 모든 노드를 역순으로 출력 ---*/
    public void dumpReverse() {
//      head.prev 즉, 리스트의 끝에서 시작한다.
        Node<E> ptr = head.prev;

//      dump와 반대로 prev로 이동하며 출력한다.
        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.prev;
        }
    }

    /*--- 선택 노드를 하나 뒤로 이동 ---*/
    public boolean next() {
//      1. 리스트가 비었거나, 리스트의 마지막 노드이면 실행하지 않음
        if (isEmpty() || crnt.next == head)
            return false;

//      2. 노드를 하나 뒤로 이동
        crnt = crnt.next;
        return true;
    }

    /*--- 선택 노드를 하나 앞으로 이동 ---*/
    public boolean prev() {
//      1. 리스트가 비었거나, 리스트의 첫 번째 노드이면 실행하지 않음
        if (isEmpty() || crnt.prev == head)
            return false;

//      2. 노드를 하나 앞으로 이동
        crnt = crnt.prev;
        return true;
    }

    /*--- 선택 노드의 뒤에 노드 삽입 ---*/
    public void add(E obj) {
//      1. 선택 노드의 뒤에 노드 생성
        Node<E> node = new Node<E>(obj, crnt, crnt.next);

//      2. 선택 노드를 업데이트
        crnt.next = crnt.next.prev = node;
        /* [ 4    5    6    7    8 ] */
        /* [     prev crnt next    ] */

//      3. 새로운 노드를 선택 노드로 설정
        crnt = node;
    }

    /*--- head에 노드 삽입 ---*/
    public void addFirst(E obj) {
//      선택 노드를 head로 설정한 후, add 메서드 실행
        crnt = head;
        add(obj);
    }

    /*--- tail에 노드 삽입 ---*/
    public void addLast(E obj) {
//      선택 노드를 리스트의 맨 뒤로 설정한 후, add 메서드 실행
        crnt = head.prev;
        add(obj);
    }

    /*--- 선택 노드 삭제 ---*/
    public void removeCurrentNode() {
//      1. 리스트가 비었는지 확인
        if (!isEmpty()) {
//          2. 현재 노드의 이전 노드가 현재 노드의 다음 노드를 가리키도록 함.
            crnt.prev.next = crnt.next;

//          3. 다음 노드의 이전 노드가 현재 노드의 이전 노드를 가리키도록 함.
            crnt.next.prev = crnt.prev;

//          4. 현재 노드를 업데이트
            crnt = crnt.prev;

//          5. 업데이트된 노드가 head이면, head의 다음 노드로 재업데이트
            if (crnt == head) crnt = head.next;
        }
    }

    /*--- 노드 p 삭제 ---*/
    public void remove(Node p) {
        Node<E> ptr = head.next;

        while (ptr != head) {
//          1. 검색에 성공
            if (ptr == p) {
//              2. p로 노드를 옮긴 후 removeCurrentNode 메서드 실행
                crnt = p;
                removeCurrentNode();
                break;
            }
            ptr = ptr.next;
        }
    }

    /*--- head 노드 삭제 ---*/
    public void removeFirst() {
//      노드를 옮긴 후 removeCurrentNode 메서드 실행
        crnt = head.next;
        removeCurrentNode();
    }

    /*--- tail 노드 삭제 ---*/
    public void removeLast() {
//      노드를 옮긴 후 removeCurrentNode 메서드 실행
        crnt = head.prev;
        removeCurrentNode();
    }

    /*--- 모든 노드 삭제 ---*/
    public void clear() {

//      리스트가 빌 때까지 head 노드 삭제
        while (!isEmpty())
            removeFirst();
    }

    /*--- Q9. 중복 노드 삭제 ---*/
    public void purge(Comparator<? super E> c) {
        if (head.next == null) return;

        Node<E> ptr = head.next;

//      1. 리스트 순회 루프
        while (ptr != head) {

//          첫 노드는 남기기 위해, 다음 노드부터 검색
            Node<E> ptr2 = ptr.next; // 기존: Node<E> ptr2 = ptr
            // Node<E> pre = ptr;

            /* [    x(ptr)  ptr2  y   z  ] */

//          2. 검색 루프
            while (ptr2 != head) { // 기존: while (pre.next != head)
                // ptr2 = pre.next; 뒷단으로 이동

//              3. 중복 노드 발견 시 삭제
                if (c.compare(ptr.data, ptr2.data) == 0) {
                    Node<E> temp = ptr2.next; // 노드 삭제 전 현 노드의 next 저장
                    remove(ptr2);             // 중복 노드 삭제
                    ptr2 = temp;              // 저장해둔 노드로 ptr2 업데이트

//              미발견 시 다음 노드로 ptr2 설정
                } else {
                    ptr2 = ptr2.next;
                }
            }  // 내부 while 루프 끝

//          4. 다음 중복 검사 대상으로 넘어간다.
            ptr = ptr.next;

        }
//      5. 작업 완료 후 선택 노드 업데이트
        crnt = head;
    }

    /*--- Q10. head부터 n개 뒤 노드의 데이터에 대한 참조 반환 ---*/
    public E retrieve(int n) {
        Node<E> ptr = head.next;

//      노드 이동
        while (ptr != head) {
//          목표 지점 도달
            if (n-- == 0) {
                crnt = ptr;
                return ptr.data;
            }
//          다음 노드로 이동
            ptr = ptr.next;
        }
        return null;
    }
}
