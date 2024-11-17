package Recursividad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class frm14 extends JFrame {
    private JTextField txtNumero;
    private JTextArea txtResultado;
    
    public frm14() {
        setTitle("Verificador de Números Primos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        
        
        JLabel lblNumero = new JLabel("Ingrese un número:");
        lblNumero.setBounds(50, 20, 150, 30);
        add(lblNumero);
        
        txtNumero = new JTextField();
        txtNumero.setBounds(200, 20, 100, 30);
        add(txtNumero);
        
        
        JButton btnVerificar = new JButton("Verificar");
        btnVerificar.setBounds(50, 60, 150, 30);
        add(btnVerificar);
        
        
        JButton btnRango = new JButton("Primos hasta N");
        btnRango.setBounds(210, 60, 150, 30);
        add(btnRango);
        
        
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        scrollPane.setBounds(50, 100, 300, 180);
        add(scrollPane);
        
        btnVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarPrimo();
            }
        });
        
        btnRango.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPrimosHastaN();
            }
        });
    }
    
    private void verificarPrimo() {
        try {
            int numero = Integer.parseInt(txtNumero.getText());
            if (numero <= 0) {
                JOptionPane.showMessageDialog(this, 
                    "Por favor ingrese un número positivo",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            boolean esPrimo = verificarPrimoRecursivo(numero, 2);
            
            txtResultado.setText("Análisis del número " + numero + ":\n\n");
            txtResultado.append("El número " + numero + (esPrimo ? " ES" : " NO ES") + " primo.\n\n");
            
            if (esPrimo) {
                txtResultado.append("Explicación:\n");
                txtResultado.append(numero + " solo es divisible entre 1 y " + numero);
            } else {
                txtResultado.append("Explicación:\n");
                encontrarDivisores(numero, 1, new StringBuilder());
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Por favor ingrese un número válido",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean verificarPrimoRecursivo(int n, int divisor) {
        
        if (n <= 1) return false;
        if (divisor * divisor > n) return true;
        
        
        if (n % divisor == 0) return false;
        
        
        return verificarPrimoRecursivo(n, divisor + 1);
    }
    
    private void encontrarDivisores(int n, int divisor, StringBuilder divisores) {
        if (divisor > n) {
            txtResultado.append("Divisores encontrados: " + divisores.toString());
            return;
        }
        
        if (n % divisor == 0) {
            divisores.append(divisor).append(", ");
        }
        
        encontrarDivisores(n, divisor + 1, divisores);
    }
    
    private void mostrarPrimosHastaN() {
        try {
            int limite = Integer.parseInt(txtNumero.getText());
            if (limite <= 0) {
                JOptionPane.showMessageDialog(this, 
                    "Por favor ingrese un número positivo",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            txtResultado.setText("Números primos hasta " + limite + ":\n\n");
            encontrarPrimosHastaN(2, limite);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Por favor ingrese un número válido",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void encontrarPrimosHastaN(int actual, int limite) {
        if (actual > limite) return;
        
        if (verificarPrimoRecursivo(actual, 2)) {
            txtResultado.append(actual + " ");
        }
        
        encontrarPrimosHastaN(actual + 1, limite);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frm14 frame = new frm14();
            frame.setVisible(true);
        });
    }
}
