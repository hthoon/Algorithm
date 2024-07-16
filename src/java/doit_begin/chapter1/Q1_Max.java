package java.doit_begin.chapter1;

public class Q1_Max {

    public static void main(String[] args) {
        System.out.println(max4(1, 5, 3, 3));
    }

    static int max4(int a, int b, int c, int d) {
        int result = a;

        if (b > result) {
            result = b;
        }
        if (c > result ) {
            result = c;
        }
        if (d > result ) {
            result = d;
        }

        return result;
    }
}
