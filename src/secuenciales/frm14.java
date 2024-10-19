package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm14 extends JFrame {

    private static final long serialVersionUID = 1L;
    JTextField txtNum1, txtNum2, txtNum3, txtNum4, txtNum5;
    JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm14 frame = new frm14();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm14() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 320, 380);
        setLayout(null);
        setLocationRelativeTo(null);

       
        JLabel lblNum1 = new JLabel("Número 1:");
        lblNum1.setBounds(50, 30, 80, 30);
        getContentPane().add(lblNum1);

        txtNum1 = new JTextField();
        txtNum1.setBounds(150, 30, 100, 30);
        txtNum1.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNum1.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNum1);

        JLabel lblNum2 = new JLabel("Número 2:");
        lblNum2.setBounds(50, 70, 80, 30);
        getContentPane().add(lblNum2);

        txtNum2 = new JTextField();
        txtNum2.setBounds(150, 70, 100, 30);
        txtNum2.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNum2.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNum2);

        JLabel lblNum3 = new JLabel("Número 3:");
        lblNum3.setBounds(50, 110, 80, 30);
        getContentPane().add(lblNum3);

        txtNum3 = new JTextField();
        txtNum3.setBounds(150, 110, 100, 30);
        txtNum3.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNum3.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNum3);

        JLabel lblNum4 = new JLabel("Número 4:");
        lblNum4.setBounds(50, 150, 80, 30);
        getContentPane().add(lblNum4);

        txtNum4 = new JTextField();
        txtNum4.setBounds(150, 150, 100, 30);
        txtNum4.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNum4.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNum4);

        JLabel lblNum5 = new JLabel("Número 5:");
        lblNum5.setBounds(50, 190, 80, 30);
        getContentPane().add(lblNum5);

        txtNum5 = new JTextField();
        txtNum5.setBounds(150, 190, 100, 30);
        txtNum5.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNum5.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNum5);

       
        JButton btnCalcular = new JButton("Calcular Promedio");
        btnCalcular.setBounds(80, 230, 180, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });

        
        lblResultado = new JLabel("Promedio: ");
        lblResultado.setBounds(50, 260, 300, 30);
        getContentPane().add(lblResultado);
    }

    protected void btnCalcular_actionPerformed() {
        
        double num1 = Double.parseDouble(txtNum1.getText());
        double num2 = Double.parseDouble(txtNum2.getText());
        double num3 = Double.parseDouble(txtNum3.getText());
        double num4 = Double.parseDouble(txtNum4.getText());
        double num5 = Double.parseDouble(txtNum5.getText());

       
        double[] numeros = {num1, num2, num3, num4, num5};
        Arrays.sort(numeros);

       
        double sumaMayores = numeros[2] + numeros[3] + numeros[4];

        
        double promedio = sumaMayores / 3;

     
        lblResultado.setText("Promedio: " + String.format("%.2f", promedio));
    }
}
