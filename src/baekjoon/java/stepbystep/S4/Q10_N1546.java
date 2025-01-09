package baekjoon.java.stepbystep.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10_N1546 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());
            int[] subs = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = 0;

            for (int i = 0; i < subs.length; i++) {
                subs[i] = Integer.parseInt(st.nextToken());
                M = subs[i] > M ? subs[i] : M;
            }

            float sum = 0;

            for (int sub : subs) {
                sum += (float)sub / M * 100;
            }

            System.out.println(sum / N);
        }
    }
}
