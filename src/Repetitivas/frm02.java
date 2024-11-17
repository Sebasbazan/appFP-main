package Repetitivas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class frm02 extends JFrame {
    private JTextField txtMultiplicando;
    private JTextField txtMultiplicador;
    private JLabel lblResultado;

    public frm02(){
        setTitle("Multiplicación");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblMultiplicando = new JLabel("Multiplicando: ");
        lblMultiplicando.setBounds(50, 30, 100, 30);
        add(lblMultiplicando);

        txtMultiplicando = new JTextField();
        txtMultiplicando.setBounds(160, 30, 100, 30);
        add(txtMultiplicando);

        JLabel lblMultiplicador = new JLabel("Multiplicador: ");
        lblMultiplicador.setBounds(50, 70, 100, 30);
        add(lblMultiplicador);

        txtMultiplicador = new JTextField();
        txtMultiplicador.setBounds(160, 70, 100, 30);
        add(txtMultiplicador);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(50, 110, 190, 30);
        add(btnCalcular);

        lblResultado = new JLabel("Resultado");
        lblResultado.setBounds(50, 150, 300, 30);
        add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                calcularProducto();
            }
        });
    }
    private void calcularProducto() {  
        try {  
            int multiplicando = Integer.parseInt(txtMultiplicando.getText());  
            int multiplicador = Integer.parseInt(txtMultiplicador.getText());  
            int producto = 0;  
            
            for (int i = 0; i < Math.abs(multiplicador); i++) {  
                producto += multiplicando;  
            }  
            
            if (multiplicador < 0) {  
                producto = -producto;  
            }  
            
            lblResultado.setText("Resultado: " + producto);  
        } catch (NumberFormatException e) {  
            lblResultado.setText("Por favor, ingrese números válidos.");  
        }  
    }  

    public static void main(String[] args) {  
        EventQueue.invokeLater(() -> {  
            frm02 frame = new frm02();  
            frame.setVisible(true);  
        });  
    }  
}
