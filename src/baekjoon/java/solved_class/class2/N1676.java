package baekjoon.java.solved_class.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1676 {
    /**
     * 팩토리얼 0의 개수 - 수학적 원리
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /* 풀이
        * 문제1: 20!만 해도 long 오버플로우 발생
        * 문제2: 문자열 변환의 비효율
        * 문제3: 재귀 팩토리얼 스택오버플로우
        *
        * 해결 -> 요소에 10승이 존재할 때마다 조건을 충족하는 0의 수가 증가한다.
        * => 10의 소인수 2는 충분한 수가 존재하므로, 5의 배수의 개수만 구해도 된다.
        *
        * 주의: 단순 나누기 5를 해서는 안 된다.
        * 반례로 25가 있다.
        * 25 / 5 == 5지만, 실제로 25는 5 * 5이므로 두 번의 비중을 차지한다.
        * */

        int count = 0;
        while (N >= 5) {
            count += N / 5;
            N /= 5;
        }
        System.out.print(count);

        /* N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지의 0의 개수를 구하기 */
        /* 초기 풀이
        String factN = String.valueOf(factorial(N));

        boolean streak = false;
        int q = 0;
        for (int i = factN.length() - 1; i >= 0; i--) {
            if (factN.charAt(i) == '0') {
                streak = true;
                q++;
            }
            else if (streak && factN.charAt(i) != '0') {
                break;
            }
        }
        System.out.println(q);
        */
    }

    /*
    private static long factorial(long a) {
        if (a == 0) return 1;
        return a * factorial(a - 1);
    }*/
}
