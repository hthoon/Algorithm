package baekjoon.java.solved_class.class3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N17219 {
    /**
     * 비밀번호 찾기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /* ID, PW 저장 */
        Map<String, String> accounts = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            accounts.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            bw.write(accounts.get(br.readLine()));
            bw.newLine();
        }
        bw.flush();
    }
}
