package java_algorithm.doit_begin.chapter8;

import java.util.Comparator;
import java.util.Scanner;

public class LinkedListTester {
    static Scanner stdIn = new Scanner(System.in);


    static class Data {
        static final int NO = 1;
        static final int NAME = 2;
        private Integer no;
        private String name;


        public String toString() {
            return "(" + no + ") " + name;
        }

        // 데이터 입력
        void scanData(String guide, int sw) {
            System.out.println(guide + "할 데이터를 입력");

            if ((sw & NO) == NO) {
                System.out.print("번호: ");
                no = stdIn.nextInt();
            }
            if ((sw & NAME) == NAME) {
                System.out.print("이름: ");
                name = stdIn.next();
            }
        }

        // 회원번호 순 comparator
        public static final Comparator<Data> NO_ORDER = new NoOrderComparator();

        private static class NoOrderComparator implements Comparator<Data> {
            public int compare(Data d1, Data d2) {
                return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0;
            }
        }

        // 이름 순 comparator
        public static final Comparator<Data> NAME_ORDER = new NameOrder();

        private static class NameOrder implements Comparator<Data> {
            public int compare(Data d1, Data d2) {
                return d1.name.compareTo(d2.name);
            }
        }
    }
    // 메뉴
    enum Menu {
        ADD_FIRST(  "머리에 노드 삽입"),
        ADD_LAST(   "꼬리에 노드 삽입"),
        RMV_FIRST(  "머리 노드 삭제"),
        RMV_LAST(   "꼬리 노드 삭제"),
        RMV_CRNT(   "선택 노드 삭제"),
        CLEAR(      "모든 노드 삭제"),
        SEARCH_NO(  "번호로 검색"),
        SEARCH_NAME("이름으로 검색"),
        NEXT(       "선택 노드를 하나 뒤쪽으로 진행"),
        PRINT_CRNT( "선택 노드 출력"),
        DUMP(       "모든 노드 출력"),
        TERMINATE(  "종료");

        private final String message;

        static Menu MenuAt(int idx) {
            for (Menu m: Menu.values())
                if (m.ordinal() == idx)
                    return m;
            return null;
        }

        Menu(String string) {
            message = string;
        }

        String getMessage() {
            return message;
        }
    }


    static Menu SelectMenu() {
        int key;
        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
                if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.TERMINATE.ordinal())
                    System.out.println();
            }
            System.out.print(" : ");
            key = stdIn.nextInt();
        } while (key < Menu.ADD_FIRST.ordinal() || key > Menu.TERMINATE.ordinal());
        return Menu.MenuAt(key);
    }


    public static void main(String[] args) {
        Menu menu;                                // 메뉴
        Data data;                                // 추가용 데이터 참조
        Data ptr;                                 // 검색용 데이터 참조
        Data temp = new Data();                   // 읽어 들일 데이터

        /*purge 메서드 확인*/
        LinkedList<Data> list1 = new LinkedList<>();      // 리스트 생성

        Data d1 = new Data();
        d1.no = 1; d1.name = "Alice";
        Data d2 = new Data();
        d2.no = 2; d2.name = "Bob";
        Data d3 = new Data();
        d3.no = 1; d3.name = "Alice";
        Data d4 = new Data();
        d4.no = 3; d4.name = "Charlie";
        Data d5 = new Data();
        d5.no = 2; d5.name = "Bob";

        list1.addLast(d1);
        list1.addLast(d2);
        list1.addLast(d3);
        list1.addLast(d4);
        list1.addLast(d5);

        // 리스트 출력 (중복 제거 전)
        System.out.println("중복 제거 전 리스트:");
        list1.dump();

        // 중복 제거
        list1.purge(Data.NO_ORDER);  // 번호 기준으로 중복 제거
        // list.purge(Data.NAME_ORDER);  // 이름 기준으로 중복 제거

        // 리스트 출력 (중복 제거 후)
        System.out.println("\n중복 제거 후 리스트:");
        list1.dump();

        LinkedList<Data> list = new LinkedList<Data>();      // 리스트 생성

        do {
            switch (menu = SelectMenu()) {

                case ADD_FIRST :                          // 머리 노드 삽입
                    data = new Data();
                    data.scanData("머리에 삽입", Data.NO | Data.NAME);
                    list.addFirst(data);
                    break;

                case ADD_LAST :                           // 꼬리 노드 삽입
                    data = new Data();
                    data.scanData("꼬리에 삽입", Data.NO | Data.NAME);
                    list.addLast(data);
                    break;

                case RMV_FIRST :                          // 머리 노드 삭제
                    list.removeFirst();
                    break;

                case RMV_LAST :                           // 꼬리 노드 삭제
                    list.removeLast();
                    break;

                case RMV_CRNT :                           // 선택 노드 삭제
                    list.removeCurrentNode();
                    break;

                case SEARCH_NO :                          // 회원 번호 검색
                    temp.scanData("검색", Data.NO);
                    ptr = list.search(temp, Data.NO_ORDER);
                    if (ptr == null)
                        System.out.println("그 번호의 데이터가 없습니다.");
                    else
                        System.out.println("검색 성공: " + ptr);
                    break;

                case SEARCH_NAME :                        // 이름 검색
                    temp.scanData("검색", Data.NAME);
                    ptr = list.search(temp, Data.NAME_ORDER);
                    if (ptr == null)
                        System.out.println("그 이름의 데이터가 없습니다.");
                    else
                        System.out.println("검색 성공: " + ptr);
                    break;

                case NEXT :                                // 선택 노드를 뒤쪽으로 진행
                    list.next();
                    break;

                case PRINT_CRNT :                          // 선택 노드의 데이터를 표시
                    list.printCurrentNode();
                    break;

                case DUMP :                                // 전체 노드를 리스트 순서대로 표시
                    list.dump();
                    break;

                case CLEAR :                               // 전체 노드를 삭제
                    list.clear();
                    break;
            }
        } while (menu != Menu.TERMINATE);
    }
}
