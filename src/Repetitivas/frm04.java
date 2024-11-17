package Repetitivas;
import javax.swing.*;   
import java.awt.*;   
import java.awt.event.*;  

public class frm04 extends JFrame {  
    private JTextField txtNumero;  
    private JTextField txtMultiplicadores;
    private JTextArea txtResultado;  

    public frm04() {   
        setTitle("Múltiplos de un Número");  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(400, 300); 
        setLayout(null);   
        setLocationRelativeTo(null); 
        
        JLabel lblNumero = new JLabel("Número n:");  
        lblNumero.setBounds(50, 30, 100, 30);  
        add(lblNumero);  

        txtNumero = new JTextField();  
        txtNumero.setBounds(150, 30, 80, 30);  
        add(txtNumero);  
        
        JLabel lblMultiplicadores = new JLabel("Cantidad m:");  
        lblMultiplicadores.setBounds(50, 70, 100, 30);  
        add(lblMultiplicadores);  

        txtMultiplicadores = new JTextField();  
        txtMultiplicadores.setBounds(150, 70, 80, 30);  
        add(txtMultiplicadores);  
        
        JButton btnCalcular = new JButton("Calcular Múltiplos");  
        btnCalcular.setBounds(50, 110, 180, 30);  
        add(btnCalcular);  
        
        txtResultado = new JTextArea();  
        txtResultado.setBounds(50, 150, 280, 100);  
        txtResultado.setEditable(false); 
        add(txtResultado);  
        
        btnCalcular.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                calcularMultiplos();  
            }  
        });  
    } 
    
    private void calcularMultiplos(){
        try{
            int numero = Integer.parseInt(txtNumero.getText());
            int cantidad = Integer.parseInt(txtMultiplicadores.getText());
            StringBuilder resultado = new StringBuilder("Múltiplos de " + numero + ":\n");

            for (int i = 1; i <= cantidad; i++){
                resultado.append(numero * i ).append("\n");
            }

            txtResultado.setText(resultado.toString());
        }catch(NumberFormatException e){
            txtResultado.setText("Por favor, ingrese números válidos.");
        }
    }

    public static void main(String[] args) {  
        EventQueue.invokeLater(() -> {  
            frm04 frame = new frm04();  
            frame.setVisible(true);  
        });  
    }  
}