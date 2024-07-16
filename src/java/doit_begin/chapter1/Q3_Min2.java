package java.doit_begin.chapter1;

public class Q3_Min2 {

    public static void main(String[] args) {
        System.out.println(min4(3125, 34161, 1233, 10));
    }

    static int min4(int a, int b, int c, int d) {
        int result = a;

        if (b < result) {
            result = b;
        }
        if (c < result ) {
            result = c;
        }
        if (d < result ) {
            result = d;
        }

        return result;
    }
}
