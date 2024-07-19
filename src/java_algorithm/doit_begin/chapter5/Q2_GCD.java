package java_algorithm.doit_begin.chapter5;

import java.util.Scanner;

public class Q2_GCD {

    static int gcd(int x, int y) {
            while (y != 0) { // 반복조건1: y가 0이 아닌 경우
                int temp = y;
                y = x % y;
                x = temp;
            }
        return x;
    }
    /*-----------------------------------------
    유클리드 호제법으로 x, y의 최대공약수 구하기
    1. x를 y로 나눈다.
    2. 1에서의 y는 x가 된다.----------- temp = y;
                                      x = temp;
       1에서의 나머지는 새로운 y가 된다.-- y = x % y
    3. y가 0이 될 때까지 반복한다.
       y가 0이 된다는 것은, 정사각형만 남은 것과 같다.
    4. 최대공약수 x를 반환한다.
    ------------------------------------------*/

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x;
        int y;

        do {
            System.out.print("x입력: ");
            x = input.nextInt();

            System.out.print("y입력: ");
            y = input.nextInt();
            input.nextLine();

            if (x <= 0)
                System.out.println("x는 양의 정수여야 합니다.");
            else if (y < 0)
                System.out.println("y는 0 이상의 정수여야 합니다.");
        } while (x <= 0 || y < 0);

        System.out.printf("%d, %d의 최대공약수는 %d입니다.", x, y, gcd(x, y));
    }
}
