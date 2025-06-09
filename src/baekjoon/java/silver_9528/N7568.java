package baekjoon.java.silver_9528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N7568 {
    /**
     * 덩치 - 브루트 포스
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] humans = new int[N][2];

        // 사람 집단
        for (int i = 0; i < N; i++) {
            String[] human = br.readLine().split(" ");

            humans[i][0] = Integer.parseInt(human[0]);
            humans[i][1] = Integer.parseInt(human[1]);
        }

        int[] rankList = new int[N];

        for (int i = 0; i < N; i++) {
            // 비교 대상자 정보
            int weight = humans[i][0];
            int height = humans[i][1];

            // 덩치 순위를 1로 두고 시작한다.
            int rank = 1;

            for (int j = 0; j < N; j++) {
                // 자기 자신이면 넘어가기
                if (i == j) {
                    continue;
                }

                // 덩치 비교: 0, 1 인덱스의 값을 각각 비교
                if (weight < humans[j][0] && height < humans[j][1]) {
                    rank++;
                }
            }

            rankList[i] = rank;
        }

        StringBuilder sb = new StringBuilder();

        for (int rank : rankList) {
            sb.append(rank).append(" ");
        }

        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}
