import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainForm extends JFrame {

    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_HEIGHT = 560;
    private static final int WINDOW_POS_X = 650;
    private static final int WINDOW_POS_Y = 250;

    //private MainForm mainForm;
    private GameSettingsForm gameSettingsForm;

    MainForm() {
        // Заголовок формы
        setTitle("TIC TAC TOE");

        // Задаем размер и положение окна
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);

        // Не даем менять формы
        setResizable(false);
        // При закрытии - форма и программа закрываются
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Создаём экземпляр нашего игрового поля
        MainGameField gameField = MainGameField.getInstance();
        // Создаём панель для кнопок табличного стиля
        JPanel buttonPanel = new JPanel(new GridLayout());
        // Добавляем игровок поле в центр нашей формы
        add(gameField, BorderLayout.CENTER);
        // Панель для кнопок добавляем вниз формы
        add(buttonPanel, BorderLayout.SOUTH);
        // Кнопки для начала и завершения Игры
        JButton btnStart = new JButton("Start new game");
        JButton btnEnd = new JButton("Exit");
        // Привязываем кнопки к панеле
        buttonPanel.add(btnStart);
        buttonPanel.add(btnEnd);

        setBackground(Color.blue);

        // Показываем форму
        setVisible(true);

        // this ссылается на текущий объект GW, который мы передаем в SW
        // в gamesettings мы будем передавать коррдинаты и размеры главного окна для расчета окна настроек, так что бы
        // можно был автоматически определить центр большого окна
        gameSettingsForm = new GameSettingsForm(this);

        // Добавляем обработчик событий для закрытия формы (оживляем кнопки)
        btnEnd.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // Добавляем обработчик событий для создания новой игры
        btnStart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start new game");
                gameSettingsForm.setVisible(true);
            }
        });
    }
}
