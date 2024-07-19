/*
 * Purpose: creates the buttons for the calculator
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculations implements ActionListener {
    CalcFrame frame;

    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    Font myFont = new Font("Calibri", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    
    JPanel panel; // will hold the buttons

    public Calculations(CalcFrame aFrame) {
        frame = aFrame;

        /* Generate the function buttons */
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        /* Instantiating the bounds of delete and clear buttons */
        negButton.setBounds(45, 570, 100, 50);
        delButton.setBounds(168, 570, 150, 50);
        clrButton.setBounds(345, 570, 100, 50);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);

        /* Instantiating the panel to place the other buttons in */
        panel = new JPanel();
        panel.setBounds(45, 160, 400, 375);
        panel.setLayout(new GridLayout(4, 4, 10, 10)); // gives a grid look, perfect for cal buttons
        panel.setBackground(new Color(0xE2F5FF));

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);
        panel.add(numberButtons[3]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[1]);
        panel.add(subButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);
        panel.add(addButton);

        frame.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                frame.getTextField().setText(frame.getTextField().getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            frame.getTextField().setText(frame.getTextField().getText().concat("."));
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(frame.getTextField().getText());
            operator = '÷';
            frame.getTextField().setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(frame.getTextField().getText());
            operator = '×';
            frame.getTextField().setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(frame.getTextField().getText());
            operator = '-';
            frame.getTextField().setText("");
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(frame.getTextField().getText());
            operator = '+';
            frame.getTextField().setText("");
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(frame.getTextField().getText());

            switch(operator) {
                case'÷':
                    result = 1.0 * num1 / num2;
                case '×':
                    result = num1 * num2;
                case '+': 
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
            }
            frame.getTextField().setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(frame.getTextField().getText()); // takes whatever value is in textfield and make it negative
            temp *= -1;
            frame.getTextField().setText(String.valueOf(temp));
        }

        if (e.getSource() == clrButton) {
            frame.getTextField().setText("");
        }

        if (e.getSource() == delButton) {
            String string = frame.getTextField().getText();
            frame.getTextField().setText("");
            for (int i = 0; i < string.length() - 1; i++) { // iterates through length of string - i
                frame.getTextField().setText(frame.getTextField().getText() + string.charAt(i)); // will delete last item
            }
        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
