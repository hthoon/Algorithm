package java_algorithm.doit_begin.chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q15_VisionSort {

    static class PhyscData {
        String name;
        int height;
        double vision;

        /*--------생성자--------*/
        PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        /*--------데이터를 문자열로 변환--------*/
        public String toString() {
            return name + " " + height + " " + vision;
        }



        /*--------키의 오름차순 comparator--------*/
        static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
        private static class HeightOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData data1, PhyscData data2) {
                return (data1.height > data2.height) ? 1 :
                        (data1.height < data2.height) ? -1 : 0;
            }
        }



        /*--------시력의 내림차순 comparator--------*/
        static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();
        private static class VisionOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData data1, PhyscData data2) {
                return (data1.vision < data2.vision) ? 1 :
                        (data1.vision > data2.vision) ? -1 : 0;
            }
        }



        public static void main(String[] args) {
            Scanner stdIn = new Scanner(System.in);
            PhyscData[] x = {
                new PhyscData("강민하", 162, 0.3),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("박준서", 175, 2.0),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("이수연", 168, 0.4),
                new PhyscData("장경오", 174, 1.2),
                new PhyscData("황지안", 169, 0.8),
                new PhyscData("현태훈", 175, 0.1),
            };

            /*
            Arrays.sort(x, PhyscData.HEIGHT_ORDER);
            키 순으로 정렬되지만, 시력에 대해서는 정렬이 이루어지지 않음.
            ==> 불안정정렬
            */

            // 시력 내림차순으로 정렬
            Arrays.sort(x, PhyscData.VISION_ORDER);

            for (PhyscData data : x) {
                System.out.println(data);
            }


        }








    }
}
