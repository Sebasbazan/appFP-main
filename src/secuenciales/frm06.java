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

public class frm06 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtRadio, txtAltura;
    JLabel lblAreaResultado, lblVolumenResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    frm06 frame = new frm06();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm06(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 550, 270);
        setLayout(null);
        setLocationRelativeTo(null);

       

        JLabel lblRadio = new JLabel("Radio(r)");
        lblRadio.setBounds(50, 50, 80, 30);
        getContentPane().add(lblRadio);

        txtRadio = new JTextField();
        txtRadio.setBounds(130, 50, 100, 30);
        txtRadio.setHorizontalAlignment(SwingConstants.RIGHT);
        txtRadio.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtRadio);

       
        
        JLabel lblAltura = new JLabel("Altura(h)");
        lblAltura.setBounds(50, 100, 80, 30);
        getContentPane().add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(130, 100, 100, 30);
        txtAltura.setHorizontalAlignment(SwingConstants.RIGHT);
        txtAltura.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtAltura);

        

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(80, 150, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                btnCalcular_actionPerformed();
            }
        });

       

        lblAreaResultado = new JLabel("Área: ");
        lblAreaResultado.setBounds(250, 50, 250, 30);
        getContentPane().add(lblAreaResultado);

        lblVolumenResultado = new JLabel("Volumen: ");
        lblVolumenResultado.setBounds(250, 100, 250, 30);
        getContentPane().add(lblVolumenResultado);

    }

    protected void btnCalcular_actionPerformed(){

        
        double radio = Double.parseDouble(txtRadio.getText());
        double altura = Double.parseDouble(txtAltura.getText());

         
        double area = 2 * Math.PI * radio * (radio + altura);

       
        double volumen = Math.PI * Math.pow(radio, 2) * altura;



        

        lblAreaResultado.setText("Área: " + String.format("%.2f", area));
        lblVolumenResultado.setText("Volumen: " + String.format("%.2f", volumen));


    }
    
}
