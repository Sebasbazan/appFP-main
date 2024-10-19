package secuenciales;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class frm12 extends JFrame {

    private static final long serialVersionUID = 1L;
    JTextField txtA, txtB, txtC;
    JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm12 frame = new frm12();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm12() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        
        JLabel lblA = new JLabel("Coeficiente a:");
        lblA.setBounds(50, 30, 120, 30);
        getContentPane().add(lblA);

        txtA = new JTextField();
        txtA.setBounds(180, 30, 100, 30);
        getContentPane().add(txtA);

        JLabel lblB = new JLabel("Coeficiente b:");
        lblB.setBounds(50, 80, 120, 30);
        getContentPane().add(lblB);

        txtB = new JTextField();
        txtB.setBounds(180, 80, 100, 30);
        getContentPane().add(txtB);

        JLabel lblC = new JLabel("Coeficiente c:");
        lblC.setBounds(50, 130, 120, 30);
        getContentPane().add(lblC);

        txtC = new JTextField();
        txtC.setBounds(180, 130, 100, 30);
        getContentPane().add(txtC);

        
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(80, 180, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });

       
        lblResultado = new JLabel("Resultados: ");
        lblResultado.setBounds(50, 230, 300, 30);
        getContentPane().add(lblResultado);
    }

    protected void btnCalcular_actionPerformed() {
       
        double a = Double.parseDouble(txtA.getText());
        double b = Double.parseDouble(txtB.getText());
        double c = Double.parseDouble(txtC.getText());

        
        double discriminante = b * b - 4 * a * c;

        
        if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            lblResultado.setText("Raíces: x1 = " + String.format("%.2f", x1) + ", x2 = " + String.format("%.2f", x2));
        } else if (discriminante == 0) {
            double x = -b / (2 * a);
            lblResultado.setText("Raíz doble: x = " + String.format("%.2f", x));
        } else {
            lblResultado.setText("No hay raíces reales.");
        }
    }
}