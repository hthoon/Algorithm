package baekjoon.java.solved_class.class2.essential;

import java.io.*;

public class N10845 {
    /**
     * 큐
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /* 접근
        배열로 구현
        큐 자료구조는 front, rear 포인터로 작동.
        * */

        int[] queue = new int[N];
        int front = 0;
        int rear = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            /* push: rear 포인터 위치에 값을 삽입 후 포인터 증가 */
            if (command.startsWith("push")) {
                queue[rear++] = Integer.parseInt(command.split(" ")[1]);
                continue;
            }
            switch (command) {
                /* pop: 인덱스 대상 값 출력 후 삭제 */
                case "pop":
                    sb.append((front == rear) ? -1 : queue[front++]);
                    break;
                /* front, rear 포인터 사이의 거리 */
                case "size":
                    sb.append(rear - front);
                    break;
                /* front 포인터 위치의 값 */
                case "front":
                    sb.append((front == rear) ? -1 : queue[front]);
                    break;
                /* rear 포인터 위치 - 1의 값 */
                case "back":
                    sb.append((front == rear) ? -1 : queue[rear - 1]);
                    break;
                /* 포인터 위치가 동일 여부 */
                case "empty":
                    sb.append(((front == rear) ? 1 : 0));
                    break;
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
