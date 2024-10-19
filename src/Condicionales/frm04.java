package Condicionales; 
import javax.swing.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

public class frm04 extends JFrame {  
    private static final long serialVersionUID = 1L;  
    private JTextField txtPractica1, txtPractica2, txtPractica3, txtPromedioFinal;  
    private JButton btnCalcular;  

    public static void main(String[] args) {  
        SwingUtilities.invokeLater(() -> {  
            try {  
                frm04 frame = new frm04();  
                frame.setVisible(true);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        });  
    }  

    public frm04() {  
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setBounds(100, 100, 410, 300);  
        setLayout(null);  
        setLocationRelativeTo(null);  

        
        JLabel lblPractica1 = new JLabel("Nota de la Práctica 1:");  
        lblPractica1.setBounds(30, 30, 150, 30);  
        getContentPane().add(lblPractica1);  

        txtPractica1 = new JTextField();  
        txtPractica1.setBounds(200, 30, 150, 30);  
        getContentPane().add(txtPractica1);  

        JLabel lblPractica2 = new JLabel("Nota de la Práctica 2:");  
        lblPractica2.setBounds(30, 70, 150, 30);  
        getContentPane().add(lblPractica2);  

        txtPractica2 = new JTextField();  
        txtPractica2.setBounds(200, 70, 150, 30);  
        getContentPane().add(txtPractica2);  

        JLabel lblPractica3 = new JLabel("Nota de la Práctica 3:");  
        lblPractica3.setBounds(30, 110, 150, 30);  
        getContentPane().add(lblPractica3);  

        txtPractica3 = new JTextField();  
        txtPractica3.setBounds(200, 110, 150, 30);  
        getContentPane().add(txtPractica3);  

        btnCalcular = new JButton("Calcular Promedio");  
        btnCalcular.setBounds(100, 150, 200, 30);  
        getContentPane().add(btnCalcular);  

        JLabel lblPromedioFinal = new JLabel("Promedio Final:");  
        lblPromedioFinal.setBounds(30, 190, 150, 30);  
        getContentPane().add(lblPromedioFinal);  

        txtPromedioFinal = new JTextField();  
        txtPromedioFinal.setBounds(200, 190, 150, 30);  
        txtPromedioFinal.setFocusable(false);  
        getContentPane().add(txtPromedioFinal);  

         
        btnCalcular.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                calcularPromedioFinal();  
            }  
        });  
    }  

      
    private void calcularPromedioFinal() {  
        try {  
            double practica1 = Double.parseDouble(txtPractica1.getText());  
            double practica2 = Double.parseDouble(txtPractica2.getText());  
            double practica3 = Double.parseDouble(txtPractica3.getText());  
            
            
            if (practica3 >= 10) {  
                practica3 += 2;  
            }  

             
            double promedioFinal = (practica1 + practica2 + practica3) / 3;  

             
            txtPromedioFinal.setText(String.format("%.2f", promedioFinal));  
        } catch (NumberFormatException e) {  
            JOptionPane.showMessageDialog(this, "Por favor, ingrese notas válidas.", "Error", JOptionPane.ERROR_MESSAGE);  
        }  
    }  
}