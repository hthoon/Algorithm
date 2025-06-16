package baekjoon.java.solved_class.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2920 {
    /**
     * 음계
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /* 첫 값으로 오름차순 판단 */
        int prev = Integer.parseInt(st.nextToken());
        boolean asc;

        if (prev == 1) {
            asc = true;
        }
        else if (prev == 8) {
            asc = false;
        }
        else {
            System.out.println("mixed");
            return;
        }

        for (int i = 0; i < 7; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (asc && next - 1 != prev) {
                System.out.println("mixed");
                return;
            }
            else if (!asc && next + 1 != prev) {
                System.out.println("mixed");
                return;
            }
            prev = next;
        }

        if (asc) {
            System.out.println("ascending");
        }
        else {
            System.out.println("descending");
        }
    }
}
