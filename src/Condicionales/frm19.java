package Condicionales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm19 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtEdad;
    private JTextField txtCategoria;
    private JButton btnCalcular;
    private JComboBox<String> cmbSexo;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm19 frame = new frm19();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm19() {
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        
        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(30, 30, 100, 30);
        getContentPane().add(lblSexo);

        cmbSexo = new JComboBox<>(new String[]{"Femenino", "Masculino"});
        cmbSexo.setBounds(200, 30, 150, 30);
        getContentPane().add(cmbSexo);

       
        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(30, 70, 100, 30);
        getContentPane().add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(200, 70, 150, 30);
        getContentPane().add(txtEdad);

        
        btnCalcular = new JButton("Calcular Categoría");
        btnCalcular.setBounds(200, 110, 150, 30);
        getContentPane().add(btnCalcular);

        
        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setBounds(30, 150, 100, 30);
        getContentPane().add(lblCategoria);

        txtCategoria = new JTextField();
        txtCategoria.setBounds(200, 150, 150, 30);
        txtCategoria.setFocusable(false);
        getContentPane().add(txtCategoria);

        
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularCategoria();
            }
        });
    }

    private void calcularCategoria() {
        try {
            String sexo = (String) cmbSexo.getSelectedItem();
            int edad = Integer.parseInt(txtEdad.getText());
            String categoria;

            if (sexo.equals("Femenino")) {
                
                if (edad < 23) {
                    categoria = "FA";
                } else {
                    categoria = "FB";
                }
            } else if (sexo.equals("Masculino")) {
                
                if (edad < 25) {
                    categoria = "MA";
                } else {
                    categoria = "MB";
                }
            } else {
                categoria = "Desconocido";
            }

            
            txtCategoria.setText(categoria);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una edad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}