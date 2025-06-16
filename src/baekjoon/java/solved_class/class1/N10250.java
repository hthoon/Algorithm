package baekjoon.java.solved_class.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N10250 {
    /**
     * ACM 호텔
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()); // 층
            int W = Integer.parseInt(st.nextToken()); // 호
            int N = Integer.parseInt(st.nextToken());

            /* 0층은 없다. 나누어 떨어지면 1층 */
            int floor = (N % H == 0) ? H : N % H;
            /* 마찬가지로 0호는 없다. 나누어 떨어지면 +1 */
            int room = (N % H == 0) ? N / H : N / H + 1;

            System.out.printf("%d%02d\n", floor, room);
        }
    }
}
