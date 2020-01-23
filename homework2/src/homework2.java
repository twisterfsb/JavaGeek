import java.util.Arrays;

public class homework2 {

    public static void main(String[] args) {
         t1();
         t2();
         t3();
         t4();
         t5();
        //t6();
    }
    public static void t1 (){
        System.out.println("\nЗадание 1");
        int N = 15;
        int[] a = new int[N];
        for (int i = 1; i < N; i += 3) {
            a[i] = 1;
        }
        System.out.println("Заполненный массив " + Arrays.toString(a));

        for (int j = 0; j < a.length; j++) {
            a[j] = (a[j] == 1) ? 0:1;
        }
        System.out.println("Новый массив " + Arrays.toString(a));
    }
    public static void t2 () {
        System.out.println("\nЗадание 2");
        int N = 8;
        int[] a = new int[N];
        for (int i = 1, j = 0; i < a.length; i++) {
            a[i] = j += 3;
        }
        System.out.println(Arrays.toString(a));
    }
    public static void t3 () {
        System.out.println("\nЗадание 3");
        int[] a = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Заданный массив "+ Arrays.toString(a));
        for (int i = 0; i < a.length; i++){
            if (a[i] < 6) a[i] *= 2;
        }
        System.out.println("Новый массив " + Arrays.toString(a));
    }
    public static void t4 () {
        System.out.println("\nЗадание 4");
        int N = 7;
        int[][] a = new int[N][N];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0, j2 = a[i].length; j < a[i].length; j++, j2--) {
                if (i == j || i == (j2 - 1)) a[i][j] = 1;
                System.out.print(a[i][j] + " | ");
            }
            System.out.println();
        }
    }
    public static void t5 () {
        System.out.println("\nЗадание 5");
        int[] a = {2, 23, 1, 5, 32, 2, 0, 8};
        int min = a[0], max = a[0], indexMax = 0, indexMin = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                indexMax = i;
            }
            if (a[i] < min) {
                min = a[i];
                indexMin = i;
            }
        }
        System.out.println("Max в индексе " + indexMax + " со значением  = " + max);
        System.out.println("Min в индексе " + indexMin + " со значением  = " + min);
    }
//    public static void t6 () {
//        System.out.println("\nЗадание 6");
//
//    }
}
