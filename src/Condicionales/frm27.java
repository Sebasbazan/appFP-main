package Condicionales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm27 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtMontoVendido;
    private JTextField txtSueldoBruto;
    private JTextField txtDescuento;
    private JTextField txtSueldoNeto;
    private JTextField txtPolos;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm27 frame = new frm27();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm27() {
        // Configuración de la ventana
        setTitle("Cálculo de Sueldo de Vendedores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 360);
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

        // Etiqueta y campo de texto para el sueldo bruto
        JLabel lblSueldoBruto = new JLabel("Sueldo Bruto:");
        lblSueldoBruto.setBounds(30, 110, 150, 30);
        getContentPane().add(lblSueldoBruto);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(200, 110, 150, 30);
        txtSueldoBruto.setFocusable(false);
        getContentPane().add(txtSueldoBruto);

        // Etiqueta y campo de texto para el descuento
        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(30, 150, 150, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(200, 150, 150, 30);
        txtDescuento.setFocusable(false);
        getContentPane().add(txtDescuento);

        // Etiqueta y campo de texto para el sueldo neto
        JLabel lblSueldoNeto = new JLabel("Sueldo Neto:");
        lblSueldoNeto.setBounds(30, 190, 150, 30);
        getContentPane().add(lblSueldoNeto);

        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setBounds(200, 190, 150, 30);
        txtSueldoNeto.setFocusable(false);
        getContentPane().add(txtSueldoNeto);

        // Etiqueta y campo de texto para los polos obsequiados
        JLabel lblPolos = new JLabel("Polos Obsequiados:");
        lblPolos.setBounds(30, 230, 150, 30);
        getContentPane().add(lblPolos);

        txtPolos = new JTextField();
        txtPolos.setBounds(200, 230, 150, 30);
        txtPolos.setFocusable(false);
        getContentPane().add(txtPolos);

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
            double sueldoBasico = 600;
            double comision = montoVendido * 0.15;
            double sueldoBruto = sueldoBasico + comision;
            double descuento;
            double sueldoNeto;
            int polos;

         
            if (sueldoBruto > 1800) {
                descuento = sueldoBruto * 0.10;
            } else {
                descuento = sueldoBruto * 0.05;
            }

           
            sueldoNeto = sueldoBruto - descuento;

          
            if (montoVendido > 1000) {
                polos = 3;
            } else {
                polos = 1;
            }

           
            txtSueldoBruto.setText(String.format("%.2f", sueldoBruto));
            txtDescuento.setText(String.format("%.2f", descuento));
            txtSueldoNeto.setText(String.format("%.2f", sueldoNeto));
            txtPolos.setText(String.valueOf(polos));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}