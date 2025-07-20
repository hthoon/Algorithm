package baekjoon.java.solved_class.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N28702 {
    /**
     * FizzBuzz
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 숫자 입력값만 저장 */
        int num = 0;
        int numIdx = 0;
        for (int i = 0; i < 3; i++) {
            String line = br.readLine();
            if (!line.startsWith("Fizz") && !line.startsWith("Buzz")) {
                numIdx = i;
                num = Integer.parseInt(line);
                break;
            }
        }

        /* 다음에 올 숫자 저장 */
        while (numIdx < 3) {
            num++;
            numIdx++;
        }

        /* 판별 */
        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("FizzBuzz");
        }
        else if (num % 3 == 0) {
            System.out.println("Fizz");
        }
        else if (num % 5 == 0) {
            System.out.println("Buzz");
        }
        else {
            System.out.println(num);
        }
    }
}
