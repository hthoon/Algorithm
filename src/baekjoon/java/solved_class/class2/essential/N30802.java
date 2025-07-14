package baekjoon.java.solved_class.class2.essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N30802 {
    /**
     * 웰컴 키트
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /* 티셔츠 사이즈 */
        int[] sizes = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 티 묶음
        int P = Integer.parseInt(st.nextToken()); // 펜 묶음

        /* 티셔츠 묶음 */
        int sBundle = 0;
        for (int size : sizes) {
            sBundle += (size + T - 1) / T;
        }

        /* 펜 묶음 */
        int pBundle = N / P;
        int pRemain = N % P;

        System.out.printf("%d\n%d %d", sBundle, pBundle, pRemain);
    }
}
