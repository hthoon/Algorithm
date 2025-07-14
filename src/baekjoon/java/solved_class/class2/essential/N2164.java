package baekjoon.java.solved_class.class2.essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class N2164 {
    /**
     * 카드2 - Queue
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> cards = new ArrayDeque<>();

        /* 큐에 카드 추가 */
        for (int i = 1; i <= N; i++) {
            cards.offer(i);
        }

        /* 종료 조건: 카드가 1장 남았을 때 */
        while (cards.size() > 1) {
            /* 1. 맨 앞(위)의 카드 제거 */
            cards.poll();
            /* 2. 그 다음 카드를 맨 뒤(아래)에 추가 */
            cards.offer(cards.poll());
        }
        System.out.println(cards.peek());
    }
}