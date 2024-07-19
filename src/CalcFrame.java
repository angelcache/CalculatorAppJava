/* 
 * Purpose: Creates a frame for the calculator
 */

import java.awt.*;
import javax.swing.*;

public class CalcFrame extends JFrame {
    ImageIcon icon;
    JTextField textField;
    Font myFont = new Font("Calibri", Font.PLAIN, 30);

    

    public CalcFrame() {

        /* Customizing the frame */
        this.setSize(500, 700);
        this.setTitle("My Calculator");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0xE2F5FF));

        /* Creating the screen using textField */
        textField = new JTextField();
        textField.setBounds(45, 25, 400, 100);
        textField.setFont(myFont);
        textField.setEditable(false); // no user can type on the screen
        this.add(textField);

        icon = new ImageIcon("calcIcon.png");
        this.setIconImage(icon.getImage());

        /* Instantiating the buttons + calculations*/
        Calculations calculation = new Calculations(this);
    }

    public JTextField getTextField() {
        return textField;
    }

}
