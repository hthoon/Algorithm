package baekjoon.java.solved_class.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N14626 {
    /**
     * ISBN
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ISBN = br.readLine();

        /* 마지막 숫자는 체크 기호이므로 12자리까지 누적 */
        int checkSum = 0;
        int damagedW = 0;
        for (int i = 0; i < ISBN.length() - 1; i++) {
            int target = ISBN.charAt(i);

            /* 훼손된 숫자 발견 시 가중치 저장 */
            if (target == '*') {
                damagedW = (i % 2 == 0 ? 1 : 3);
                continue;
            }
            else {
                target = target - '0';
            }

            /* 가중치 곱하여 누적 */
            if (i % 2 == 0) {
                checkSum += target;
            }
            else {
                checkSum += target * 3;
            }

        }
        /* 훼손된 숫자 유추 */
        int checkDigit = ISBN.charAt(12) - '0';

        for (int i = 0; i <= 9; i++) {
            /* (checkSum + damagedISBN * w + checkDigit) % 10 == 0 */
            if ((checkSum + i * damagedW + checkDigit) % 10 == 0) {
                System.out.print(i);
            }
        }
    }
}
