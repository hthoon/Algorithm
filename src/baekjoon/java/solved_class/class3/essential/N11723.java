package baekjoon.java.solved_class.class3.essential;

import java.io.*;
import java.util.StringTokenizer;

public class N11723 {
    /**
     * 집합
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        MySet mySet = new MySet();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            /* 명령에 따라 분기 */
            String command = st.nextToken();
            switch (command) {
                case "add": mySet.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove": mySet.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check": mySet.check(Integer.parseInt(st.nextToken()));
                    break;
                case "toggle": mySet.toggle(Integer.parseInt(st.nextToken()));
                    break;
                case "all": mySet.all();
                    break;
                case "empty": mySet.empty();
                    break;
            }
        }
        System.out.print(mySet.sb);
    }

    /* 인스턴스 메서드로 작동하는 MySet 클래스 */
    public static class MySet {
        /* boolean으로 존재 여부 판단 */
        boolean[] mySet = new boolean[21];
        StringBuilder sb = new StringBuilder(); // 결과를 담을 StringBuilder

        private void add(int x) {
            mySet[x] = true;
        }

        private void remove(int x) {
            mySet[x] = false;
        }

        private void check(int x) {
            sb.append(mySet[x] ? "1\n" : "0\n");
        }

        private void toggle(int x) {
            if (mySet[x]) {
                mySet[x] = false;
            }
            else {
                mySet[x] = true;
            }
        }

        private void all() {
            for (int i = 1; i < 21; i++) {
                mySet[i] = true;
            }
        }

        private void empty() {
            for (int i = 1; i < 21; i++) {
                mySet[i] = false;
            }
        }
    }
}
