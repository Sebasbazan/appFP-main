package Repetitivas;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*; 

public class frm03 extends JFrame {  
    private JTextField txtNumero;
    private JLabel lblResultado;  

    public frm03() {  

        setTitle("Cantidad de Divisores");  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(300, 200);  
        setLayout(null);   
        setLocationRelativeTo(null);  

        JLabel lblNumero = new JLabel("Número entero:");  
        lblNumero.setBounds(50, 30, 120, 30);  
        add(lblNumero);  

        txtNumero = new JTextField();  
        txtNumero.setBounds(160, 30, 80, 30);  
        add(txtNumero);  
        
        JButton btnCalcular = new JButton("Calcular Divisores");  
        btnCalcular.setBounds(50, 70, 190, 30);  
        add(btnCalcular);  
        
        lblResultado = new JLabel("Cantidad de divisores: ");  
        lblResultado.setBounds(50, 110, 300, 30);  
        add(lblResultado);  
        
        btnCalcular.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                calcularDivisores();  
            }  
        });  
    }  

    private void calcularDivisores(){
        try{
            int numero = Integer.parseInt(txtNumero.getText());
            int contadorDivisores = 0;
            
            for(int i = 1; i <= Math.abs(numero); i++){
                if(numero % i == 0){
                    contadorDivisores++;
                }
            }
            lblResultado.setText("Cantidad de divisores: " + contadorDivisores);
        }catch(NumberFormatException e){
            lblResultado.setText("Por favor, ingrese el número entero válido ");
        }
    }
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            frm03 frame = new frm03();
            frame.setVisible(true);
        });
    }
}