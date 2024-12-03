package org.example;

public class Main {

//    public static void main(String[] args) {
//
//        int rowLength = 30;
//        int colLength = 33;
//        int value = 1;
//        int searchValue = 990;
//
//        int[][] arr = new int[rowLength][colLength];
//
//        for (int i = 0; i < rowLength; i++) {
//            for (int j = 0; j < colLength; j++) {
//                arr[i][j] = value;
//                value++;
//                if (value - 1 == searchValue) {
//                    System.out.println(true);
//                    return;
//                }
//            }
//        }
//    }

    public static void main(String[] args) {

        int[][] arr = new int[4][4];
        int value = 24;

        arr[0][0] = 2;
        arr[0][1] = 4;
        arr[0][2] = 7;
        arr[0][3] = 9;
        arr[1][0] = 10;
        arr[1][1] = 12;
        arr[1][2] = 18;
        arr[1][3] = 20;
        arr[2][0] = 21;
        arr[2][1] = 24;
        arr[2][2] = 27;
        arr[2][3] = 29;
        arr[3][0] = 30;
        arr[3][1] = 33;
        arr[3][2] = 35;
        arr[3][3] = 40;

        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == value) {
                    System.out.println(true);
                    return;
                }
            }
        }
    }



    public class temp {

        public static void main(String... args) throws Exception {
            int[] flags = new int[]{1, 2, 3, 4, 6};
            int l = 7;
            System.out.println(timeToMeet(flags, l));

        }

        private static double timeToMeet(int[] flags, int l) {
            double left = 0;
            double right = l;
            while (true) {
                double middle = (left + right) / 2;
                double time1 = calcTime1(left, flags);
                double time2 = calcTime2(middle, flags, l);
                double time11 = calcTime1(middle, flags);
                double time22 = calcTime2(right, flags, l);

                if (Math.abs(time1 - time2) < Math.abs(time11 - time22)){
                    right = middle;
                } else {
                    left = middle;
                }
                if (Math.abs(time1 - time2) < 0.01){
                    return time1;
                }
            }
        }

        private static double calcTime1(double endPoint, int[] allPoints) {
            int speed = 1;
            double time = 0;
            int prevPoint = 0;
            for (int i = 0; allPoints[i] <= endPoint; i++) {
                int point = allPoints[i];
                time = time + (double) (point - prevPoint) / speed++;
                prevPoint = point;
            }
            double additionalTime = (endPoint - prevPoint) / speed;
            time += additionalTime;
            return time;
        }

        private static double calcTime2(double endPoint, int[] allPoints, int allDistance) {
            int speed = 1;
            double time = 0;
            int prevPoint = allDistance;
            for (int i = allPoints.length - 1; endPoint <= allPoints[i]; i--) {
                int point = allPoints[i];
                time = time + (double) (prevPoint - point) / speed++;
                prevPoint = point;
            }
            double additionalTime = (prevPoint - endPoint) / speed;
            time += additionalTime;
            return time;
        }
    }
}