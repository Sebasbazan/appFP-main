package Repetitivas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm07 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNumero;
    private JTextArea txtResultado;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm07 frame = new frm07();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm07() {
        setTitle("Cálculo de Factorial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setBounds(30, 30, 150, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(200, 30, 150, 30);
        getContentPane().add(txtNumero);

        btnCalcular = new JButton("Calcular Factorial");
        btnCalcular.setBounds(200, 70, 150, 30);
        getContentPane().add(btnCalcular);

        txtResultado = new JTextArea();
        txtResultado.setBounds(30, 120, 350, 100);
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularFactorial();
            }
        });
    }

    private void calcularFactorial(){
        try {
            int numero = Integer.parseInt(txtNumero.getText());
            if ( numero < 0){
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número no negativo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            long factorial = 1;
            for (int i = 1; i<= numero; i++){
                factorial *= i;
            }
            txtResultado.setText("El factorial de " + numero + " es: " + factorial);

        }catch ( NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}