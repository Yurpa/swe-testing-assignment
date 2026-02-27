import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;


class Calculator_main extends JFrame {

    public static double res = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> buildFrame().setVisible(true));
    }
    public static JFrame buildFrame() {

        JFrame frame = new JFrame("IntCALC");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Color mainColor = new Color(211, 211, 211);
        Color subcolor  = new Color(128, 128, 130);

        frame.getContentPane().setBackground(mainColor);
        frame.setSize(400, 200);
        frame.setResizable(false);
        frame.setLayout(null);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Exit the program?");
                if (choice == JOptionPane.YES_OPTION) System.exit(0);
            }
        });

        JTextArea num1 = new JTextArea("0");
        num1.setName("num1");
        num1.setBounds(0, 5, 150, 25);
        num1.setFont(new Font("Sans", Font.PLAIN, 13));
        num1.setBackground(subcolor);
        frame.add(num1);

        JTextArea num2 = new JTextArea("0");
        num2.setName("num2");
        num2.setBounds(0, 60, 150, 25);
        num2.setFont(new Font("Sans", Font.PLAIN, 13));
        num2.setBackground(subcolor);
        frame.add(num2);

        JTextArea result = new JTextArea("No answer yet!");
        result.setName("result");
        result.setBounds(0, 120, 150, 25);
        result.setFont(new Font("Sans", Font.PLAIN, 13));
        result.setBackground(subcolor);
        result.setEditable(false);
        frame.add(result);


        JLabel action1 = new JLabel();
        action1.setName("action1");
        action1.setBackground(mainColor);
        action1.setBounds(75, 30, 25, 20);
        frame.add(action1);

        JLabel end = new JLabel("Choose operation!");
        end.setName("end");
        end.setBackground(mainColor);
        end.setBounds(5, 85, 180, 20);
        frame.add(end);


        JButton plus  = new JButton("ADD");  plus.setName("plus");
        JButton minus = new JButton("SUB");  minus.setName("minus");
        JButton mult  = new JButton("MUL");  mult.setName("mult");
        JButton div   = new JButton("DIV");  div.setName("div");
        JButton calc  = new JButton("Calculate"); calc.setName("calc");
        JButton clear = new JButton("(C)");  clear.setName("clear");

        plus.setBackground(Color.red);
        plus.setFont(new Font("Sans", Font.BOLD, 13));
        plus.setBounds(160, 5, 100, 30);
        frame.add(plus);

        minus.setBackground(Color.blue);
        minus.setFont(new Font("Sans", Font.BOLD, 13));
        minus.setBounds(280, 5, 100, 30);
        frame.add(minus);

        mult.setBackground(new Color(227, 116, 23));
        mult.setFont(new Font("Sans", Font.BOLD, 13));
        mult.setBounds(160, 60, 100, 30);
        frame.add(mult);

        div.setBackground(new Color(130, 60, 200));
        div.setFont(new Font("Sans", Font.BOLD, 13));
        div.setBounds(280, 60, 100, 30);
        frame.add(div);

        calc.setBackground(new Color(19, 177, 230));
        calc.setFont(new Font("Sans", Font.BOLD, 13));
        calc.setBounds(280, 115, 100, 30);
        frame.add(calc);

        clear.setBackground(new Color(220, 50, 50));
        clear.setForeground(Color.white);
        clear.setFont(new Font("Sans", Font.BOLD, 13));
        clear.setBounds(160, 115, 100, 30);
        frame.add(clear);

        // --- Action listeners -----------------------------------------------

        plus.addActionListener(e -> {
            action1.setText("+");
            try {
                res = CalcLogic.add(
                        CalcLogic.parse(num1.getText()),
                        CalcLogic.parse(num2.getText()));
                end.setText("Choose operation or '='!");
            } catch (NumberFormatException ex) {
                end.setText("Please enter real numbers only!");
            }
        });

        minus.addActionListener(e -> {
            action1.setText("-");
            try {
                res = CalcLogic.subtract(
                        CalcLogic.parse(num1.getText()),
                        CalcLogic.parse(num2.getText()));
                end.setText("Choose operation or '='!");
            } catch (NumberFormatException ex) {
                end.setText("Please enter real numbers only!");
            }
        });

        mult.addActionListener(e -> {
            action1.setText("*");
            try {
                res = CalcLogic.multiply(
                        CalcLogic.parse(num1.getText()),
                        CalcLogic.parse(num2.getText()));
                end.setText("Choose operation or '='!");
            } catch (NumberFormatException ex) {
                end.setText("Please enter real numbers only!");
            }
        });

        div.addActionListener(e -> {
            action1.setText("/");
            try {
                double a = CalcLogic.parse(num1.getText());
                double b = CalcLogic.parse(num2.getText());
                res = CalcLogic.divide(a, b);
                end.setText("Choose operation or '='!");
            } catch (ArithmeticException ex) {
                end.setText("Division by zero is not allowed!");
            } catch (NumberFormatException ex) {
                end.setText("Please enter real numbers only!");
            }
        });

        calc.addActionListener(e -> {
            result.setText(String.valueOf(res));
            end.setText("You did it! The Answer:");
        });

        clear.addActionListener(e -> {
            num1.setText("0");
            num2.setText("0");
            result.setText("No answer yet!");
            action1.setText("");
            res = 0;
            end.setText("Choose operation!");
        });

        frame.validate();
        return frame;
    }
}