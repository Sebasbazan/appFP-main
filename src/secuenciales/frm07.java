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

public class frm07 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtBase, txtAltura;
    JLabel lblAreaResultado, lblPerimetroResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm07 frame = new frm07();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm07(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        // Etiqueta y campo para la base

        JLabel lblBase = new JLabel("Base(b)");
        lblBase.setBounds(50, 50, 80, 30);
        getContentPane().add(lblBase);

        txtBase = new JTextField();
        txtBase.setBounds(130, 50, 100, 30);
        txtBase.setHorizontalAlignment(SwingConstants.RIGHT);
        txtBase.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtBase);

        // Etiqueta y campo para la altura 

        JLabel lblAltura = new JLabel("Altura(h)");
        lblAltura.setBounds(50, 100, 80, 30);
        getContentPane().add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(130, 100, 100, 30);
        txtAltura.setHorizontalAlignment(SwingConstants.RIGHT);
        txtAltura.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtAltura);

        //Boton para calcular 

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(80, 150, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });

        //Etiquetas para mostrar resultados 
        lblAreaResultado = new JLabel("Área: ");
        lblAreaResultado.setBounds(250, 50, 250, 30);
        getContentPane().add(lblAreaResultado);

        lblPerimetroResultado = new JLabel("Perimetro: ");
        lblPerimetroResultado.setBounds(250, 100, 250, 30);
        getContentPane().add(lblPerimetroResultado);

    }

    protected void btnCalcular_actionPerformed(){
        //Obtener los valores de entrada 
        double base = Double.parseDouble(txtBase.getText());
        double altura = Double.parseDouble(txtAltura.getText());

        // Calculo de area 
        double area = base * altura;

        // Calculo de perimetro

        double perimetro = 2 * (base + altura );

        // Mostrar los resultados 
        lblAreaResultado.setText("Area: " + String.format("%.2f", area));
        lblPerimetroResultado.setText("Perímetro: " + String.format("%.2f", perimetro));
    }

}
