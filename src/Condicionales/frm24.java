package Condicionales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm24 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtMontoVendido;
    private JTextField txtSueldo;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm24 frame = new frm24();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    public frm24() {
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        // Etiqueta y campo de texto para el monto vendido
        JLabel lblMontoVendido = new JLabel("Monto Vendido:");
        lblMontoVendido.setBounds(30, 30, 150, 30);
        getContentPane().add(lblMontoVendido);

        txtMontoVendido = new JTextField();
        txtMontoVendido.setBounds(200, 30, 150, 30);
        getContentPane().add(txtMontoVendido);

        // Botón para calcular
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(200, 70, 150, 30);
        getContentPane().add(btnCalcular);

        // Etiqueta y campo de texto para el sueldo
        JLabel lblSueldo = new JLabel("Sueldo Total:");
        lblSueldo.setBounds(30, 110, 150, 30);
        getContentPane().add(lblSueldo);

        txtSueldo = new JTextField();
        txtSueldo.setBounds(200, 110, 150, 30);
        txtSueldo.setFocusable(false);
        getContentPane().add(txtSueldo);

        // Acción del botón Calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSueldo();
            }
        });
    }

    private void calcularSueldo() {
        try {
            double montoVendido = Double.parseDouble(txtMontoVendido.getText());
            double sueldoBase = montoVendido * 0.10;
            double bonificacion = 0;

            
            if (montoVendido > 5000) {
                double exceso = montoVendido - 5000;
                bonificacion = (int) (exceso / 500) * 25; 
            }

            double sueldoTotal = sueldoBase + bonificacion;

          
            txtSueldo.setText(String.format("%.2f", sueldoTotal));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}