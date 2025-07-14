package baekjoon.java.stepbystep.S15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1735 {
    /**
     * 분수 합 - 유클리드 호제법
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A1 = Integer.parseInt(st.nextToken());
        int B1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int A2 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());

        /* 분모의 최소공배수를 활용 */
        int commonB = (B1 * B2) / getGcd(B1, B2);
        int commonA = A1 * (commonB / B1) + A2 * (commonB / B2);

        /* 기약분수 조건 충족을 위해 최대공약수를 구하여 후처리 */
        int gcd = getGcd(commonA, commonB);
        commonA /= gcd;
        commonB /= gcd;

        System.out.printf("%d %d", commonA, commonB);
    }

    private static int getGcd(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        };
        if (a == 0) return b;
        return getGcd(b % a, a);
    }
}