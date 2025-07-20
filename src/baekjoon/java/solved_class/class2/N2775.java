package baekjoon.java.solved_class.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2775 {
    /**
     * 부녀회장이 될테야
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        /* 사람 수 배열 생성 및 재사용 */
        int[][] spaces = build();

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호

            System.out.println(spaces[k][n]);
        }

    }
    private static int[][] build() {
        /*
        입력 범위
        1 <= k, n <= 14

        1층 -> 1  3  6  10 15 21 28 36 45 55  66  78  91  105
        0층 -> 1  2  3  4  5  6  7  8  9  10  11  12  13  14   */

        /* 0층 존재 및 인덱스 차이 제거 위해 15 * 15 배열 사용 */
        int[][] spaces = new int[15][15];

        /* 0층 */
        for (int i = 1; i <= 14; i++) {
            spaces[0][i] = i;
        }

        /* 1층 ~ */
        for (int i = 1; i <= 14; i++) {
            int people = 0;
            for (int j = 1; j <= 14; j++) {
                people = people + spaces[i - 1][j];
                spaces[i][j] = people;
            }
        }
        return spaces;
    }
}
