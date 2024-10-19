package Condicionales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm17 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtPrecioDocena;
    private JTextField txtCantidadDocenas;
    private JTextField txtMontoCompra;
    private JTextField txtDescuento;
    private JTextField txtTotalPagar;
    private JTextField txtLapiceros;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm17 frame = new frm17();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm17() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 370);
        setLayout(null);
        setLocationRelativeTo(null);

        
        JLabel lblPrecioDocena = new JLabel("Precio por Docena:");
        lblPrecioDocena.setBounds(30, 30, 150, 30);
        getContentPane().add(lblPrecioDocena);

        txtPrecioDocena = new JTextField();
        txtPrecioDocena.setBounds(200, 30, 150, 30);
        getContentPane().add(txtPrecioDocena);

        
        JLabel lblCantidadDocenas = new JLabel("Cantidad de Docenas:");
        lblCantidadDocenas.setBounds(30, 70, 150, 30);
        getContentPane().add(lblCantidadDocenas);

        txtCantidadDocenas = new JTextField();
        txtCantidadDocenas.setBounds(200, 70, 150, 30);
        getContentPane().add(txtCantidadDocenas);

        
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(200, 110, 150, 30);
        getContentPane().add(btnCalcular);

        
        JLabel lblMontoCompra = new JLabel("Monto de Compra:");
        lblMontoCompra.setBounds(30, 150, 150, 30);
        getContentPane().add(lblMontoCompra);

        txtMontoCompra = new JTextField();
        txtMontoCompra.setBounds(200, 150, 150, 30);
        txtMontoCompra.setFocusable(false);
        getContentPane().add(txtMontoCompra);

        
        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(30, 190, 100, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(200, 190, 150, 30);
        txtDescuento.setFocusable(false);
        getContentPane().add(txtDescuento);

        
        JLabel lblTotalPagar = new JLabel("Total a Pagar:");
        lblTotalPagar.setBounds(30, 230, 100, 30);
        getContentPane().add(lblTotalPagar);

        txtTotalPagar = new JTextField();
        txtTotalPagar.setBounds(200, 230, 150, 30);
        txtTotalPagar.setFocusable(false);
        getContentPane().add(txtTotalPagar);

        
        JLabel lblLapiceros = new JLabel("Lapiceros de Obsequio:");
        lblLapiceros.setBounds(30, 270, 150, 30);
        getContentPane().add(lblLapiceros);

        txtLapiceros = new JTextField();
        txtLapiceros.setBounds(200, 270, 150, 30);
        txtLapiceros.setFocusable(false);
        getContentPane().add(txtLapiceros);

        
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularCompra();
            }
        });
    }

    private void calcularCompra() {
        try {
            double precioDocena = Double.parseDouble(txtPrecioDocena.getText());
            int cantidadDocenas = Integer.parseInt(txtCantidadDocenas.getText());
            double montoCompra = precioDocena * cantidadDocenas;
            double descuento;
            double totalPagar;
            int lapicerosObsequio = 0;

            
            if (cantidadDocenas >= 6) {
                descuento = montoCompra * 0.15; 
            } else {
                descuento = montoCompra * 0.10; 
            }

            
            totalPagar = montoCompra - descuento;

            
            if (cantidadDocenas >= 30) {
                lapicerosObsequio = (cantidadDocenas / 3) * 2; 
            }

           
            txtMontoCompra.setText(String.format("%.2f", montoCompra));
            txtDescuento.setText(String.format("%.2f", descuento));
            txtTotalPagar.setText(String.format("%.2f", totalPagar));
            txtLapiceros.setText(String.valueOf(lapicerosObsequio));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
