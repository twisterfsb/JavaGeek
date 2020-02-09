import java.util.*;

public class homework3 {
    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Выберите игру:\n"+
                    "1. Угадай число\n2. Угадай слово\n3. Выход\nВыберите пункт меню: ");
            switch (sc.next()) {
                case "1":
                    guessTheNumber();
                    break;
                case "2":
                    guessTheWord();
                    break;
                default:
                    return;
            }
        }
    }

    public static void guessTheNumber() {
        do {
            int count = 0;
            int guess = -1;
            int number = random.nextInt(10);
            while (count < 5 && guess != number) {
                System.out.print(
                        "Угадай [" + (count + 1) + "] число от 0 до 9: ");
                try {
                    guess = sc.nextInt();
                    if (number == guess) {
                        System.out.println("Поздравляю, ты сделал бездушную машину. Тебе от этого легче?:P");
                    } else {
                        System.out.println("Загаданное число " + ((guess > number)?
                                "меньше" : "больше"));
                        count++;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Input Mismatch Exception!");
                    sc.next();
                }
            }
            if (count == 5)
                System.out.println("Ха! Кожаный мешок, проиграл!:D");
            System.out.print("Хочешь повторить?\n[1 - Да, конечно, в этот раз я тебя сделаю! \n 0 - Не, спасибо, хватит на сегодня унижений]: ");
        } while (sc.next().equals("1"));
    }

    public static void guessTheWord() {
        String[] words =  { "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "\ncarrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "\nnut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        //загадаем слово из массива
        String guess;
        String word = words[random.nextInt(words.length)];
        System.out.println("Я загадал слово из списка: ");
        System.out.println(Arrays.toString(words));
        do {
            System.out.print("Угадай слово: ");
            guess = sc.next();
            for (int i = 0; i < 15; i++)
                if (i < word.length() && i < guess.length() &&
                        word.charAt(i) == guess.charAt(i))
                    System.out.print(word.charAt(i));
                else
                    System.out.print((word.equals(guess))? "" : "#");
            System.out.println();
        } while (!word.equals(guess));
    }
}
