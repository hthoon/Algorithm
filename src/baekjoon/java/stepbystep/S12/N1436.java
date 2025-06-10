package baekjoon.java.stepbystep.S12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1436 {
    /**
     * 영화감독 숌
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int th = 0;
        int num = 0;

        while (true) {
            /* i가 종말의 수인지 검사 */
            String target = String.valueOf(num);

            /* "666" 문자열을 포함하면 th 증가 */
            if (target.contains("666")) {
                th++;
            }

            /* th가 N과 일치하면 반복문 종료 */
            if (th == N) {
                System.out.println(target);
                return;
            }

            num++;
        }
    }
}
