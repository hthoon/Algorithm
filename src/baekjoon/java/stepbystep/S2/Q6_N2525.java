package baekjoon.java.stepbystep.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6_N2525 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());

        // 시간 계산 시 사용할 변수
        int sum = minute + time;

        if (sum >= 60) {
            hour += sum / 60;
            minute = sum % 60;
        }
        else {
            minute += time;
        }

        if (hour >= 24) {
            hour = hour % 24;
        }

        System.out.printf("%d %d", hour, minute);
    }
}
