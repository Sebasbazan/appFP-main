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
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 370);
        setLayout(null);
        setLocationRelativeTo(null);

        // Etiqueta y campo de texto para el precio por docena
        JLabel lblPrecioDocena = new JLabel("Precio por Docena:");
        lblPrecioDocena.setBounds(30, 30, 150, 30);
        getContentPane().add(lblPrecioDocena);

        txtPrecioDocena = new JTextField();
        txtPrecioDocena.setBounds(200, 30, 150, 30);
        getContentPane().add(txtPrecioDocena);

        // Etiqueta y campo de texto para la cantidad de docenas
        JLabel lblCantidadDocenas = new JLabel("Cantidad de Docenas:");
        lblCantidadDocenas.setBounds(30, 70, 150, 30);
        getContentPane().add(lblCantidadDocenas);

        txtCantidadDocenas = new JTextField();
        txtCantidadDocenas.setBounds(200, 70, 150, 30);
        getContentPane().add(txtCantidadDocenas);

        // Botón para calcular
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(200, 110, 150, 30);
        getContentPane().add(btnCalcular);

        // Etiqueta y campo de texto para el monto de compra
        JLabel lblMontoCompra = new JLabel("Monto de Compra:");
        lblMontoCompra.setBounds(30, 150, 150, 30);
        getContentPane().add(lblMontoCompra);

        txtMontoCompra = new JTextField();
        txtMontoCompra.setBounds(200, 150, 150, 30);
        txtMontoCompra.setFocusable(false);
        getContentPane().add(txtMontoCompra);

        // Etiqueta y campo de texto para el descuento
        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(30, 190, 100, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(200, 190, 150, 30);
        txtDescuento.setFocusable(false);
        getContentPane().add(txtDescuento);

        // Etiqueta y campo de texto para el total a pagar
        JLabel lblTotalPagar = new JLabel("Total a Pagar:");
        lblTotalPagar.setBounds(30, 230, 100, 30);
        getContentPane().add(lblTotalPagar);

        txtTotalPagar = new JTextField();
        txtTotalPagar.setBounds(200, 230, 150, 30);
        txtTotalPagar.setFocusable(false);
        getContentPane().add(txtTotalPagar);

        // Etiqueta y campo de texto para los lapiceros de obsequio
        JLabel lblLapiceros = new JLabel("Lapiceros de Obsequio:");
        lblLapiceros.setBounds(30, 270, 150, 30);
        getContentPane().add(lblLapiceros);

        txtLapiceros = new JTextField();
        txtLapiceros.setBounds(200, 270, 150, 30);
        txtLapiceros.setFocusable(false);
        getContentPane().add(txtLapiceros);

        // Acción del botón Calcular
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

            // Aplicar el descuento según la cantidad de docenas
            if (cantidadDocenas >= 6) {
                descuento = montoCompra * 0.15; // 15% de descuento
            } else {
                descuento = montoCompra * 0.10; // 10% de descuento
            }

            // Calcular el total a pagar
            totalPagar = montoCompra - descuento;

            // Calcular los lapiceros de obsequio si aplica
            if (cantidadDocenas >= 30) {
                lapicerosObsequio = (cantidadDocenas / 3) * 2; // 2 lapiceros por cada 3 docenas
            }

            // Mostrar los resultados
            txtMontoCompra.setText(String.format("%.2f", montoCompra));
            txtDescuento.setText(String.format("%.2f", descuento));
            txtTotalPagar.setText(String.format("%.2f", totalPagar));
            txtLapiceros.setText(String.valueOf(lapicerosObsequio));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
