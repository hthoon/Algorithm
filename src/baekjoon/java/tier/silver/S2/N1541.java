package baekjoon.java.tier.silver.S2;

import java.io.*;

public class N1541 {
    /**
     * 잃어버린 괄호 - 그리디, 문자열 이스케이프
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();

        // 식은 숫자, +, -로 이루어짐.
        // 55-50+40

        /* 괄호를 적절히 쳐서 값을 최소로 만들어야 한다. */
        // 55-(50+40)

        // 처음 -가 나오면, 그 다음 -가 나올 때까지 전부 괄호치기?
        // -가 나온 시점부터 뒤의 숫자 전부 빼버리면 된다.

        // "-" 기준으로 문자열 분리
        String[] components = expression.split("-");

        // 첫 번째 문자열은 분해해서 더하면 된다.
        // 중요: +는 정규식 수량자이므로, 문자열 이스케이프가 필요하다.
        String[] components1 = components[0].split("\\+");
        int sum = 0;
        for (String s : components1) {
            sum += Integer.parseInt(s);
        }

        // 처음에 "-"로 분해된 뒤편의 식은 전부 빼준다.
        for (int i = 1; i < components.length; i++) {
            String[] ints = components[i].split("\\+");
            for (String sInt : ints) {
                sum -= Integer.parseInt(sInt);
            }
        }
        System.out.print(sum);
    }
}
