package baekjoon.java.solved_class.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N15829 {
    /**
     * Hashing
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        /* 접근
         * char로 변환된 문자열을 순회하며, 조건식에 맞게 계산
         * */
        long result = 0;
        for (int i = 0; i < L; i++) {
            /* char * mult(31, n)
            result += convert(input[i]) * fastMultWithMod(31, i); */
            /* 오버플로우 방지를 위해 모듈러 연산 */
            result = (result + convert(input[i]) * fastMultWithMod(31, i)) % 1234567891;
        }
        System.out.println(result);
    }

    /* a -> 1 */
    private static int convert(char alp) {
        return alp - 96;
    }

    /* 거듭제곱
    private static long mult(int a, int b) {
        if (b == 0) return 1;
        return a * mult(a, b - 1);
    }
     */

    /* 빠른 거듭제곱 + M 나누기 */
    private static long fastMultWithMod(long base, int exp) {
        long result = 1;
        long mod = 1234567891;
        while (exp > 0) {
            if (exp % 2 == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }
}
