package baekjoon.java.tier.silver.S1;

import java.io.*;
import java.util.*;

public class N2667 {
    /**
     * 단지번호
     */
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        boolean[][] danji = new boolean[N][N];

        // 격자 배열 단지
        for (int row = 0; row < N; row++) {
            char[] line = br.readLine().toCharArray();
            for (int col = 0; col < N; col++) {
                if (line[col] == '1') {
                    danji[row][col] = true;
                }
            }
        }

        // 총 단지 수 카운팅 변수, 단지 내 세대 수를 담을 리스트
        int totalDanjis = 0;
        List<Integer> unitsOfDanji = new ArrayList<>();

        /* BFS, DFS 어느 것을 쓰던 크게 상관 없다. 하지만 카운팅 변수 관리가 용이할 것 같아 BFS 선택 */
        boolean[][] visited = new boolean[N][N];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (danji[row][col] && !visited[row][col]) {
                    totalDanjis++;
                    unitsOfDanji.add(naming(danji, visited, row, col));
                }
            }
        }

        unitsOfDanji.sort(Integer::compare);

        System.out.println(totalDanjis);
        for (int units : unitsOfDanji) {
            System.out.println(units);
        }
    }

    /* 사방탐색 BFS */
    private static int naming(boolean[][] danji, boolean[][] visited, int startRow, int startCol) {
        int units = 0;

        visited[startRow][startCol] = true;
        units++;

        int[] directionRow = {-1, 1, 0, 0}; // 행 방향 탐색 - 상, 하
        int[] directionCol = {0, 0, -1, 1}; // 열 방향 탐색 - 좌, 우

        // 다음 행선지 큐
        Queue<Integer> next = new ArrayDeque<>();
        next.offer(encodeCoordinate(startRow, startCol, N));

        while (!next.isEmpty()) {
            int[] decodedCoordinate = decodeCoordinate(next.poll(), N);
            int currentRow = decodedCoordinate[0];
            int currentCol = decodedCoordinate[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + directionRow[i];
                int nextCol = currentCol + directionCol[i];

                // 경계 및 재방문 처리
                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;
                if (!danji[nextRow][nextCol] || visited[nextRow][nextCol]) continue;

                visited[nextRow][nextCol] = true;
                units++;
                next.offer(encodeCoordinate(nextRow, nextCol, N));
            }
        }
        return units;
    }

    // 좌표 인코딩
    private static int encodeCoordinate(int row, int col, int totalCol) {
        return row * totalCol + col;
    }

    // 좌표 디코딩
    private static int[] decodeCoordinate(int encodedCoordinate, int totalCol) {
        int decodedRow = encodedCoordinate / totalCol;
        int decodedCol = encodedCoordinate % totalCol;
        return new int[] {decodedRow, decodedCol};
    }
}
