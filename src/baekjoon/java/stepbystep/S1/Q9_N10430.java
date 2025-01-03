package baekjoon.java.stepbystep.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9_N10430 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.printf("%d\n%d\n%d\n%d", (A + B) % C, ((A % C) + (B % C)) % C, (A * B) % C, ((A % C) * (B % C)) % C);
    }
}
