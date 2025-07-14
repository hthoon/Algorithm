package baekjoon.java.solved_class.class2.essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9012 {
    /**
    * 괄호
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            isVPS(br.readLine());
        }
    }

    /*
    ** 접근 **
    "("의 수만큼 ")"가 나와야 한다.
    1. ( 수만큼 count 증가
    2. ) 수만큼 count 감소

    ** VPS가 아닌 경우 **
    count > 0인데 (가 나오는 경우
    */
    private static void isVPS(String input) {

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            /* 아닌 경우: 연속된 (보다 많은 수의 연속 ) 등장 */
            if (c == ')' && count == 0) {
                System.out.println("NO");
                return;
            }
            else if (c == '(') {
                count++;
            }
            else if (c == ')') {
                count--;
            }
        }

        /* VPS: 종료 조건에 걸리지 않고, count == 0 */
        System.out.println((count == 0) ? "YES" : "NO");
    }
}