package baekjoon.java.tier.silver.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1926 {
    /**
     * 그림
     */
    static int rows;
    static int cols;
    static boolean[][] paper;
    static boolean[][] visited;
    static int paints = 0;
    static int area;
    static int maxArea = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken()); // 세로 - 행 개수
        cols = Integer.parseInt(st.nextToken()); // 가로 - 열 개수

        paper = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < cols; col++) {
                if (st.nextToken().equals("1")) {
                    paper[row][col] = true;
                }
            }
        }

        visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (paper[row][col] && !visited[row][col]) {
                    paints++;   // 그림 수 카운팅
                    area = 0;   // 그림 면적 초기화
                    findPaints(row, col);

                    // 최댓값과 비교
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        System.out.printf("%d\n%d", paints, maxArea);
    }

    private static void findPaints(int row, int col) {
        // 재방문 처리
        if (visited[row][col]) return;

        // 방문 처리
        visited[row][col] = true;
        area++;                    // 그림 면적 카운팅

        /* 경계 처리와 함께 탐색 */
        // 상
        int dt = row - 1;
        if (dt >= 0 && paper[dt][col] && !visited[dt][col]) {
            findPaints(dt, col);
        }

        // 하
        int dd = row + 1;
        if (dd < rows && paper[dd][col] && !visited[dd][col]) {
            findPaints(dd, col);
        }

        // 좌
        int dl = col - 1;
        if (dl >= 0 && paper[row][dl] && !visited[row][dl]) {
            findPaints(row, dl);
        }
        // 우
        int dr = col + 1;
        if (dr < cols && paper[row][dr] && !visited[row][dr]) {
            findPaints(row, dr);
        }
    }
}
