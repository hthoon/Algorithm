package doit_begin.chapter1;

public class Q12_Plus {

    public static void main(String[] args) {
        System.out.println("  | 1  2  3  4  5  6  7  8  9");
        System.out.println("--+---------------------------");
        for (int i = 1; i <= 9; i++) {
            System.out.print(i + " |");
            for (int j = 1; j <= 9; j++) {
                System.out.print(" " + (i + j)); // 괄호 안 붙이면 단순 문자열 추가가 수행됨.
                if (i + j < 10) {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

}
