package baekjoon.java.solved_class.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1929 {
    /**
     * 소수 구하기 - 에라토스테네스의 체
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] notPrimes = getNotPrimes(N + 1);
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!notPrimes[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }

    /* 에라토스테네스의 체 */
    private static boolean[] getNotPrimes(int n) {
        /* 주의: boolean 배열 초기값은 false
        *  false: 소수, true: 합성수 */
        boolean[] isNotPrimes = new boolean[n + 1];

        /* 0, 1은 소수 X */
        isNotPrimes[0] = isNotPrimes[1] = true;

        /*
        i는 2부터 루트 √n까지.
        기존 소수 찾기 로직의 범위와 동일하다.
        */
        int range = (int) Math.sqrt(n);
        for (int i = 2; i <= range ;i++) {
            /* 제거되지 않은 수 발견 시 작동 */
            if (!isNotPrimes[i]) {
                /*
                i * i부터 배수 제거 시작.
                이유: i * (i - 1)까지의 수는 이전 단계에서 처리된다.
                예: i = 5일 때, 5 * (2, 3, 4)는 i = (2, 3, 4) 단계에서 이미 처리됨.
                */
                for (int j = i * i; j <= n; j += i) {
                    isNotPrimes[j] = true;
                }
            }
        }
        return isNotPrimes;
    }
}
