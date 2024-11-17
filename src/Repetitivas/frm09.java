package Repetitivas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm09 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtAltura;
    private JTextArea txtResultado;
    private JButton btnGenerar;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm09 frame = new frm09();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm09() {
        setTitle("Generador de Rectángulo de Asteriscos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblAltura = new JLabel("Altura (n, n >= 4):");
        lblAltura.setBounds(30, 30, 150, 30);
        getContentPane().add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(200, 30, 150, 30);
        getContentPane().add(txtAltura);

        btnGenerar = new JButton("Generar Rectángulo");
        btnGenerar.setBounds(200, 70, 150, 30);
        getContentPane().add(btnGenerar);

        txtResultado = new JTextArea();
        txtResultado.setBounds(30, 120, 350, 200);
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);

        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarRectangulo();
            }
        });
    }

    private void generarRectangulo(){
        try{
            int n = Integer.parseInt(txtAltura.getText());

            if ( n<4 ){
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número mayor o igual a 4.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            StringBuilder rectangulo = new StringBuilder();
            int ancho = 2 * n;
            for ( int i = 0; i < n; i++){
                for(int j = 0; j< ancho; j++){
                    rectangulo.append("*");
                }
                rectangulo.append("\n");
            }
            txtResultado.setText(rectangulo.toString());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
