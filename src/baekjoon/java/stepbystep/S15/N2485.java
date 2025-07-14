package baekjoon.java.stepbystep.S15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2485 {
    /**
     * 가로수 - 최대공약수
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /* 나무들의 위치 */
        long[] trees = new long[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(br.readLine());
        }

        /* 나무들 사이의 거리 */
        long[] dist = new long[N - 1];
        for (int i = 0; i < N - 1; i++) {
            dist[i] = trees[i + 1] - trees[i];
        }

        /* 배열을 순회하며 거리의 최대공약수 구하기 */
        long gcd = dist[0];
        for (int i = 1; i < dist.length; i++) {
            gcd = getGcd(gcd, dist[i]);
        }

        /* 각 거리를 최대공약수로 나눠 나무의 수 구하기 */
        long result = 0;
        for (long i : dist) {
            result += i / gcd - 1;
        }

        System.out.println(result);
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

    private static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}