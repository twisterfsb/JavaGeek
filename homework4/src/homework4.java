import java.util.Random;
import java.util.Scanner;

public class homework4 {
    private static final int SIZE_X = 5; // размер поля по оси X
    private static final int SIZE_Y = 5; // размер поля по оси Y
    private static final char PLAYER_DOT = 'X'; // маркер игрока
    private static final char AI_DOT = 'O'; // маркер компьютера
    private static final char EMPTY_DOT = '*';
    private static final int TO_WIN = 4; // количество в линию для победы

    private static char[][] field = new char[SIZE_Y][SIZE_X]; // задаем массив игрового поля поля

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    //заполняем поле пустыми маркерами
    public static void initFields() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }
        // рисуем поле
    public static void printField() {
        System.out.println("_______________\n");
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print(" ");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("\n_______________");
    }

    public static void setSym(int y, int x, char sym) {
        field[y][x] = sym;
    }

    //ход игрока
    public static void playerStep() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты: X (от 1 до " + SIZE_X + ")   Y  (от 1 до " + SIZE_Y + ")");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x));
        setSym(y, x, PLAYER_DOT);
    }

    // ход компьютера
    public static void aiStep() {
        //ищем выигрышный ход компьютера
        for (int i = 0; i < SIZE_Y; i++)
            for (int j = 0; j < SIZE_X; j++) {
                if (isCellValid(i, j)) {
                    setSym(i, j, AI_DOT);
                    if (checkWin(AI_DOT)) return;
                    setSym(i, j, EMPTY_DOT);
                }
            }
        //Проверяем будет ли следующий ход игрока победным
        for (int i = 0; i < SIZE_Y; i++)
            for (int j = 0; j < SIZE_X; j++) {
                if (isCellValid(i, j)) {
                    setSym(i, j, PLAYER_DOT);
                    if (checkWin(PLAYER_DOT)) {
                        setSym(i, j, AI_DOT);
                        return;
                    }
                    setSym(i, j, EMPTY_DOT);
                }
            }
        //Если следующий ход не выигрышный, то ставим на рандомное свободное поле
        int x;
        int y;
        do {
            x = random.nextInt(SIZE_X);
            y = random.nextInt(SIZE_Y);
        } while (!isCellValid(y, x));
        setSym(y, x, AI_DOT);
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
            return false;
        }
        return field[y][x] == EMPTY_DOT;
    }

    public static boolean isFuelFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    // проверка на победу
    private static boolean checkWin(char sym) {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (checkLine(i, j, 0, 1,  sym)) return true;   // проверим линию по х
                if (checkLine(i, j, 1, 1,  sym)) return true;   // проверим по диагонали х у
                if (checkLine(i, j, 1, 0,  sym)) return true;   // проверим линию по у
                if (checkLine(i, j, -1, 1, sym)) return true;  // проверим по диагонали х -у
            }
        }
        return false;
    }

    // проверка линии
    private static boolean checkLine(int y, int x, int vy, int vx, char sym) {
        int wayX = x + (TO_WIN - 1) * vx;
        int wayY = y + (TO_WIN - 1) * vy;
        if (wayX < 0 || wayY < 0 || wayX > SIZE_X - 1 || wayY > SIZE_Y - 1) return false;
        for (int i = 0; i < TO_WIN; i++) {
            int itemY = y + i * vy;
            int itemX = x + i * vx;
            if (field[itemY][itemX] != sym) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        initFields();
        printField();

        while (true) {
            playerStep();
            printField();
            if (checkWin(PLAYER_DOT)) {
                System.out.println("Поздравляю, кожаный мешок!");
                break;
            }
            if (isFuelFull()) {
                System.out.println("Хммм, ничья...");
                break;
            }

            aiStep();
            printField();
            if (checkWin(AI_DOT)) {
                System.out.println("Превосходство кремниевой формы жизни очевидно!");
                break;
            }
            if (isFuelFull()) {
                System.out.println("Хммм, ничья...");
                break;
            }
        }
    }
}
