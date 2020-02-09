public class homework1 {

    public static void main(String[] args) {
        task2();
        System.out.println("a * (b + (c / d)) = " + task3(10, 5, 20, 4));
        System.out.println(task4(19, 2));
        task5(-10);
        System.out.println("Число отрицательное? " + task6(-50));
        task7("читатель моего кода");
        task8(1000);
    }

        public static void task2(){
            System.out.println("Задание 2");
            int i = 1;
            boolean bul = true;
            char ch = '3';
            short sh = 2;
            long l = 33;
            double d = 5.654;
            float fl = 12345.0f;
            System.out.println("Значение для типа int = " + i);
            System.out.println("Значение для типа boolean = "+ bul);
            System.out.println("Значение для типа char = " + ch);
            System.out.println("Значение для типа short = " + sh);
            System.out.println("Значение для типа long = " + l);
            System.out.println("Значение для типа double = " + d);
            System.out.println("Значение для типа float = " + fl);
        }

        public static int task3(int a, int b, int c, int d) {
            System.out.println("\nЗадание 3");

            return a * (b + (c / d));
        }

        public static boolean task4(int a, int b) {
           System.out.println("\nЗадание 4");
           int sum = a + b;
           if (sum > 10 && sum <= 20)
               return true;
           else return false;
        }

        public static void task5(int number) {
            System.out.println("\nЗадание 5");
            if (number >= 0) System.out.println("Положительное");
                else System.out.println("Отрицательное");
        }

        public static boolean task6(int val) {
            System.out.println("\nЗадание 6");
                if (val < 0) return true;
                    else return false;

        }

        public static void task7(String name) {
            System.out.println("\nЗадание 7");
            System.out.println("Привет, " + name + "!");
        }

        public static void task8(int year) {
            System.out.println("\nЗадание 8");
            if (!(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0)))  System.out.println(year + " г. не високосный");
            else System.out.println(year + " г. високосный");
    }
}