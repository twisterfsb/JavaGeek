import java.util.Random;

public class AI extends AGamer{

    // Экземпляр игрового поля
    MainGameField gameField;
    String playerSign = "";
    // Уровень интеллекта
    static int aiLevel = 0;
    private int SIZE;

    // Конструктор
    public AI(String sign, int aiLevel, String playerSign, int SIZE) {
        this.sign = sign;
        this.playerSign = playerSign;
        this.aiLevel = aiLevel;
        this.SIZE= SIZE;

    }

    // Выстрел компьютера
    boolean shot(int x, int y) {
        gameField = MainGameField.getInstance();
        x = -1;
        y = -1;
        boolean ai_win = false;
        boolean user_win = false;
        // Находим выигрышный ход
        if (aiLevel == 2)
        {
            for (int i = 0; i < SIZE; i++)
            {
                for (int j = 0; j < SIZE; j++)
                {
                    if (!gameField.isCellBusy(i, j))
                    {
                        gameField.cell[i][j] = sign;
                        if (gameField.checkWin(sign))
                        {
                            x = i;
                            y = j;
                            ai_win = true;
                        }
                        gameField.cell[i][j] = gameField.NOT_SIGN;
                    }
                }
            }
        }
        // Блокировка хода пользователя, если он побеждает на следующем ходу
        if (aiLevel > 0)
        {
            if (!ai_win)
            {
                for (int i = 0; i < SIZE; i++)
                {
                    for (int j = 0; j < SIZE; j++)
                    {
                        if (!gameField.isCellBusy(i, j))
                        {
                            gameField.cell[i][j] = this.playerSign;
                            if (gameField.checkWin(this.playerSign))
                            {
                                x = i;
                                y = j;
                                user_win = true;
                            }
                            gameField.cell[i][j] = gameField.NOT_SIGN;
                        }
                    }
                }
            }
        }
        if (!ai_win && !user_win)
        {
            do
            {
                Random rnd = new Random();
                x = rnd.nextInt(SIZE);
                y = rnd.nextInt(SIZE);
            }
            while (gameField.isCellBusy(x, y));
        }
        gameField.cell[x][y] = sign;
        return true;
    }

    boolean win()
    {
        gameField = MainGameField.getInstance();
        return gameField.checkWin(this.sign);
    }
}
