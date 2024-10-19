package Condicionales;  

import javax.swing.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.util.Arrays;  

public class frm05 extends JFrame {  
    private static final long serialVersionUID = 1L;  
    
    
    private JTextField txtNumero, txtResultado;  
    private JButton btnCalcular;  

    public static void main(String[] args) {  
        SwingUtilities.invokeLater(() -> {  
            try {  
                frm05 frame = new frm05();  
                frame.setVisible(true);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        });  
    }  

    public frm05() {  
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setBounds(100, 100, 400, 200);  
        setLayout(null);  
        setLocationRelativeTo(null);  

          
        initializeComponents();  
    }  

    private void initializeComponents() {  
       
        JLabel lblNumero = new JLabel("Ingrese un número de 4 cifras:");  
        lblNumero.setBounds(30, 30, 200, 30);  
        getContentPane().add(lblNumero);  

        txtNumero = new JTextField();  
        txtNumero.setBounds(230, 30, 100, 30);  
        getContentPane().add(txtNumero);  

        btnCalcular = new JButton("Calcular");  
        btnCalcular.setBounds(230, 70, 100, 30);  
        getContentPane().add(btnCalcular);  

        JLabel lblResultado = new JLabel("Mayor número de 2 cifras:");  
        lblResultado.setBounds(30, 110, 200, 30);  
        getContentPane().add(lblResultado);  

        txtResultado = new JTextField();  
        txtResultado.setBounds(230, 110, 100, 30);  
        txtResultado.setFocusable(false);  
        getContentPane().add(txtResultado);  

        
        btnCalcular.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                calcularMayorMenorCifras();  
            }  
        });  
    }  

     
    private void calcularMayorMenorCifras() {  
        try {  
            int numero = Integer.parseInt(txtNumero.getText());  

              
            if (numero < 1000 || numero > 9999) {  
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número de 4 cifras.", "Error", JOptionPane.ERROR_MESSAGE);  
                return;  
            }  

             
            int[] cifras = new int[4];  
            cifras[0] = numero / 1000;           
            cifras[1] = (numero / 100) % 10;     
            cifras[2] = (numero / 10) % 10;     
            cifras[3] = numero % 10;              

             
            Arrays.sort(cifras);  
            int mayor = cifras[3];   
            int menor = cifras[0];   

             
            int mayorNumeroDosCifras = mayor * 10 + menor;  

             
            txtResultado.setText(String.valueOf(mayorNumeroDosCifras));  

        } catch (NumberFormatException e) {  
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);  
        }  
    }  
}