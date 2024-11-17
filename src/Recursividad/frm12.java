package Recursividad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class frm12 extends JFrame {
    private JTextArea txtResultado;
    
    public frm12() {
        setTitle("Números del 1 al 100");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        
        JButton btnMostrar = new JButton("Mostrar Números");
        btnMostrar.setBounds(50, 20, 150, 30);
        add(btnMostrar);
        
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        scrollPane.setBounds(50, 60, 300, 180);
        add(scrollPane);
        
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarNumeros();
            }
        });
    }
    
    private void mostrarNumeros() {
        txtResultado.setText("");
        StringBuilder sb = new StringBuilder();
        imprimirNumerosRecursivo(1, 100, 1, sb);
        txtResultado.setText(sb.toString());
    }
    
    private void imprimirNumerosRecursivo(int inicio, int fin, int posicion, StringBuilder sb) {
        if (inicio > fin) return;
        
        // Formatea el número para que ocupe 4 espacios
        sb.append(String.format("%4d", inicio));
        
        // Si hemos completado 10 números, nueva línea
        if (posicion % 10 == 0) {
            sb.append("\n");
        }
        
        // Llamada recursiva para el siguiente número
        imprimirNumerosRecursivo(inicio + 1, fin, posicion + 1, sb);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frm12 frame = new frm12();
            frame.setVisible(true);
        });
    }
}
