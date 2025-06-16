package baekjoon.java.solved_class.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2475 {
    /**
     * 검증수
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += mul(Integer.parseInt(st.nextToken()));
        }
        System.out.print(sum % 10);
    }

    private static int mul(int num) {
        return num * num;
    }
}
