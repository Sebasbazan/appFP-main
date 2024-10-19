package Condicionales;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm15 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtMontoVendido, txtComision, txtSueldoBruto, txtDescuento, txtSueldoNeto;
    private JButton btnCalcular;

    public frm15() {
        setTitle("Cálculo de Sueldo Vendedor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Monto Vendido:"));
        txtMontoVendido = new JTextField();
        add(txtMontoVendido);

        add(new JLabel("Comisión %:"));
        txtComision = new JTextField();
        txtComision.setEditable(false);
        add(txtComision);

        add(new JLabel("Sueldo Bruto:"));
        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setEditable(false);
        add(txtSueldoBruto);

        add(new JLabel("Descuento:"));
        txtDescuento = new JTextField();
        txtDescuento.setEditable(false);
        add(txtDescuento);

        add(new JLabel("Sueldo Neto:"));
        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setEditable(false);
        add(txtSueldoNeto);

        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSueldo();
            }
        });
        add(btnCalcular);
    }

    private void calcularSueldo() {
        double sueldoBase = 250;
        double montoVendido;
        double comision = 0;
        double sueldoBruto;
        double descuento;
        double sueldoNeto;

        try {
            
            montoVendido = Double.parseDouble(txtMontoVendido.getText());

           
            if (montoVendido < 5000) {
                comision = 0.05; 
            } else if (montoVendido < 10000) {
                comision = 0.08; 
            } else if (montoVendido < 20000) {
                comision = 0.10; 
            } else {
                comision = 0.15; 
            }

            
            double comisionMonto = montoVendido * comision;
            txtComision.setText(String.valueOf(comisionMonto));

            
            sueldoBruto = sueldoBase + comisionMonto;
            txtSueldoBruto.setText(String.valueOf(sueldoBruto));

            
            if (sueldoBruto > 3500) {
                descuento = sueldoBruto * 0.15; 
            } else {
                descuento = sueldoBruto * 0.08; 
            }
            txtDescuento.setText(String.valueOf(descuento));

           
            sueldoNeto = sueldoBruto - descuento;
            txtSueldoNeto.setText(String.valueOf(sueldoNeto));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un monto válido.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm15 frame = new frm15();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}