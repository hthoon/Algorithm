package baekjoon.java.stepbystep.S5;

import java.io.*;

public class Q11_N11718 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringBuilder sb = new StringBuilder();
            String input;

            while ((input = br.readLine()) != null) {
                sb.append(input).append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
