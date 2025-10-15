package baekjoon.java.tier.silver.S4;

import java.io.*;

public class N4134 {
    /**
     * 다음 소수 - 에라토스테네스의 채
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            long n = Long.parseLong(br.readLine());
            answer.append(returnPrime(n)).append("\n");
        }
        System.out.print(answer);
    }

    private static long returnPrime(long n) {
        long prime = n;
        while (true) {
            if (isPrime(prime)) {
                return prime;
            }
            prime++;
        }
    }

    // i * i 범위, 홀수만 검사하여 빠르게 소수 판단
    private static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
