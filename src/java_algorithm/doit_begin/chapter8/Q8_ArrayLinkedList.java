package java_algorithm.doit_begin.chapter8;

import java.util.Comparator;

public class Q8_ArrayLinkedList<E> {

    /*--- 노드 ---*/
    class Node<E> {
        private E data;			// 데이터
        private int next;		// 리스트의 뒤쪽 포인터
        private int dnext;	    // 프리 리스트의 뒤쪽 포인터

        /*--- data와 next를 설정 ---*/
        void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E>[] n;	          	// 리스트 본체
    private int size;		    		// 리스트의 용량(최대 데이터수)
    private int max;			    	// 사용 중인 꼬리 레코드
    private int head;		    		// 머리 노드
    private int tail;		    		// 꼬리 노드 추가
    private int crnt;		    		// 선택 노드
    private int deleted;	        	// 프리 리스트의 머리 노드
    private static final int NULL = -1;	// 다음 노드가 없음/리스트가 가득 참

    /*--- 생성자 ---*/
    /*--- capacity 길이의 리스트 정의 ---*/
    public Q8_ArrayLinkedList(int capacity) {
        head = tail = crnt = max = deleted = NULL;
        try {
            n = new Node[capacity];
            for (int i = 0; i < capacity; i++)
                n[i] = new Node<E>();
            size = capacity;
        }
        catch (OutOfMemoryError e) {		// 배열의 생성에 실패
            size = 0;
        }
    }

    //--- 새로 삽입할 레코드의 인덱스 구하기 ---//
    private int getInsertIndex() {
//      1. 프리리스트의 레코드가 비어 있는 경우
        if (deleted == NULL) {
//          1 - 1. 용량이 남았다면 max + 1 반환
            if (max < size)
                return ++max;
//          1 - 2. 용량이 부족하면 NULL 반환
            else
                return NULL;

//      2. 프리리스트에 레코드가 있는 경우
        } else {
//          2 - 1. 프리리스트에서 인덱스를 가져오고, head를 새로 업데이트한다.
            int rec = deleted;
            deleted = n[rec].dnext;
            return rec;
        }
    }

    /*--- 레코드idx를 프리 리스트에 등록 ---*/
    private void deleteIndex(int idx) {

//      1. 프리 리스트가 비어 있는 경우
        if (deleted == NULL) {
//          1 - 1. head를 삭제된 레코드의 인덱스로 설정
            deleted = idx;
            n[idx].dnext = NULL;
//      2. 프리 리스트가 비어 있지 않은 경우
        } else {
//          2 - 1. head에 인덱스를 삽입하고, 기존 head를 dnext로 업데이트
            int rec = deleted;
            deleted = idx;
            n[idx].dnext = rec;
        }
    }

    /*--- 노드 검색 ---*/
    public E search(E obj, Comparator<? super E> c) {
        int ptr = head;

//      head부터 커서를 이동하며 검색
//      종료 조건: 다음 노드가 없을 때
        while (ptr != NULL) {

//          검색 성공 조건
            if (c.compare(obj, n[ptr].data) == 0) {
                crnt = ptr;
                return n[ptr].data;
            }
//          찾지 못할 경우, 커서를 다음으로 이동
            ptr = n[ptr].next;
        }
//      검색 실패 시 null 반환
        return null;
    }

    /*--- head 노드 삽입 ---*/
    public void addFirst(E obj) {

//      1. 리스트가 비었는지 확인
        boolean empty = (tail == NULL);
        int ptr = head;             // 기존 head
        int rec = getInsertIndex(); // 새 노드의 인덱스

//      2. head를 새 노드로 설정, 새 노드의 데이터와 다음 노드를 설정
        if (rec != NULL) {
            head = crnt = rec;
            n[head].set(obj, ptr);

//          3. 빈 리스트였다면 tail도 업데이트
            if (empty) tail = crnt;
        }
    }

    /*--- tail 노드 삽입 ---*/
    public void addLast(E obj) {
//      1. 빈 리스트면 addFirst 메서드 실행
        if (head == NULL)
            addFirst(obj);

//      2. 기존 tail의 next를 가져온 인덱스로 설정
//      이후 새 노드를 tail로 업데이트
        else {
            int rec = getInsertIndex();
            if (rec != NULL) {
                n[tail].next = crnt = rec;
                n[rec].set(obj, NULL);
                tail = rec;
            }
        }
    }

    /*--- head 노드 삭제 ---*/
    public void removeFirst() {
//      1. 리스트가 비어 있지 않으면 실행
        if (head != NULL) {

//          2. 새로운 머리 노드 설정
            int ptr = n[head].next;

//          3. 기존 head를 삭제, 프리리스트에 등록
            deleteIndex(head);

//          4. head를 새로운 노드로 설정
            head = crnt = ptr;

//          5. 리스트가 비어 있으면 tail을 NULL로 설정
            if (head == NULL) tail = NULL;
        }
    }

    /*--- tail 노드 삭제 ---*/
    public void removeLast() {

//      1. 리스트가 비어 있지 않으면 실행
        if (head != NULL) {

//          2. 노드가 하나뿐이면 removeFirst 메서드로 head 삭제
            if (n[head].next == NULL)
                removeFirst();

            else {
                int ptr = head;
                int pre = head;

//              3. tail 위치 탐색
                while (n[ptr].next != NULL) {
                    pre = ptr;
                    ptr = n[ptr].next;
                }

//              4. pre를 새로운 tail로 설정, 삭제된 노드를 프리리스트에 등록
                n[pre].next = NULL;
                deleteIndex(ptr);
                tail = crnt = pre;
            }
        }
    }

    /*--- 레코드 p 삭제 ---*/
    public void remove(int p) {

//      1. p가 head면 removeFirst, tail이면 removeLast 메서드 실행
        if (head != NULL) {
            if (p == head)
                removeFirst();
            else if (p == tail)
                removeLast();

//          2. 탐색하여 삭제
            else {
                int ptr = head;

//              p를 탐색하는 루프
                while (n[ptr].next != p) {
                    ptr = n[ptr].next;

//                  실패 조건: p가 없음
                    if (ptr == NULL) return;
                }

//              3. 여타 삭제 메서드와 같이 처리
                n[ptr].next = n[p].next;
                deleteIndex(p);
                crnt = ptr;
            }
        }
    }

    /*--- 현재 선택된 노드 삭제 ---*/
    public void removeCurrentNode() {
        remove(crnt);
    }

    /*--- 모든 노드 삭제 ---*/
    public void clear() {
//      1. head를 계속 삭제하며 모든 노드를 삭제
        while (head != NULL)
            removeFirst();

//      2. 삭제 후 현재 노드 초기화
        crnt = NULL;
    }

    /*--- 현재 선택 노드를 하나 뒤로 이동 ---*/
    public boolean next() {
//      1. 이동 불가 조건: 현재 포인터가 NULL을 가리키거나 다음으로 나아갈 수 없을 때
        if (crnt == NULL || n[crnt].next == NULL)
            return false;

//      2. 현재 노드를 next로 이동
        crnt = n[crnt].next;
        return true;
    }

    //--- 현재 선택 노드의 데이터 출력 ---//
    public void printCurrentNode() {

//      1. 선택 노드가 없으면 메시지 출력
        if (crnt == NULL)
            System.out.println("선택한 노드가 없습니다.");

//      2. 선택 노드의 데이터 출력
        else
            System.out.println(n[crnt].data.toString());
    }

    /*--- 모든 노드 출력 ---*/
    public void dump() {
        int ptr = head;

//      head부터 리스트의 끝까지 이동하며 데이터를 출력
        while (ptr != NULL) {
            System.out.println(n[ptr].data.toString());
            ptr = n[ptr].next;
        }
    }

    /*--- 중복 노드 삭제 ---*/
    public void purge(Comparator<? super E> c) {
        int ptr = head;

//      1. 리스트 순회 루프
        while (ptr != NULL) {

//          검사 대상은 ptr 노드 이후로 설정
            int ptr2 = n[ptr].next;

//          2. 중복 노드 탐색
            while (ptr2 != NULL) {

//              3. 중복 노드 발견 시 삭제
                if (c.compare(n[ptr].data, n[ptr2].data) == 0) {
                    int temp = n[ptr2].next; // 노드 삭제 전 현 노드의 next 저장
                    remove(ptr2);            // 중복 노드 삭제
                    ptr2 = temp;             // 저장해둔 노드로 ptr2 업데이트
                }
//              미발견 시 다음 노드로 ptr2 설정
                else {
                    ptr2 = n[ptr2].next;
                }
            }
//          4. 다음 중복 검사 대상으로 넘어간다.
            ptr = n[ptr].next;

        }
//      5. 작업 완료 후 선택 노드 업데이트
        crnt = head;
    }

    /*--- head부터 n개 뒤 노드의 데이터에 대한 참조를 반환 ---*/
    public E retrieve(int n) {
        int ptr = head;

//      1. 리스트가 비어있지 않을 때 실행
        while (n >= 0 && ptr != NULL) {

//          2. n회 이동 후, 선택 노드 업데이트 및 데이터를 반환한다.
            if (n-- == 0) {
                crnt = ptr;
                return this.n[ptr].data;
            }
//          3. 다음 노드로 이동
            ptr = this.n[ptr].next;
        }
        return null;
    }
}

