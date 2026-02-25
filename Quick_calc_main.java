import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

class Calculator_main extends JFrame {

    public static double res = 0;

    public static void main(String args[]) {

        // Creating the Frame
        JFrame frame = new JFrame("IntCALC");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Color mainColor = new Color(211, 211, 211);
        Color subcolor = new Color(128, 128, 130);
        frame.getContentPane().setBackground(mainColor);
        frame.setSize(400, 200);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Exit the programm?");
                if (res == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
        
        JTextArea num1 = new JTextArea("0");
        num1.setBounds(0, 5, 150, 25);
        num1.setFont(new Font("Sans", Font.PLAIN, 13));
        num1.setBackground(subcolor);
        frame.add(num1);

        // Second number input
        JTextArea num2 = new JTextArea("0");
        num2.setBounds(0, 60, 150, 25);
        num2.setFont(new Font("Sans", Font.PLAIN, 13));
        num2.setBackground(subcolor);
        frame.add(num2);

        // Result display
        JTextArea result = new JTextArea("No answer yet!");
        result.setBounds(0, 120, 150, 25);
        result.setFont(new Font("Sans", Font.PLAIN, 13));
        result.setBackground(subcolor);
        result.setEditable(false);
        frame.add(result);

        // Operator label between num1 and num2
        JLabel action1 = new JLabel();
        action1.setBackground(mainColor);
        action1.setBounds(75, 30, 25, 20);
        frame.add(action1);

        // Status label
        JLabel end = new JLabel("Choose operation!");
        end.setBackground(mainColor);
        end.setBounds(5, 85, 180, 20);
        frame.add(end);

        // Operation buttons — 2x2 grid
        JButton plus  = new JButton("ADD");
        JButton minus = new JButton("SUB");
        JButton mult  = new JButton("MUL");
        JButton div   = new JButton("DIV");
        JButton calc  = new JButton("Calculate");
        JButton clear = new JButton("(C)");

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
        
        frame.validate();
        frame.setVisible(true);
    }
}
