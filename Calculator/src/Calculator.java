import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.EventListener;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, substituteButton, multiplyButton, divideButton;
    JButton decimalButton, equalButton, deleteButton, clearButton,negativeButton;
    JPanel jPanel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        substituteButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        negativeButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = substituteButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = clearButton;
        functionButtons[7] = deleteButton;
        functionButtons[8] = negativeButton;

        for(int i = 0; i<9 ; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i = 0; i<10 ; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negativeButton.setBounds(50,430,100,50);
        deleteButton.setBounds(150, 430, 100,50);
        clearButton.setBounds(250, 430, 100,50);


        jPanel = new JPanel();
        jPanel.setBounds(50, 100, 300, 300);
        jPanel.setLayout(new GridLayout(4,4,10,10));

        jPanel.add(numberButtons[1]);
        jPanel.add(numberButtons[2]);
        jPanel.add(numberButtons[3]);
        jPanel.add(addButton);

        jPanel.add(numberButtons[4]);
        jPanel.add(numberButtons[5]);
        jPanel.add(numberButtons[6]);
        jPanel.add(substituteButton);

        jPanel.add(numberButtons[7]);
        jPanel.add(numberButtons[8]);
        jPanel.add(numberButtons[9]);
        jPanel.add(multiplyButton);
        jPanel.add(decimalButton);
        jPanel.add(numberButtons[0]);
        jPanel.add(equalButton);
        jPanel.add(divideButton);



        frame.add(jPanel);
        frame.add(negativeButton);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i =0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimalButton){
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == substituteButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == multiplyButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divideButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equalButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case '+':
                    result = num1 + num2;
                    textField.setText(String.valueOf(result));
                    break;

                case '-':
                    result = num1 - num2;
                    textField.setText(String.valueOf(result));
                    break;

                case '*':
                    result = num1 * num2;
                    textField.setText(String.valueOf(result));
                    break;

                case '/':
                    result = num1 / num2;
                    textField.setText(String.valueOf(result));
                    break;

                default:
                    textField.setText("ERROR");
                    break;
            }
            num1 = result;
        }

        if (e.getSource() == clearButton){
            num1 = 0.0;
            num2 = 0.0;
            result = 0.0;
            operator = ' ';
            textField.setText("");
        }

        if (e.getSource() == deleteButton){
            String text = textField.getText();
            textField.setText("");
            for (int i = 0; i < text.length()-1; i++){
                textField.setText(textField.getText()+text.charAt(i));
            }
        }

        if (e.getSource() == negativeButton){
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
            }
        }

    }
