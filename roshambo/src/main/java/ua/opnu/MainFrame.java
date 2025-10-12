package ua.opnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame implements ActionListener {

    // --- КОНСТРУКТОР КЛАСУ ---
    // Цей код виконується один раз при запуску
    public MainFrame(String title) throws HeadlessException {
        super(title);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        // --- ОСЬ ВАШ КОД ДЛЯ СТВОРЕННЯ КНОПОК ---
        JButton rockButton = new JButton("Камінь");
        rockButton.addActionListener(this);
        rockButton.setActionCommand("rock");

        JButton paperButton = new JButton("Папір");
        paperButton.addActionListener(this);
        paperButton.setActionCommand("paper");

        JButton scissorsButton = new JButton("Ножиці");
        scissorsButton.addActionListener(this);
        scissorsButton.setActionCommand("scissors");
        // --- КІНЕЦЬ КОДУ ДЛЯ СТВОРЕННЯ КНОПОК ---

        this.add(rockButton);
        this.add(paperButton);
        this.add(scissorsButton);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // --- МЕТОДИ ЛОГІКИ ГРИ ---
    // Ці методи викликаються під час гри

    private GameShape generateShape() {
        int random = new Random().nextInt(3);

        if (random == 0) {
            return new Rock();
        } else if (random == 1) {
            return new Paper();
        } else {
            return new Scissors();
        }
    }

    private int checkWinner(GameShape player, GameShape computer) {
        if ((player instanceof Rock && computer instanceof Rock) ||
                (player instanceof Paper && computer instanceof Paper) ||
                (player instanceof Scissors && computer instanceof Scissors)) {
            return 0; // Нічия
        }

        if ((player instanceof Rock && computer instanceof Scissors) ||
                (player instanceof Scissors && computer instanceof Paper) ||
                (player instanceof Paper && computer instanceof Rock)) {
            return 1; // Гравець виграв
        }

        return -1; // Комп'ютер виграв
    }

    // --- МЕТОД-СЛУХАЧ ПОДІЙ ---
    // Цей метод викликається КОЖЕН РАЗ, коли ви натискаєте на кнопку

    @Override
    public void actionPerformed(ActionEvent e) {
        GameShape computerShape = generateShape();
        GameShape playerShape = null;

        switch (e.getActionCommand()) {
            case "rock":
                playerShape = new Rock();
                break;
            case "paper":
                playerShape = new Paper();
                break;
            case "scissors":
                playerShape = new Scissors();
                break;
        }

        int gameResult = checkWinner(playerShape, computerShape);
        String message = "Ваша фігура: " + playerShape + ". Фігура комп'ютера: " + computerShape + ". ";

        switch (gameResult) {
            case -1 -> message += "Ви програли!";
            case 0 -> message += "Нічия!";
            case 1 -> message += "Ви виграли!";
        }

        JOptionPane.showMessageDialog(this, message, "Результат гри", JOptionPane.INFORMATION_MESSAGE);
    }
}