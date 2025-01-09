package baekjoon.java.stepbystep.S4;

import java.io.*;
import java.util.HashSet;

public class Q8_N3052 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            HashSet<Integer> set = new HashSet<>();

            for (int i = 0; i < 10; i++) {
                set.add(Integer.parseInt(br.readLine()) % 42);
            }

            bw.write(String.valueOf(set.size()));
            bw.flush();
        }
    }
}
