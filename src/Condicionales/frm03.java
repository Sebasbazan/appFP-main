package Condicionales; 

import javax.swing.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

public class frm03 extends JFrame {  
    private static final long serialVersionUID = 1L;  
    private JTextField txtAngulo, txtClasificacion;  
    private JButton btnCalcular;  

    public static void main(String[] args) {  
        SwingUtilities.invokeLater(() -> {  
            try {  
                frm03 frame = new frm03();  
                frame.setVisible(true);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        });  
    }  

    public frm03() {  
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setBounds(100, 100, 400, 200);  
        setLayout(null);  
        setLocationRelativeTo(null);  

          
        JLabel lblAngulo = new JLabel("Ingrese el ángulo en grados:");  
        lblAngulo.setBounds(30, 30, 200, 30);  
        getContentPane().add(lblAngulo);  

        txtAngulo = new JTextField();  
        txtAngulo.setBounds(230, 30, 100, 30);  
        getContentPane().add(txtAngulo);  

        btnCalcular = new JButton("Clasificar");  
        btnCalcular.setBounds(230, 70, 100, 30);  
        getContentPane().add(btnCalcular);  

        JLabel lblClasificacion = new JLabel("Clasificación:");  
        lblClasificacion.setBounds(30, 110, 200, 30);  
        getContentPane().add(lblClasificacion);  

        txtClasificacion = new JTextField();  
        txtClasificacion.setBounds(230, 110, 100, 30);  
        txtClasificacion.setFocusable(false);  
        getContentPane().add(txtClasificacion);  

          
        btnCalcular.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                clasificarAngulo();  
            }  
        });  
    }  

     
    private void clasificarAngulo() {  
        try {  
            int angulo = Integer.parseInt(txtAngulo.getText());  
            String clasificacion;  

             
            if (angulo == 0) {  
                clasificacion = "Nulo";  
            } else if (angulo > 0 && angulo < 90) {  
                clasificacion = "Agudo";  
            } else if (angulo == 90) {  
                clasificacion = "Recto";  
            } else if (angulo > 90 && angulo < 180) {  
                clasificacion = "Obtuso";  
            } else if (angulo == 180) {  
                clasificacion = "Llano";  
            } else if (angulo > 180 && angulo < 360) {  
                clasificacion = "Cóncavo";  
            } else if (angulo == 360) {  
                clasificacion = "Completo";  
            } else {  
                clasificacion = "Ángulo inválido";  
            }  

             
            txtClasificacion.setText(clasificacion);  
        } catch (NumberFormatException e) {  
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);  
        }  
    }  
}