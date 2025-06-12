package baekjoon.java.stepbystep.S14;

import java.io.*;
import java.util.*;

public class N1764 {
    /**
     * 듣보잡
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> roster = new HashSet<>();
        for (int i = 0; i < N; i++) {
            roster.add(br.readLine());
        }

        int count = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (roster.contains(name)) {
                result.add(name);
                count++;
            }
        }
        /* 정렬 */
        Collections.sort(result);

        System.out.println(count);
        for (String s : result) {
            System.out.println(s);
        }
    }
}