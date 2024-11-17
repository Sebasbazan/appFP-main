package Repetitivas;
import javax.swing.*;
import java.awt.*;   
import java.awt.event.*;  

public class frm01 extends JFrame {  
    private JTextField txtDividendo;  
    private JTextField txtDivisor;  
    private JLabel lblResultado;  

    public frm01() {   
        setTitle("División");  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(350, 300);
        setLayout(null);  
        setLocationRelativeTo(null); 
        
        JLabel lblDividendo = new JLabel("Dividendo:");  
        lblDividendo.setBounds(50, 30, 80, 30);  
        add(lblDividendo);  

        txtDividendo = new JTextField();  
        txtDividendo.setBounds(140, 30, 80, 30);  
        add(txtDividendo);  

        JLabel lblDivisor = new JLabel("Divisor:");  
        lblDivisor.setBounds(50, 70, 80, 30);  
        add(lblDivisor);  

        txtDivisor = new JTextField();  
        txtDivisor.setBounds(140, 70, 80, 30);  
        add(txtDivisor);  
        
        JButton btnCalcular = new JButton("Calcular");  
        btnCalcular.setBounds(50, 110, 170, 30);  
        add(btnCalcular);  

        lblResultado = new JLabel("Resultado: ");  
        lblResultado.setBounds(50, 150, 300, 30);  
        add(lblResultado);  
        
        btnCalcular.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                calcularCocienteYRestos();  
            }  
        });  
    }  

    private void calcularCocienteYRestos() {  
        try {  
            int dividendo = Integer.parseInt(txtDividendo.getText());  
            int divisor = Integer.parseInt(txtDivisor.getText());  

            if (divisor == 0) {  
                lblResultado.setText("El divisor no puede ser cero.");  
                return;  
            }  

            int cociente = 0;  
            int resto = dividendo;  

            while (resto >= divisor) {  
                resto -= divisor;  
                cociente++;  
            }  

            lblResultado.setText("Cociente: " + cociente + ", Resto: " + resto);  
        } catch (NumberFormatException e) {  
            lblResultado.setText("Por favor, ingrese números válidos.");  
        }  
    }  

    public static void main(String[] args) {  
        EventQueue.invokeLater(() -> {  
            frm01 frame = new frm01();  
            frame.setVisible(true);  
        });  
    }  
}
