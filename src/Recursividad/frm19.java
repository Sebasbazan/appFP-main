package Recursividad;
import java.awt.*;
import javax.swing.*;

public class frm19 extends JFrame {
    public frm19() {
        setTitle("10 Botones Verticales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLayout(new GridLayout(10, 1, 5, 5)); 

        
        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton("Botón " + i);
            add(button);
        }

        setLocationRelativeTo(null); 
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frm19 frame = new frm19();
            frame.setVisible(true);
        });
    }
}
