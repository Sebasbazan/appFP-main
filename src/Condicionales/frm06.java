package Condicionales;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm06 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtEdad1, txtEdad2, txtEdad3, txtMayor, txtMenor;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm06 frame = new frm06();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm06() {
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 410, 325);
        setLayout(null);
        setLocationRelativeTo(null);

        // Etiquetas y campos de texto
        JLabel lblEdad1 = new JLabel("Edad 1:");
        lblEdad1.setBounds(30, 30, 150, 30);
        getContentPane().add(lblEdad1);

        txtEdad1 = new JTextField();
        txtEdad1.setBounds(200, 30, 150, 30);
        getContentPane().add(txtEdad1);

        JLabel lblEdad2 = new JLabel("Edad 2:");
        lblEdad2.setBounds(30, 70, 150, 30);
        getContentPane().add(lblEdad2);

        txtEdad2 = new JTextField();
        txtEdad2.setBounds(200, 70, 150, 30);
        getContentPane().add(txtEdad2);

        JLabel lblEdad3 = new JLabel("Edad 3:");
        lblEdad3.setBounds(30, 110, 150, 30);
        getContentPane().add(lblEdad3);

        txtEdad3 = new JTextField();
        txtEdad3.setBounds(200, 110, 150, 30);
        getContentPane().add(txtEdad3);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(200, 150, 150, 30);
        getContentPane().add(btnCalcular);

        JLabel lblMayor = new JLabel("Mayor:");
        lblMayor.setBounds(30, 190, 150, 30);
        getContentPane().add(lblMayor);

        txtMayor = new JTextField();
        txtMayor.setBounds(200, 190, 150, 30);
        txtMayor.setFocusable(false);
        getContentPane().add(txtMayor);

        JLabel lblMenor = new JLabel("Menor:");
        lblMenor.setBounds(30, 230, 150, 30);
        getContentPane().add(lblMenor);

        txtMenor = new JTextField();
        txtMenor.setBounds(200, 230, 150, 30);
        txtMenor.setFocusable(false);
        getContentPane().add(txtMenor);

        // Acción del botón Calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularEdades();
            }
        });
    }

    private void calcularEdades() {
        try {
            int edad1 = Integer.parseInt(txtEdad1.getText());
            int edad2 = Integer.parseInt(txtEdad2.getText());
            int edad3 = Integer.parseInt(txtEdad3.getText());

           
            int mayor = Math.max(edad1, Math.max(edad2, edad3));
            int menor = Math.min(edad1, Math.min(edad2, edad3));

            
            txtMayor.setText(String.valueOf(mayor));
            txtMenor.setText(String.valueOf(menor));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese edades válidas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }  

}