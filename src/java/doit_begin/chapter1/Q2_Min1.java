package java.doit_begin.chapter1;

public class Q2_Min1 {

    public static void main(String[] args) {
        System.out.println(min3(3, 124, 4));
    }

    static int min3(int a, int b, int c) {
        int result = a;
        if (b < result) {
            result = b;
        }
        if (c < result ) {
            result = c;
        }

        return result;
    }
}
