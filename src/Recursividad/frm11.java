package Recursividad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class frm11 extends JFrame {
    private JTextArea txtResultado;
    private int totalCapicuas = 0;
    
    public frm11() {
        setTitle("Números Capicúa de 3 Cifras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        
        JButton btnCalcular = new JButton("Mostrar Capicúas");
        btnCalcular.setBounds(50, 20, 150, 30);
        add(btnCalcular);
        
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        scrollPane.setBounds(50, 60, 300, 180);
        add(scrollPane);
        
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarCapicuas();
            }
        });
    }
    
    private void mostrarCapicuas() {
        txtResultado.setText("Números capicúa de 3 cifras:\n\n");
        totalCapicuas = 0;
        encontrarCapicuas(100, 999);
        txtResultado.append("\nTotal de números capicúa: " + totalCapicuas);
    }
    
    private void encontrarCapicuas(int inicio, int fin) {
        if (inicio > fin) return;
        
        if (esCapicua(inicio)) {
            txtResultado.append(inicio + "\n");
            totalCapicuas++;
        }
        
        encontrarCapicuas(inicio + 1, fin);
    }
    
    private boolean esCapicua(int numero) {
        return esCapicuaRecursivo(String.valueOf(numero), 0, 
                                String.valueOf(numero).length() - 1);
    }
    
    private boolean esCapicuaRecursivo(String num, int inicio, int fin) {
        
        if (inicio >= fin) {
            return true;
        }
        
        
        if (num.charAt(inicio) != num.charAt(fin)) {
            return false;
        }
        
        
        return esCapicuaRecursivo(num, inicio + 1, fin - 1);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frm11 frame = new frm11();
            frame.setVisible(true);
        });
    }
}