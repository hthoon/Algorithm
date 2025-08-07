package baekjoon.java.solved_class.class3.essential;

import java.io.*;

public class N1003 {
    /** TODO: 시간초과
     * 피보나치 함수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 1 <= N <= 40

        /*
        int fibonacci(int n) {
            if (n == 0) {
                printf("0");
                return 0;
            } else if (n == 1) {
                printf("1");
                return 1;
            } else {
                return fibonacci(n‐1) + fibonacci(n‐2);
            }
        }
        */

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            MyFibonacci myFibonacci = new MyFibonacci();
            myFibonacci.fibonacci(N);
            bw.write(myFibonacci.returnResult());
        }
        bw.flush();
    }

    public static class MyFibonacci {
        int count0 = 0;
        int count1 = 0;

        private int fibonacci(int n) {
            if (n == 0) {
                count0++;
                return 0;
            }
            else if (n == 1) {
                count1++;
                return 1;
            }
            else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }

        private String returnResult() {
            return count0 + " " + count1 + "\n";
        }
    }
}
