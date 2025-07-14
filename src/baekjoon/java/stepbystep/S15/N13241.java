package baekjoon.java.stepbystep.S15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N13241 {
    /**
     * 최소공배수 - 유클리드 호제법
     * <br>
     * <br>
     * <strong>유클리드 호제법</strong>
     * <br>
     * 두 수를 나눈 나머지를 <strong>r</strong>이라고 할 때, 두 수 중 작은 수과 r의 최대공약수는 두 수의 최대공약수와 같다. <br>
     * 이 과정을 반복하다 나머지가 0이 될 때 나누는 수가 두 수의 최대공약수다.
     * <br>
     * 두 수 a와 b가 있을 때, (a > b) <br>
     * r = a % b -> GCD(b, r) = GCD(a, b) -> GCD(a, b) = GCD(b, a % b)
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        /*
         * 최대공약수: GCD
         * 최소공배수: LCM
         *
         * LCM: a * b / GCD(a, b)
         */
        System.out.println((A * B) / getGcd(A, B));
    }

    private static long getGcd(long a, long b) {
        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        };
        if (a == 0) return b;
        return getGcd(b % a, a);
    }
}