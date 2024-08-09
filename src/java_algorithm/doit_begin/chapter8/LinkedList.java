package java_algorithm.doit_begin.chapter8;

import java.util.Comparator;

public class LinkedList<E> {

    class Node<E> {
        private E data;
        private Node<E> next;


        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    /*-----연결리스트-----*/
    private Node<E> head;
    private Node<E> crnt;

    public LinkedList() {
        head = crnt = null;
    }

    /*
    * head == null      -> 노드가 하나도 없다. 빈 연결 리스트
    * head.next == null -> 헤드 노드 다음이 없다. 노드가 하나인 연결 리스트
    * head.next.next == null -> 헤드 노드 다다음 노드가 없다. 노드가 두 개인 연결 리스트
    * p.next == null -> p가 테일 노드이다.
    *
    * */


    /* 노드 스캔의 종료 조건 */
    // 원하는 노드를 찾지 못한 채 꼬리 노드를 지나기 직전인 경우
    // 원하는 노드를 찾은 경우
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;

        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    // 머리 노드 삽입
    public void addFirst(E obj) {
        Node<E> ptr = head;
        head = crnt = new Node<E>(obj, ptr);
    }

    // 꼬리 노드 삽입
    public void addLast(E obj) {
        if (head == null)
            addFirst(obj);
        else {
            Node<E> ptr = head;
            while (ptr.next != null)
                ptr = ptr.next;
            ptr.next = crnt = new Node<E>(obj, null);
        }
    }

    // 머리 노드 삭제
    public void removeFirst() {
        if (head != null)
            head = crnt = head.next;
    }

    // 꼬리 노드 삭제
    public void removeLast() {
        if (head != null) {
            if (head.next == null)
                removeFirst();
            else {
                Node<E> ptr = head;
                Node<E> pre = head;

                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next =null;
                crnt = pre;
            }
        }
    }

    // 노드 p 삭제
    public void remove(Node p) {
        if (head != null) {
            if (p == head)
                removeFirst();
            else {
                Node<E> ptr = head;

                while (ptr.next != p) {
                    ptr = ptr.next;
                    if (ptr == null) return;
                }
                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    // 선택 노드 삭제
    public void removeCurrentNode() {
        remove(crnt);
    }

    // 모든 노드 삭제
    public void clear() {
        while (head != null)    // 머리 노드를 계속 삭제하며 밀어버리기
            removeFirst();
        crnt = null;
    }

    //TODO
    // Q1. 서로 같은 노드를 찾아 가장 앞쪽의 노드만 남기고 모두 삭제
    public void purge(Comparator<? super E> c) {
        Node<E> ptr1 = head;

        while (ptr1 != null) {
            Node<E> ptr2 = ptr1;
            Node<E> pre = ptr1;

            while (ptr2.next != null) {
                if (c.compare(ptr1.data, ptr2.next.data) == 0) {
                    ptr2.next = ptr2.next.next;
                } else {
                    pre = ptr2;
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }


    // Q2. 머리부터 n개 뒤의 노드에 대한 참조를 반환. n이 음수이거나 노드 개수보다 크거나 같으면 null 반환
    E retrieve(int n) {
        return null;
    }

    // 선택 노드를 하나 뒤로 진행
    public boolean next() {
        if (crnt == null || crnt.next == null)
            return false;       // 진행 불가
        crnt = crnt.next;
        return true;
    }

    // 선택 노드 출력
    public void printCurrentNode() {
        if (crnt == null)
            System.out.println("선택한 노드가 없습니다.");
        else
            System.out.println(crnt.data);
    }

    // 모든 노드 출력
    public void dump() {
        Node<E> ptr = head;

        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }



}

