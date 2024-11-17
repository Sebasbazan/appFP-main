package Repetitivas;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

public class frm05 extends JFrame {  
    private JTextField txtNumero; 
    private JTextArea txtResultado; 

    public frm05() { 
        setTitle("Tabla de Multiplicar"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(300, 250); 
        setLayout(null);  
        setLocationRelativeTo(null);   
        
        JLabel lblNumero = new JLabel("Número n:");  
        lblNumero.setBounds(50, 30, 100, 30);  
        add(lblNumero);  

        txtNumero = new JTextField();  
        txtNumero.setBounds(150, 30, 80, 30);  
        add(txtNumero);  
        
        JButton btnCalcular = new JButton("Generar Tabla");  
        btnCalcular.setBounds(50, 70, 180, 30);  
        add(btnCalcular);  
        
        txtResultado = new JTextArea();  
        txtResultado.setBounds(50, 110, 200, 100);  
        txtResultado.setEditable(false);   
        add(txtResultado);  
        
        btnCalcular.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                generarTablaMultiplicar();  
            }  
        });  
    }  
    
    private void generarTablaMultiplicar(){
        try{
            int numero = Integer.parseInt(txtNumero.getText());
            StringBuilder resultado = new StringBuilder("Tabla de Multiplicar de " + numero + ":\n\n");

            for (int i = 1; i <= 12; i++){
                resultado.append(numero).append(" x ").append(i).append(" = ").append(numero * i).append("\n");
            }
            txtResultado.setText(resultado.toString());
        }catch(NumberFormatException e){
            txtResultado.setText("Por favor, ingrese un número válido.");
        }
    }

    public static void main(String[] args) {  
        EventQueue.invokeLater(() -> {  
            frm05 frame = new frm05();  
            frame.setVisible(true);  
        });  
    }  
}
