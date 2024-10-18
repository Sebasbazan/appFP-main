package Condicionales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm14 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNumeroTarjeta;
    private JTextField txtMontoCompra;
    private JTextField txtDescuento;
    private JTextField txtTotal;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm14 frame = new frm14();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm14() {
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        // Etiqueta y campo de texto para el número de tarjeta
        JLabel lblNumeroTarjeta = new JLabel("Número de la Tarjeta:");
        lblNumeroTarjeta.setBounds(30, 30, 150, 30);
        getContentPane().add(lblNumeroTarjeta);

        txtNumeroTarjeta = new JTextField();
        txtNumeroTarjeta.setBounds(200, 30, 150, 30);
        getContentPane().add(txtNumeroTarjeta);

        // Etiqueta y campo de texto para el monto de compra
        JLabel lblMontoCompra = new JLabel("Monto de la Compra:");
        lblMontoCompra.setBounds(30, 70, 150, 30);
        getContentPane().add(lblMontoCompra);

        txtMontoCompra = new JTextField();
        txtMontoCompra.setBounds(200, 70, 150, 30);
        getContentPane().add(txtMontoCompra);

        // Botón para calcular el descuento
        btnCalcular = new JButton("Calcular Descuento");
        btnCalcular.setBounds(200, 110, 200, 30);
        getContentPane().add(btnCalcular);

        // Etiqueta y campo de texto para el descuento
        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(30, 150, 100, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(200, 150, 150, 30);
        txtDescuento.setFocusable(false);
        getContentPane().add(txtDescuento);

        // Etiqueta y campo de texto para el total
        JLabel lblTotal = new JLabel("Total a Pagar:");
        lblTotal.setBounds(30, 190, 100, 30);
        getContentPane().add(lblTotal);

        txtTotal = new JTextField();
        txtTotal.setBounds(200, 190, 150, 30);
        txtTotal.setFocusable(false);
        getContentPane().add(txtTotal);

        // Acción del botón Calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularDescuento();
            }
        });
    }

    private void calcularDescuento() {
        try {
            int numeroTarjeta = Integer.parseInt(txtNumeroTarjeta.getText());
            double montoCompra = Double.parseDouble(txtMontoCompra.getText());
            double descuento;
            double total;

            // Verificar si el número de tarjeta es par y no menor de 100
            if (numeroTarjeta >= 100 && numeroTarjeta % 2 == 0) {
                descuento = montoCompra * 0.15; // 15% de descuento
            } else {
                descuento = montoCompra * 0.05; // 5% de descuento
            }

            // Calcular el total a pagar
            total = montoCompra - descuento;

            // Mostrar el descuento y el total a pagar
            txtDescuento.setText(String.format("%.2f", descuento));
            txtTotal.setText(String.format("%.2f", total));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}