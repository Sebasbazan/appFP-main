package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm11 extends JFrame {

    private static final long serialVersionUID = 1L;
    JTextField txtNumero1, txtNumero2;
    JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm11 frame = new frm11();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm11() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        
        JLabel lblNumero1 = new JLabel("Número 1 (3 cifras):");
        lblNumero1.setBounds(50, 30, 120, 30);
        getContentPane().add(lblNumero1);

        txtNumero1 = new JTextField();
        txtNumero1.setBounds(180, 30, 100, 30);
        txtNumero1.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero1.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero1);

        
        JLabel lblNumero2 = new JLabel("Número 2 (3 cifras):");
        lblNumero2.setBounds(50, 80, 120, 30);
        getContentPane().add(lblNumero2);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(180, 80, 100, 30);
        txtNumero2.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero2.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero2);

        
        JButton btnIntercambiar = new JButton("Intercambiar");
        btnIntercambiar.setBounds(80, 130, 150, 30);
        getContentPane().add(btnIntercambiar);

        btnIntercambiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnIntercambiar_actionPerformed();
            }
        });

        
        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(50, 170, 250, 30);
        getContentPane().add(lblResultado);
    }

    protected void btnIntercambiar_actionPerformed() {
        
        String numero1 = txtNumero1.getText();
        String numero2 = txtNumero2.getText();

        
        if (numero1.length() == 3 && numero2.length() == 3) {
            
            char primera1 = numero1.charAt(0);
            char tercera1 = numero1.charAt(2);
            char primera2 = numero2.charAt(0);
            char tercera2 = numero2.charAt(2);

           
            String nuevoNumero1 = primera2 + numero1.substring(1, 2) + tercera1;
            String nuevoNumero2 = primera1 + numero2.substring(1, 2) + tercera2;

            lblResultado.setText("Resultado: " + nuevoNumero1 + " y " + nuevoNumero2);
        } else {
            lblResultado.setText("Por favor, ingrese números de 3 cifras.");
        }
    }
}