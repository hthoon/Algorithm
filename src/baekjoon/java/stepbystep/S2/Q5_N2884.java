package baekjoon.java.stepbystep.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5_N2884 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        if (minute < 45 && hour == 0) {
            hour = 23;
            minute += 15;
        }
        else if (minute < 45) {
            hour = hour - 1;
            minute += 15;
        }
        else {
            minute -= 45;
        }

        System.out.printf("%d %d", hour, minute);
    }
}
