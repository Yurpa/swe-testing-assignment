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
      frame.validate();
      frame.setVisible(true);
    }
}
