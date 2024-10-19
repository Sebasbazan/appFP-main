package Condicionales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm20 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNumeroA;
    private JTextField txtNumeroB;
    private JTextField txtNumeroC;
    private JTextField txtResultado;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm20 frame = new frm20();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm20() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

       
        JLabel lblNumeroA = new JLabel("Número A:");
        lblNumeroA.setBounds(30, 30, 100, 30);
        getContentPane().add(lblNumeroA);

        txtNumeroA = new JTextField();
        txtNumeroA.setBounds(200, 30, 150, 30);
        getContentPane().add(txtNumeroA);

        
        JLabel lblNumeroB = new JLabel("Número B:");
        lblNumeroB.setBounds(30, 70, 100, 30);
        getContentPane().add(lblNumeroB);

        txtNumeroB = new JTextField();
        txtNumeroB.setBounds(200, 70, 150, 30);
        getContentPane().add(txtNumeroB);

        
        JLabel lblNumeroC = new JLabel("Número C:");
        lblNumeroC.setBounds(30, 110, 100, 30);
        getContentPane().add(lblNumeroC);

        txtNumeroC = new JTextField();
        txtNumeroC.setBounds(200, 110, 150, 30);
        getContentPane().add(txtNumeroC);

        
        btnCalcular = new JButton("Calcular Orden");
        btnCalcular.setBounds(200, 150, 150, 30);
        getContentPane().add(btnCalcular);

        
        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(30, 190, 100, 30);
        getContentPane().add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(200, 190, 150, 30);
        txtResultado.setFocusable(false);
        getContentPane().add(txtResultado);

        
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularOrden();
            }
        });
    }

    private void calcularOrden(){
        try{
            int a = Integer.parseInt(txtNumeroA.getText());
            int b = Integer.parseInt(txtNumeroB.getText());
            int c = Integer.parseInt(txtNumeroC.getText());
            String resultado;
            if (a < b && b < c){
                resultado = "Ascendente";
            }else if (a > b && b >c){
                resultado = "Descendente";
            }else {
                resultado = "Desordenado";
            }

            txtResultado.setText(resultado);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Por favor, ingrese números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
