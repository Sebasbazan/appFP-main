package Condicionales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm21 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNumero;
    private JTextField txtEstadoCivil;
    private JTextField txtEdad;
    private JTextField txtSexo;
    private JButton btnProcesar;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm21 frame = new frm21();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm21() {
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        // Etiqueta y campo de texto para el número del empleado
        JLabel lblNumero = new JLabel("Número del Empleado:");
        lblNumero.setBounds(30, 30, 150, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(200, 30, 150, 30);
        getContentPane().add(txtNumero);

        // Botón para procesar
        btnProcesar = new JButton("Procesar");
        btnProcesar.setBounds(200, 70, 150, 30);
        getContentPane().add(btnProcesar);

        // Etiqueta y campo de texto para el estado civil
        JLabel lblEstadoCivil = new JLabel("Estado Civil:");
        lblEstadoCivil.setBounds(30, 110, 150, 30);
        getContentPane().add(lblEstadoCivil);

        txtEstadoCivil = new JTextField();
        txtEstadoCivil.setBounds(200, 110, 150, 30);
        txtEstadoCivil.setFocusable(false);
        getContentPane().add(txtEstadoCivil);

        // Etiqueta y campo de texto para la edad
        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(30, 150, 150, 30);
        getContentPane().add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(200, 150, 150, 30);
        txtEdad.setFocusable(false);
        getContentPane().add(txtEdad);

        // Etiqueta y campo de texto para el sexo
        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(30, 190, 150, 30);
        getContentPane().add(lblSexo);

        txtSexo = new JTextField();
        txtSexo.setBounds(200, 190, 150, 30);
        txtSexo.setFocusable(false);
        getContentPane().add(txtSexo);

        // Acción del botón Procesar
        btnProcesar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarNumero();
            }
        });
    }

    private void procesarNumero(){
        try{
            int numero = Integer.parseInt(txtNumero.getText());

            int estadoCivil = numero / 1000;
            int edad = ( numero / 10)%100;
            int sexo = numero % 10;
            String estado;
            switch (estadoCivil) {
                case 1: estado = "Soltero"; break;
                case 2: estado = "Casado"; break;
                case 3: estado = "Divorciado"; break;
                case 4: estado = "Viudo"; break;
                default: estado = "Desconocido"; break;
            }

            // Determinar el sexo
            String genero;
            if (sexo == 1) {
                genero = "Masculino";
            } else if (sexo == 2) {
                genero = "Femenino";
            } else {
                genero = "Desconocido";
            }

            // Mostrar los resultados
            txtEstadoCivil.setText(estado);
            txtEdad.setText(String.valueOf(edad));
            txtSexo.setText(genero);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido de 4 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

