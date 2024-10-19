package Condicionales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm26 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtMontoCompra;
    private JTextField txtPrestamo;
    private JTextField txtPropioDinero;
    private JTextField txtInteres;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm26 frame = new frm26();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm26() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        
        JLabel lblMontoCompra = new JLabel("Monto de Compra:");
        lblMontoCompra.setBounds(30, 30, 150, 30);
        getContentPane().add(lblMontoCompra);

        txtMontoCompra = new JTextField();
        txtMontoCompra.setBounds(200, 30, 150, 30);
        getContentPane().add(txtMontoCompra);

        
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(200, 70, 150, 30);
        getContentPane().add(btnCalcular);

        
        JLabel lblPrestamo = new JLabel("Préstamo:");
        lblPrestamo.setBounds(30, 110, 150, 30);
        getContentPane().add(lblPrestamo);

        txtPrestamo = new JTextField();
        txtPrestamo.setBounds(200, 110, 150, 30);
        txtPrestamo.setFocusable(false);
        getContentPane().add(txtPrestamo);

        
        JLabel lblPropioDinero = new JLabel("Dinero Propio:");
        lblPropioDinero.setBounds(30, 150, 150, 30);
        getContentPane().add(lblPropioDinero);

        txtPropioDinero = new JTextField();
        txtPropioDinero.setBounds(200, 150, 150, 30);
        txtPropioDinero.setFocusable(false);
        getContentPane().add(txtPropioDinero);

        
        JLabel lblInteres = new JLabel("Interés (10%):");
        lblInteres.setBounds(30, 190, 150, 30);
        getContentPane().add(lblInteres);

        txtInteres = new JTextField();
        txtInteres.setBounds(200, 190, 150, 30);
        txtInteres.setFocusable(false);
        getContentPane().add(txtInteres);

        
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularFinanciamiento();
            }
        });
    }

    private void calcularFinanciamiento() {
        try {
            double montoCompra = Double.parseDouble(txtMontoCompra.getText());
            double prestamo;
            double propioDinero;
            double interes;

        
            if (montoCompra > 5000) {
                prestamo = montoCompra * 0.30;
            } else {
                prestamo = montoCompra * 0.20;
            }

         
            interes = prestamo * 0.10;

       
            propioDinero = montoCompra - prestamo - interes;

          
            txtPrestamo.setText(String.format("%.2f", prestamo + interes));
            txtPropioDinero.setText(String.format("%.2f", propioDinero));
            txtInteres.setText(String.format("%.2f", interes));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}