package Recursividad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class frm13 extends JFrame {
    private JTextField txtLimite;
    private JTextArea txtResultado;
    
    public frm13() {
        setTitle("Suma de Múltiplos de 3 (no de 5)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        
        
        JLabel lblLimite = new JLabel("Ingrese el límite n:");
        lblLimite.setBounds(50, 20, 150, 30);
        add(lblLimite);
        
        txtLimite = new JTextField();
        txtLimite.setBounds(200, 20, 100, 30);
        add(txtLimite);
        
        
        JButton btnCalcular = new JButton("Calcular Suma");
        btnCalcular.setBounds(50, 60, 150, 30);
        add(btnCalcular);
        
        
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        scrollPane.setBounds(50, 100, 350, 180);
        add(scrollPane);
        
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularSuma();
            }
        });
    }
    
    private void calcularSuma() {
        try {
            int limite = Integer.parseInt(txtLimite.getText());
            if (limite <= 0) {
                JOptionPane.showMessageDialog(this, 
                    "Por favor ingrese un número positivo",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            txtResultado.setText("Números múltiplos de 3 pero no de 5 hasta " + limite + ":\n\n");
            StringBuilder numeros = new StringBuilder();
            int suma = sumarMultiplosRecursivo(1, limite, numeros);
            
            txtResultado.append(numeros.toString());
            txtResultado.append("\nLa suma total es: " + suma);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Por favor ingrese un número válido",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private int sumarMultiplosRecursivo(int actual, int limite, StringBuilder numeros) {
        
        if (actual > limite) {
            return 0;
        }
        
        
        int sumaActual = 0;
        if (actual % 3 == 0 && actual % 5 != 0) {
            sumaActual = actual;
            numeros.append(actual).append(", ");
        }
        
        
        return sumaActual + sumarMultiplosRecursivo(actual + 1, limite, numeros);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frm13 frame = new frm13();
            frame.setVisible(true);
        });
    }
}