package Condicionales;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm28 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtHora24;
    private JTextField txtHora12;
    private JButton btnConvertir;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm28 frame = new frm28();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm28() {
        
        setTitle("Conversión de Hora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        
        JLabel lblHora24 = new JLabel("Hora (24 horas):");
        lblHora24.setBounds(30, 30, 150, 30);
        getContentPane().add(lblHora24);

        txtHora24 = new JTextField();
        txtHora24.setBounds(150, 30, 100, 30);
        getContentPane().add(txtHora24);

        
        btnConvertir = new JButton("Convertir");
        btnConvertir.setBounds(150, 70, 100, 30);
        getContentPane().add(btnConvertir);

       
        JLabel lblHora12 = new JLabel("Hora (12 horas):");
        lblHora12.setBounds(30, 110, 150, 30);
        getContentPane().add(lblHora12);

        txtHora12 = new JTextField();
        txtHora12.setBounds(150, 110, 100, 30);
        txtHora12.setFocusable(false);
        getContentPane().add(txtHora12);

        
        btnConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirHora();
            }
        });
    }

    private void convertirHora() {
        try {
            String[] parts = txtHora24.getText().split(":");
            if (parts.length != 2) {
                throw new IllegalArgumentException();
            }

            int hora = Integer.parseInt(parts[0]);
            int minutos = Integer.parseInt(parts[1]);

         
            if (hora < 0 || hora > 23 || minutos < 0 || minutos > 59) {
                throw new IllegalArgumentException();
            }

            String ampm;
            if (hora >= 12) {
                ampm = "PM";
            } else {
                ampm = "AM";
            }

           
            int hora12 = hora % 12;
            if (hora12 == 0) {
                hora12 = 12; 
            }

         
            txtHora12.setText(String.format("%02d:%02d %s", hora12, minutos, ampm));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una hora válida.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Hora o minutos inválidos. Asegúrese de usar el formato HH:MM.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}