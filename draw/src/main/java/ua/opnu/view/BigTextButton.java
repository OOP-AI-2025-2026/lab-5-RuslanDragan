package ua.opnu.view;

import javax.swing.JButton;
import java.awt.Font;

public class BigTextButton extends JButton {

    public BigTextButton(String text) {
        super(text);
        this.setFont(new Font("Arial", Font.PLAIN, 22));
    }
}