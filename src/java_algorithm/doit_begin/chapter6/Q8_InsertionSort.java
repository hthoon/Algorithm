package java_algorithm.doit_begin.chapter6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q8_InsertionSort {

    static void insertionSort(int[] array, int n) {
    /*------
    보초를 따로 초기화하지 않고, 0 그대로 둔다.
    ----> 보초의 의미가 퇴색되는가? 음수가 포함된다면 문제가 생길 수도 있겠다.
    이로써 아래의 종료 조건,
    1. j > 0
    2. array[j - 1] > temp
    둘 중 1번 조건을 제거하였다.         */

        // 첫 번째 요소는 보초이기 때문에, 시작점을 2로 설정한다.
        for (int i = 2; i < n; i++) {
            int j;
            int temp = array[i];

            // j > 0 조건을 삭제
            for (j = i; array[j - 1] > temp; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("보초법을 적용한 단순 삽입 정렬");
        System.out.print("요솟수: ");
        int n = stdIn.nextInt();

        // 보초를 두기 위해 n + 1 길이의 배열을 생성
        int[] array = new int[n + 1];

        // array[0]은 그대로 두고, n개의 요소 채우기
        for (int i = 1; i <= n; i++) {
            array[i] = rand.nextInt(array.length);
        }
        System.out.printf("초기 배열 -> %s\n", Arrays.toString(array));

        insertionSort(array, n + 1);

        System.out.printf("정렬 배열 -> %s\n", Arrays.toString(array));
    }
}