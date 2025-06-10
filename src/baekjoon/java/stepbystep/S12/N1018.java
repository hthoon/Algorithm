package baekjoon.java.stepbystep.S12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1018 {
    /**
     * 체스판 다시 칠하기
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 렬

        /* 초기 보드 배열 */
        boolean[][] board = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) == 'B';
            }
        }
        System.out.println(calSpace(board, N, M));
    }

    private static int calSpace(boolean[][] board, int row, int col) {
        int result = Integer.MAX_VALUE;
        /* 시작 행 */
        for (int i = 0; i <= row - 8; i++) {
            /* 시작 열 */
            for (int j = 0; j <= col - 8; j++) {
                int countF = 0;
                int countT = 0;

                /* 검사 시작 행 인덱스 */
                for (int k = 0; k < 8; k++) {
                    /* 검사 시작 열 인덱스 */
                    for (int x = 0; x <  8; x++) {
                        // 각 조건에 따라 결괏값 증가
                        boolean checkF = ((k + x) % 2 == 1); // false 시작 시 기댓값
                        boolean checkT = ((k + x) % 2 == 0); // true 시작 시 기댓값
                        if (board[(i + k)][j + x] != checkF) {
                            countF++;
                        }
                        if (board[(i + k)][j + x] != checkT) {
                            countT++;
                        }
                    }
                }
                /* 결과 기록 */
                result = Math.min(result, Math.min(countF, countT));
            }
        }
        return result;
    }
}
