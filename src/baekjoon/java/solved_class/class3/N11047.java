package baekjoon.java.solved_class.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11047 {
    /**
     * 동전 0
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 10
        int K = Integer.parseInt(st.nextToken()); // 1 <= K <= 100000000

        int[] wallet = new int[N];
        for (int i = 0; i < N; i++) {
            wallet[i] = Integer.parseInt(br.readLine());
        }

        /* 큰 액수의 동전부터 시작 */
        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            int coin = wallet[i];
            if (K / coin > 0) {
                count += K / coin;
                K %= coin;
            }
        }
        System.out.print(count);
    }
}
