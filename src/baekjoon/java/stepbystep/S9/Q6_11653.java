package baekjoon.java.stepbystep.S9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.ArrayList;

public class Q6_11653 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 시간 초과 해결: 아리스토테네스의 채 응용
        for (int i = 2; i <= N; i++) {
            if (N == 1) {
                break;
            }

            while (N % i == 0) {
                N /= i;
                System.out.println(i);
            }
        }
    }

//    private static void primeFact(int N, ArrayList<Integer> primes) {
//
//        // 작은 소인수부터 오름차순으로, 계속 나눈다.
//        for (int prime : primes) {
//
//            // 종료 조건: 나누려는 수가 1이다.
//            if (N == 1) {
//                break;
//            }
//            // 소인수로 나눈다. 나눠지지 않으면 다음 소인수로 넘어간다.
//            while ((N % prime) == 0) {
//                N /= prime;
//                System.out.println(prime);
//            }
//        }
//    }

//    // 시간 초과 해결: N이 나눠지는 한계까지만 저장
//    // 10000000 기준 2.4초 -> 0.9초
//    private static ArrayList<Integer> getPrime(int N) {
//
//        ArrayList<Integer> primes = new ArrayList<>();
//
//        for (int i = 2; i <= N / 2; i++) {
//            int sqrt = (int) Math.sqrt(i);
//
//            boolean isPrime = true;
//
//            for (int j = 2; j <= sqrt; j++) {
//                if (i % j == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//            if (isPrime) {
//                primes.add(i);
//            }
//        }
//
//        return primes;
//    }
}
