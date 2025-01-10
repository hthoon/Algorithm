package baekjoon.java.stepbystep.S5;

import java.io.*;
import java.util.StringTokenizer;

public class Q8_N1152 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int count = 0;

            while (st.hasMoreTokens()) {
                st.nextToken();
                count++;
            }

            System.out.println(count);
        }
    }
}
