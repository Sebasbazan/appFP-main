package Condicionales;  

import javax.swing.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.text.DecimalFormat;  

public class frm02 extends JFrame {  
    private static final long serialVersionUID = 1L;  

    private JTextField txtUnidades, txtImporte, txtDescuento, txtTotal, txtCaramelos;  
    private JButton btnCalcular;  

    public static void main(String[] args) {  
        SwingUtilities.invokeLater(() -> {  
            try {  
                frm02 frame = new frm02();  
                frame.setVisible(true);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        });  
    }  

    public frm02() {  
        // Configuración de la ventana  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setBounds(100, 100, 400, 350);  
        setLayout(null);  
        setLocationRelativeTo(null);  

        // Etiquetas y campos de texto  
        JLabel lblUnidades = new JLabel("Cantidad de Unidades:");  
        lblUnidades.setBounds(30, 30, 150, 30);  
        getContentPane().add(lblUnidades);  

        txtUnidades = new JTextField();  
        txtUnidades.setBounds(200, 30, 100, 30);  
        getContentPane().add(txtUnidades);  

        btnCalcular = new JButton("Calcular");  
        btnCalcular.setBounds(200, 70, 100, 30);  
        getContentPane().add(btnCalcular);  

        JLabel lblImporte = new JLabel("Importe de la compra:");  
        lblImporte.setBounds(30, 120, 150, 30);  
        getContentPane().add(lblImporte);  

        txtImporte = new JTextField();  
        txtImporte.setBounds(200, 120, 100, 30);  
        txtImporte.setFocusable(false);  
        getContentPane().add(txtImporte);  

        JLabel lblDescuento = new JLabel("Descuento:");  
        lblDescuento.setBounds(30, 160, 150, 30);  
        getContentPane().add(lblDescuento);  

        txtDescuento = new JTextField();  
        txtDescuento.setBounds(200, 160, 100, 30);  
        txtDescuento.setFocusable(false);  
        getContentPane().add(txtDescuento);  

        JLabel lblTotal = new JLabel("Total a Pagar:");  
        lblTotal.setBounds(30, 200, 150, 30);  
        getContentPane().add(lblTotal);  

        txtTotal = new JTextField();  
        txtTotal.setBounds(200, 200, 100, 30);  
        txtTotal.setFocusable(false);  
        getContentPane().add(txtTotal);  

        JLabel lblCaramelos = new JLabel("Caramelos de Obsequio:");  
        lblCaramelos.setBounds(30, 240, 150, 30);  
        getContentPane().add(lblCaramelos);  

        txtCaramelos = new JTextField();  
        txtCaramelos.setBounds(200, 240, 100, 30);  
        txtCaramelos.setFocusable(false);  
        getContentPane().add(txtCaramelos);  

        // Acción del botón Calcular  
        btnCalcular.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                calcularTotal();  
            }  
        });  
    }  

    // Método para realizar el cálculo  
    private void calcularTotal() {  
        try {  
            int unidades = Integer.parseInt(txtUnidades.getText());  
            double precioUnitario = 20.0;  
            double importTotal = unidades * precioUnitario;  
            double descuento;  
            double total;  
            int caramelos;  

            // Calcular descuento basado en el total de importación  
            if (importTotal > 700) {  
                descuento = importTotal * 0.16; // 16% de descuento  
            } else if (importTotal >= 501 && importTotal <= 700) {  
                descuento = importTotal * 0.14; // 14% de descuento  
            } else {  
                descuento = importTotal * 0.12; // 12% de descuento  
            }  

            total = importTotal - descuento;  

            // Determinar caramelos según las unidades adquiridas  
            if (unidades <= 50) {  
                caramelos = 5;  
            } else if (unidades <= 100) {  
                caramelos = 10;  
            } else {  
                caramelos = 15;  
            }  

            // Formatear y mostrar resultados  
            DecimalFormat df = new DecimalFormat("####.00");  
            txtImporte.setText(df.format(importTotal));  
            txtDescuento.setText(df.format(descuento));  
            txtTotal.setText(df.format(total));  
            txtCaramelos.setText(String.valueOf(caramelos));  
        } catch (NumberFormatException e) {  
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);  
        }  
    }  
}