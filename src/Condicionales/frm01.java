package Condicionales;

import javax.swing.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.text.DecimalFormat;  

public class frm01 extends JFrame {  
    private static final long serialVersionUID = 1L;  
    private JTextField txtUnidades, txtImporte, txtDescuento, txtTotal;  
    private JButton btnCalcular;  

    public static void main(String[] args) {  
        SwingUtilities.invokeLater(() -> {  
            try {  
                frm01 frame = new frm01();  
                frame.setVisible(true);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        });  
    }  

    public frm01() {  
          
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setBounds(100, 100, 400, 300);  
        setLayout(null);  
        setLocationRelativeTo(null);  

          
        JLabel lblUnidades = new JLabel("Cantidad de Unidades:");  
        lblUnidades.setBounds(30, 30, 150, 30);  
        getContentPane().add(lblUnidades);  

        txtUnidades = new JTextField();  
        txtUnidades.setBounds(200, 30, 100, 30);  
        getContentPane().add(txtUnidades);  

        btnCalcular = new JButton("Calcular");  
        btnCalcular.setBounds(200, 70, 100, 30);  
        getContentPane().add(btnCalcular);  

        JLabel lblImporte = new JLabel("Total de la importación:");  
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

          
        btnCalcular.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                calcularTotal();  
            }  
        });  
    }  

    private void calcularTotal() {  
        try {  
            int unidades = Integer.parseInt(txtUnidades.getText());  
            double precioUnitario;  

              
            if (unidades >= 1 && unidades <= 25) {  
                precioUnitario = 27.0;  
            } else if (unidades >= 26 && unidades <= 50) {  
                precioUnitario = 25.0;  
            } else {  
                precioUnitario = 23.0;  
            }  

             
            double importTotal = unidades * precioUnitario;  
            double descuento;  
            double total;  

              
            if (unidades > 50) {  
                descuento = importTotal * 0.15; // 15%  
            } else {  
                descuento = importTotal * 0.05; // 5%  
            }  

              
            total = importTotal - descuento;  

              
            DecimalFormat df = new DecimalFormat("####.00");  
            txtImporte.setText(df.format(importTotal));  
            txtDescuento.setText(df.format(descuento));  
            txtTotal.setText(df.format(total));  
        } catch (NumberFormatException e) {  
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);  
        }  
    }  
}