package baekjoon.java.solved_class.class2.essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1259 {
    /**
     * 팰린드롬수
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();

            /* 종료 조건 */
            if (s.equals("0")) return;
            char[] es = s.toCharArray();
            boolean result = true;

            for (int i = 0; i < es.length / 2; i++) {
                if (es[i] != es[es.length - 1 - i]) {
                    result = false;
                    break;
                }
            }

            if (result) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }
}
