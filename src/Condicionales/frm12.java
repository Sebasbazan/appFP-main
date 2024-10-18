package Condicionales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm12 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNumero;
    private JTextField txtDia;
    private JButton btnDeterminar;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm12 frame = new frm12();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm12() {
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        // Etiqueta y campo de texto para el número
        JLabel lblNumero = new JLabel("Ingrese un número (1-7):");
        lblNumero.setBounds(30, 30, 150, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(200, 30, 150, 30);
        getContentPane().add(txtNumero);

        // Botón para determinar el día
        btnDeterminar = new JButton("Determinar Día");
        btnDeterminar.setBounds(200, 70, 150, 30);
        getContentPane().add(btnDeterminar);

        // Etiqueta y campo de texto para el resultado
        JLabel lblDia = new JLabel("Día de la semana:");
        lblDia.setBounds(30, 110, 150, 30);
        getContentPane().add(lblDia);

        txtDia = new JTextField();
        txtDia.setBounds(200, 110, 150, 30);
        txtDia.setFocusable(false);
        getContentPane().add(txtDia);

        // Acción del botón Determinar
        btnDeterminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                determinarDia();
            }
        });
    }

    private void determinarDia() {
        try {
            int numero = Integer.parseInt(txtNumero.getText());
            String dia;

            switch (numero) {
                case 1:
                    dia = "Lunes";
                    break;
                case 2:
                    dia = "Martes";
                    break;
                case 3:
                    dia = "Miércoles";
                    break;
                case 4:
                    dia = "Jueves";
                    break;
                case 5:
                    dia = "Viernes";
                    break;
                case 6:
                    dia = "Sábado";
                    break;
                case 7:
                    dia = "Domingo";
                    break;
                default:
                    dia = "Número no válido. Ingrese un número entre 1 y 7.";
            }

            // Mostrar el resultado en el campo correspondiente
            txtDia.setText(dia);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}