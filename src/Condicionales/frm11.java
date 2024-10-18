package Condicionales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm11 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNumero;
    private JTextField txtResultado;
    private JButton btnDeterminar;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm11 frame = new frm11();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm11() {
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        // Etiqueta y campo de texto para el número
        JLabel lblNumero = new JLabel("Ingrese un número:");
        lblNumero.setBounds(30, 30, 150, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(200, 30, 100, 30);
        getContentPane().add(txtNumero);

        // Botón para determinar el signo
        btnDeterminar = new JButton("Determinar Signo");
        btnDeterminar.setBounds(200, 70, 100, 30);
        getContentPane().add(btnDeterminar);

        // Etiqueta y campo de texto para el resultado
        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(30, 110, 150, 30);
        getContentPane().add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(200, 110, 100, 30);
        txtResultado.setFocusable(false);
        getContentPane().add(txtResultado);

        // Acción del botón Determinar
        btnDeterminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                determinarSigno();
            }
        });
    }

    private void determinarSigno(){
        try{
            double numero = Double.parseDouble(txtNumero.getText());
            String resultado;
            if (numero > 0) {
                resultado = "Positivo";
            }else if (numero < 0){
                resultado = "Negativo";
            }else{
                resultado = "Cero";
            }
            txtResultado.setText(resultado);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

}