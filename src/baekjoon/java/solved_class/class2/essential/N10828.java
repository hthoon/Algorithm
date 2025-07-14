package baekjoon.java.solved_class.class2.essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10828 {
    /**
     * 스택
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /* 접근
        배열로 구현
        스택 자료구조는 top 포인터로 작동.
        * */

        int[] stack = new int[N];
        int top = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            /* push: top 위치에 값 삽입 후 포인터 증가 */
            if (command.startsWith("push")) {
                stack[top++] = (Integer.parseInt(command.split(" ")[1]));
                continue;
            }
            switch (command) {
                /* pop: top 감소 */
                case "pop":
                    sb.append(top == 0 ? -1 : stack[--top]);
                    break;
                /* size: top 크기 */
                case "size":
                    sb.append(top);
                    break;
                /* empty: top 0 여부로 판단 */
                case "empty":
                    sb.append(top == 0 ? 1 : 0);
                    break;
                /* top: top - 1 위치의 값 */
                case "top":
                    sb.append((top == 0 ? -1 : stack[top - 1]));
                    break;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}