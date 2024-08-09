package java_algorithm.doit_begin.chapter8;

import java.util.Comparator;

public class Q7_CircularLinkedList<E> {

    /*--- 노드 ---*/
    class Node<E> {
        E data;
        Node<E> next;

        /*--- 1. 기존 생성자 ---*/
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        /*--- 2. 추가 생성자 ---*/
//		첫 번째 노드 생성 시 적합하다.
//		초기 생성 시, 자기 자신을 가리키는 노드를 만들 때 유용하다.
        Node(E data) {
            this.data = data;
            this.next = this;
        }

    }

    private Node<E> head;			// 머리 노드
    private Node<E> tail;			// 꼬리 노드
    private Node<E> crnt;			// 선택 노드

    /*--- 생성자 ---*/
    public Q7_CircularLinkedList() {
        head = tail = crnt = null;
    }

    /*--- 노드 검색 ---*/
    public E search(E obj, Comparator<? super E> c) {
        if (head != null) {
            Node<E> ptr = head;

            do {
                if (c.compare(obj, ptr.data) == 0) {
                    crnt = ptr;
                    return ptr.data;
                }
                ptr = ptr.next;
            } while (ptr != head);
        }
        return null;
    }

    /*--- head 노드 삽입 ---*/
    public void addFirst(E obj) {

//		1. head가 없는 빈 리스트인 경우, 자기 자신을 참조하는 head 노드를 생성한다.
        if (head == null)
            head = tail = crnt = new Node<E>(obj);

//		2. 노드가 존재하는 경우, 새로운 head 노드를 생성한 후 tail 노드가 이를 가리키도록 한다.
        else {
            Node<E> newNode = new Node<>(obj, head);
            tail.next = newNode;	// tail 노드가 새로운 head를 가리킨다.
            head = newNode;			// 새로운 head 노드
        }
    }

    /*--- tail 노드 삽입 ---*/
    public void addLast(E obj) {

//		1. addFirst와 동일하다.
        if (head == null) {
            head = tail = crnt = new Node<>(obj);
        }

//		2. head를 가리키는 tail 노드를 생성.
        else {
            Node<E> newNode = new Node<>(obj, head);
            tail.next = newNode;	// tail 노드가 새로운 tail을 가리킨다.
            tail = newNode;			// 새로운 tail 노드
        }
    }

    /*--- head 노드 삭제 ---*/
//	head를 삭제한 후, tail이 존재한다면
    public void removeFirst() {
//		1. 빈 리스트가 아닐 경우 메서드 실행
        if (head != null) {

//			2 - 1. 노드가 하나인 경우 포인터를 null로 초기화한다.
            if (head == tail) {
                head = tail = crnt = null;
            }

//			2 - 2. head.next가 새로운 head가 되며,
//			tail.next가 새로운 head를 가리키도록 한다.
            else {
                head = head.next;
                tail.next = head;
            }
        }
    }

    /*--- tail 노드 삭제 ---*/
//	tail을 삭제한 후, 새로운 tail의 next가 head를 가리키도록 한다.
    public void removeLast() {

//		1. 빈 리스트가 아닐 경우 메서드 실행
        if (head != null) {

//			2 - 1. removeFirst와 동일하다.
            if (head == tail) {
                head = tail = crnt = null;
            }

//			2 - 2. 포인터를 tail 노드 직전까지 이동시킨다.
            else {
                Node<E> ptr = head;
                while (ptr.next != tail) {
                    ptr = ptr.next;
                }

//				해당 노드를 새로운 tail 노드로 설정한다.
//				next는 head를 가리키도록 한다.
                ptr.next = head;
                tail = ptr;
            }
        }
    }

    /*--- 특정 노드를 삭제 ---*/
    public void remove(Node<E> p) {

//		1. 리스트가 비어있지 않으면,
        if (head != null) {

//			2. p가 head일 경우
            if (p == head) {
                removeFirst();
            }

//			3. p가 tail일 경우
            else if (p == tail) {
                removeLast();
            }

//			4. p 노드 직전까지 포인터를 이동하여 삭제
            else {
                Node<E> ptr = head;
                while (ptr.next != p) {
                    ptr = ptr.next;
//					실패 조건: 포인터가 다시 head에 도달한 경우
                    if (ptr == head) return;
                }

//				포인터가 p의 next를 가리키게 하여 삭제, crnt를 p의 이전 노드(ptr)로 설정
                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    /*--- 선택한 노드 삭제 ---*/
    public void removeCurrentNode() {
        remove(crnt);
    }

    /*--- 모든 노드 삭제 ---*/
//	모든 노드가 삭제될 때까지 removeFirst 메서드를 실행한다.
    public void clear() {

//		종료 조건: head 노드가 존재하지 않을 때까지
        while (head != null)
            removeFirst();

//		현재 노드를 초기화
        crnt = null;
    }

    /*--- 현재 노드를 하나 뒤로 이동 ---*/
    public boolean next() {
//		1. 더 이상 이동할 수 없는 상태면 false를 반환
//		현재 포인터가 null인 경우
        if (crnt == null)
            return false;

//		2. 이동 가능하면 next로 이동
        crnt = crnt.next;
        return true;
    }

    /*--- 현재 노드의 데이터 출력 ---*/
    public void printCurrentNode() {
//		1. 현재 노드가 비어있을 경우
        if (crnt == null)
            System.out.println("선택한 노드가 없습니다.");
//		2. 비어있지 않을 경우 데이터 출력
        else
            System.out.println(crnt.data.toString());
    }

    /*--- 모든 노드의 데이터 출력 ---*/
    public void dump() {

//		1. 리스트가 비어있지 않을 경우 실행
        if (head != null) {
            Node<E> ptr = head;

//			2. 리스트를 돌며 데이터 출력
            do {
                System.out.println(ptr.data.toString());
                ptr = ptr.next;
            } while (ptr != head);
        }
    }

    /*--- comparator에 따라 중복되는 노드 삭제 ---*/
    public void purge(Comparator<? super E> c) {

//		1. 빈 리스트이면 종료
        if (head == null) return;

//		2. 기준 노드 포인터 ptr 선언
        Node<E> ptr = head;

        do {
            Node<E> ptr2 = ptr.next; // 현재 노드의 복사본. 탐색에 사용한다.

            /* [  ptr  ptr2  x   y   z  ] */

//			현재 노드 이후의 모든 노드를 검사.
            while (ptr2 != head) {

//				3. 중복 데이터를 가진 노드 발견 시 remove메서드 실행
                if (c.compare(ptr.data, ptr2.data) == 0) {
                    Node<E> temp = ptr2.next;
                    remove(ptr2);
                    ptr2 = temp;

//              미발견 시 다음 노드로 ptr2 설정
                } else {
                    ptr2 = ptr2.next;
                }
            } // 내부 while 루프 끝

//			4. 다음 중복 검사 대상으로 이동한다.
                ptr = ptr.next;

//		종료 조건: 다음 노드가 head일 때
        } while (ptr.next != head);

//      5. 작업 완료 후 선택 노드 업데이트
        crnt = head;
    }

    /*--- head에서 n개 뒤 노드의 데이터에 대한 참조를 반환 ---*/
    public E retrieve(int n) {

//		1. 빈 리스트가 아닌 경우 실행
        if (head != null) {
            Node<E> ptr = head;

//			2. 포인터를 n회 이동
            while (n >= 0) {
//				3. n이 0이 되면 crnt를 업데이트, 데이터를 반환한다.
                if (n-- == 0) {
                    crnt = ptr;
                    return ptr.data;
                }
                ptr = ptr.next;

//				실패 조건: 포인터가 head에 도달
                if (ptr == head) break;
            }
        }
        return null;
    }
}
