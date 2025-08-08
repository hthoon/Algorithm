package baekjoon.java.solved_class.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N1874 {
    /**
     * 스택 수열
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        /*
        4 3 6 8 7 5 2 1
        일치하는 수가 나오면 pop
        */

        /* 완성할 수열 */
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        /* 새로 만들 수열 */
        Stack<Integer> numRow = new Stack<>();
        StringBuilder sb = new StringBuilder();

        /* 시작 */
        int numToPush = 1;    // push할 숫자
        int idx = 0;          // 수열 검사 인덱스

        /* 루프: 모든 숫자가 push 될 때까지, 스택에 값이 있는 동안 */
        while (numToPush <= n || !numRow.isEmpty()) {
            /* 수열 요소와 일치하는 수 발견 시 pop */
            if (!numRow.isEmpty() && numRow.peek() == seq[idx]) {
                numRow.pop();
                sb.append("-\n");
                idx++;
            }
            /* 아직 push할 숫자가 남았다면 push */
            else if (numToPush <= n) {
                numRow.push(numToPush);
                sb.append("+\n");
                numToPush++;
            }
            /* 수열 성립하지 않을 조건: push할 숫자가 없음 || 스택의 top이 수열 요소와 일치하지 않음 */
            else {
                System.out.print("NO");
                return;                 // early return
            }
        }
        System.out.print(sb);
    }
}