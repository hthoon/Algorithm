package baekjoon.java.tier.bronze.B1;

import java.io.*;

public class N10769 {
    /**
     * 행복한지 슬픈지 - 이스케이프
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message = br.readLine();

        // 행복 :-), 슬픔 :-(
        int happy = message.split(":-\\)").length - 1;
        int sad = message.split(":-\\(").length - 1;

        if (happy == 0 && sad == 0) {
            System.out.print("none");
        }
        else if (happy == sad) {
            System.out.print("unsure");
        }
        else {
            System.out.print(happy > sad ? "happy" : "sad");
        }
    }
}
