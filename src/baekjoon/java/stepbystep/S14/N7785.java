package baekjoon.java.stepbystep.S14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N7785 {
    /**
     * 회사에 있는 사람
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> people = new HashSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String record = st.nextToken();

            /* 마지막 기록이 enter인 사람만 Set에 남음 */
            if (record.equals("enter")) {
                people.add(name);
            }
            else {
                people.remove(name);
            }
        }

        List<String> result = new ArrayList<>(people);
        Collections.sort(result);
        Collections.reverse(result);

        for (String name : result) {
            System.out.println(name);
        }
    }
}