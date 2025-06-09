package baekjoon.java.stepbystep.S11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N24313 {
/**
 * 시간복잡도 - 빅 오
 * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken()); // f(n)을 나타내는 0 ~ 100의 정수
        int a0 = Integer.parseInt(st.nextToken()); // f(n)을 나타내는 0 ~ 100의 정수
        int c = Integer.parseInt(br.readLine());  // 양의 정수
        int n0 = Integer.parseInt(br.readLine()); // 양의 정수

        /*
        모든 n0과 같거나 큰 n에 대하여, f(n)과 같거나 큰 c * g(n)인 양의 상수 c와 n0이 존재한다.
        -> f(n) <= c * g(n)  [n >= n0]
        -> a1 * n + a0 <= c * g(n)
        -> a1 * n + a0 <= c * n
        */

        /*
        * a1 > c이면 (c - a1)이 음수가 되므로 조건 추가
        * */
        if (a1 <= c && a1 * n0 + a0 <= c * n0) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}


