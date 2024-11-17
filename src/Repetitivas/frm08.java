package Repetitivas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm08 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtBase;
    private JTextField txtExponente;
    private JTextArea txtResultado;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm08 frame = new frm08();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm08() {
        setTitle("Cálculo de Potencia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblBase = new JLabel("Base (n):");
        lblBase.setBounds(30, 30, 150, 30);
        getContentPane().add(lblBase);

        txtBase = new JTextField();
        txtBase.setBounds(200, 30, 150, 30);
        getContentPane().add(txtBase);

        JLabel lblExponente = new JLabel("Exponente (m):");
        lblExponente.setBounds(30, 70, 150, 30);
        getContentPane().add(lblExponente);

        txtExponente = new JTextField();
        txtExponente.setBounds(200, 70, 150, 30);
        getContentPane().add(txtExponente);

        btnCalcular = new JButton("Calcular Potencia");
        btnCalcular.setBounds(200, 110, 150, 30);
        getContentPane().add(btnCalcular);

        txtResultado = new JTextArea();
        txtResultado.setBounds(30, 160, 350, 100);
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPotencia();
            }
        });
    }

    private void calcularPotencia() {
        try {
            double base = Double.parseDouble(txtBase.getText());
            int exponente = Integer.parseInt(txtExponente.getText());
            double resultado = 1;

            for (int i = 1; i <= Math.abs(exponente); i++) {
                resultado *= base;
            }

            if (exponente < 0) {
                resultado = 1 / resultado;
            }

            txtResultado.setText("La potencia de " + base + " elevado a " + exponente + " es: " + resultado);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
