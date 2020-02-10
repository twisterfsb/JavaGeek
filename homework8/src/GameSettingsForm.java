import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSettingsForm extends JFrame {

    // Размеры окна
    public static final int WINDOW_WIDTH = 350;
    public static final int WINDOW_HEIGHT = 250;

    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 9;

    private static final String FIELD_SIZE_PREFIX = "The field size is: ";
    private static final String WIN_LENGTH_PREFIX = "The win length is: ";

    // Кнопки, слайдеры, прочее
    private JRadioButton radioButtonModeTwoPlayers;
    private JRadioButton radioButtonModeAgainstAI;
    private JSlider jSlider;
    private JSlider slFieldSize;
    private JSlider slWinLength;

    private MainForm mainForm;
    private MainGameField gameField;

    GameSettingsForm gameSettingsForm = this;

    public GameSettingsForm(MainForm mainForm) {
        this.mainForm = mainForm;
        // Название окна настроек
        setTitle("New game settings");
        // Задаем размер и положение окна
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        // Запрашиваем коррдинаты глвного окна для расчета расположения малого окна настроек
        Rectangle mainFormBounds = this.mainForm.getBounds();
        // Расчет для малого окна
        int positionX = (int) mainFormBounds.getCenterX() - WINDOW_WIDTH / 2;
        int positionY = (int) mainFormBounds.getCenterY() - WINDOW_HEIGHT / 2;
        // Закрепляем малое окно настроек
        setLocation(positionX, positionY);
        // Не дает меня формы
        setResizable(false);
        // При закрытии - закрываются только форма
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // Отрисовываем панель (два варианта)
        //setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // Вариант 1
        setLayout(new GridLayout(12, 1));                     // Вариант 2

        // Методы отвечающие за части понели
        addGameModeControls();
        addAILevel();
        addFieldSize();
        startGame();
    }

    private void addGameModeControls() {
        // Добавляем название для настроект (Сокращенная и полная запись. Используем сокращенную, так как нигде они больше не нужны)
        add(new JLabel("Choose the game mode: "));
        //JLabel jLabelMode = new JLabel("Choose the game mode:");
        //add(jLabelMode);

        // Два варианта мода
        radioButtonModeTwoPlayers = new JRadioButton("Player vs Player");
        add(radioButtonModeTwoPlayers);
        radioButtonModeTwoPlayers.setSelected(true);
        radioButtonModeAgainstAI = new JRadioButton("Player vs Computer");
        add(radioButtonModeAgainstAI);

        // Объединяем кнопки в группу
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonModeTwoPlayers);
        buttonGroup.add(radioButtonModeAgainstAI);

        // Если мы выбираем режим игры против компьютера, то
        // появится слайдер, который позволяет выбрать уровень сложности
        radioButtonModeAgainstAI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButtonModeAgainstAI.isSelected()) {
                    jSlider.setVisible(true);
                }
            }
        });

        // Если выбран режим игры против другого игрока, то скрываем слайдер
        radioButtonModeTwoPlayers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButtonModeTwoPlayers.isSelected()) {
                    jSlider.setVisible(false);
                }
            }
        });

    }


    private void addAILevel() {
        // Уровент AI
        add(new JLabel("Choose the level of AI:"));
        jSlider = new JSlider(0, 2, 0);
        add(jSlider);
        jSlider.setAlignmentX(CENTER_ALIGNMENT);
        jSlider.setVisible(false);

    }

    private void addFieldSize() {
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);

        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_WIN_LENGTH);

        // свзяываем ползунки и лейблы
        slFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                slWinLength.setMaximum(currentValue);
            }
        });

        slWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slWinLength.getValue());
            }
        });

        add(new JLabel("Choose the Field Size"));
        add(lbFieldSize);
        add(slFieldSize);

        add(new JLabel("Choose the winning length"));
        add(lbWinLength);
        add(slWinLength);

    }

    private void startGame() {

        // Добавляем кнопку старт
        JButton jButtonSetSettings = new JButton("Start!");
        add(jButtonSetSettings);

        // Оживляем кнопки старта
        jButtonSetSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "Вынимаем" значения
                int SIZE = slFieldSize.getValue();
                int WINLength = slWinLength.getValue();
                gameField = MainGameField.getInstance();
                gameField.startNewGame(SIZE, WINLength);
                if (radioButtonModeAgainstAI.isSelected()) {
                    gameField.gameMode = 2;
                }
                gameField.aiLevel = jSlider.getValue();
                // Убираем форму
                gameSettingsForm.setVisible(false);
            }
        });
    }
}
