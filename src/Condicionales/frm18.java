package Condicionales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm18 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtMontoDonacion;
    private JTextField txtCentroSalud;
    private JTextField txtComedor;
    private JTextField txtBolsa;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm18 frame = new frm18();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm18() {
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        // Etiqueta y campo de texto para el monto de donación
        JLabel lblMontoDonacion = new JLabel("Monto de Donación:");
        lblMontoDonacion.setBounds(30, 30, 150, 30);
        getContentPane().add(lblMontoDonacion);

        txtMontoDonacion = new JTextField();
        txtMontoDonacion.setBounds(200, 30, 150, 30);
        getContentPane().add(txtMontoDonacion);

        // Botón para calcular la distribución
        btnCalcular = new JButton("Calcular Distribución");
        btnCalcular.setBounds(200, 70, 150, 30);
        getContentPane().add(btnCalcular);

        // Etiqueta y campo de texto para el centro de salud
        JLabel lblCentroSalud = new JLabel("Centro de Salud:");
        lblCentroSalud.setBounds(30, 110, 150, 30);
        getContentPane().add(lblCentroSalud);

        txtCentroSalud = new JTextField();
        txtCentroSalud.setBounds(200, 110, 150, 30);
        txtCentroSalud.setFocusable(false);
        getContentPane().add(txtCentroSalud);

        // Etiqueta y campo de texto para el comedor
        JLabel lblComedor = new JLabel("Comedor de Niños:");
        lblComedor.setBounds(30, 150, 150, 30);
        getContentPane().add(lblComedor);

        txtComedor = new JTextField();
        txtComedor.setBounds(200, 150, 150, 30);
        txtComedor.setFocusable(false);
        getContentPane().add(txtComedor);

        // Etiqueta y campo de texto para la bolsa
        JLabel lblBolsa = new JLabel("Inversiones en Bolsa:");
        lblBolsa.setBounds(30, 190, 150, 30);
        getContentPane().add(lblBolsa);

        txtBolsa = new JTextField();
        txtBolsa.setBounds(200, 190, 150, 30);
        txtBolsa.setFocusable(false);
        getContentPane().add(txtBolsa);

        // Acción del botón Calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularDistribucion();
            }
        });
    }

    private void calcularDistribucion(){
        try {
            double montoDonacion = Double.parseDouble(txtMontoDonacion.getText());
            double centroSalud, comedorNinos, bolsaInversiones;

            if (montoDonacion >= 10000){
                centroSalud = montoDonacion * 0.30;
                comedorNinos = montoDonacion * 0.50;
                bolsaInversiones = montoDonacion *0.20;
            }else{
                centroSalud = montoDonacion * 0.25;
                comedorNinos = montoDonacion * 0.60;
                bolsaInversiones = montoDonacion * 0.15;
            }

            txtCentroSalud.setText(String.format("%.2f", centroSalud));
            txtComedor.setText(String.format("%.2f", comedorNinos));
            txtBolsa.setText(String.format("%.2f", bolsaInversiones));

        }catch ( NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
