package Condicionales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm25 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtSueldoBruto;
    private JTextField txtNumeroHijos;
    private JTextField txtBonificacion;
    private JTextField txtSueldoNeto;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm25 frame = new frm25();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm25() {
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        // Etiqueta y campo de texto para el sueldo bruto
        JLabel lblSueldoBruto = new JLabel("Sueldo Bruto:");
        lblSueldoBruto.setBounds(30, 30, 150, 30);
        getContentPane().add(lblSueldoBruto);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(200, 30, 150, 30);
        getContentPane().add(txtSueldoBruto);

        // Etiqueta y campo de texto para el número de hijos
        JLabel lblNumeroHijos = new JLabel("Número de Hijos:");
        lblNumeroHijos.setBounds(30, 70, 150, 30);
        getContentPane().add(lblNumeroHijos);

        txtNumeroHijos = new JTextField();
        txtNumeroHijos.setBounds(200, 70, 150, 30);
        getContentPane().add(txtNumeroHijos);

        // Botón para calcular
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(200, 110, 150, 30);
        getContentPane().add(btnCalcular);

        // Etiqueta y campo de texto para la bonificación
        JLabel lblBonificacion = new JLabel("Bonificación:");
        lblBonificacion.setBounds(30, 150, 150, 30);
        getContentPane().add(lblBonificacion);

        txtBonificacion = new JTextField();
        txtBonificacion.setBounds(200, 150, 150, 30);
        txtBonificacion.setFocusable(false);
        getContentPane().add(txtBonificacion);

        // Etiqueta y campo de texto para el sueldo neto
        JLabel lblSueldoNeto = new JLabel("Sueldo Neto:");
        lblSueldoNeto.setBounds(30, 190, 150, 30);
        getContentPane().add(lblSueldoNeto);

        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setBounds(200, 190, 150, 30);
        txtSueldoNeto.setFocusable(false);
        getContentPane().add(txtSueldoNeto);

        // Acción del botón Calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularBonificacion();
            }
        });
    }

    private void calcularBonificacion() {
        try {
            double sueldoBruto = Double.parseDouble(txtSueldoBruto.getText());
            int numeroHijos = Integer.parseInt(txtNumeroHijos.getText());
            double bonificacion;
            double sueldoNeto;

           
            if (numeroHijos > 1) {
                bonificacion = sueldoBruto * 0.125 + (numeroHijos * 40);
            } else {
                bonificacion = sueldoBruto * 0.10; 
            }

         
            sueldoNeto = sueldoBruto + bonificacion;

         
            txtBonificacion.setText(String.format("%.2f", bonificacion));
            txtSueldoNeto.setText(String.format("%.2f", sueldoNeto));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}