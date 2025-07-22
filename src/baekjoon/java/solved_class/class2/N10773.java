package baekjoon.java.solved_class.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class N10773 {
    /**
     * 제로
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        long sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());
            /* 입력된 정수가 0이면 가장 최근에 쓴 수를 삭제 */
            if (input == 0) {
                stack.pop();
            }
            /* 아닐 경우 해당 수를 쓰기 */
            else {
                stack.push(input);
            }
        }
        /* 합계 */
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.print(sum);
    }
}
