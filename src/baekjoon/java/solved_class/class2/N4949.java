package baekjoon.java.solved_class.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class N4949 {
    /**
     * 균형잡힌 세상 - Stack
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 풀이
        * 핵심: 스택, 플래그
        * 스택에는 열린 괄호가 담긴다.
        * 탐색한 닫힌 괄호는 pop 결과와 매치 되어야 한다.
        *
        * 주의: NPE, 조건 충족 검사 시 빈 스택인지 검사 필요
        * */

        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            /* 종료 조건 */
            if (line.equals(".")) {
                break;
            }

            /* 검사 */
            Deque<Character> pars = new ArrayDeque<>();
            boolean flag = true;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                /* 여는 괄호는 push */
                if (c == '(' || c == '[') {
                    pars.push(c);
                }
                /* 닫는 괄호는 pop */
                else if (c == ')' || c == ']') {
                    /* 주의: NPE */
                    if (pars.isEmpty()) {
                        flag = false;
                        break;
                    }
                    /* 검사 */
                    char top = pars.pop();
                    if (c == ')' && top != '(') {
                        flag = false;
                        break;
                    }
                    else if (c == ']' && top != '[') {
                        flag = false;
                        break;
                    }
                }
            }
            /* 주의: 빈 스택 검사 필요 */
            if (flag && pars.isEmpty()) {
                sb.append("yes\n");
            }
            else {
                sb.append("no\n");
            }
        }
        System.out.print(sb);
    }
}
